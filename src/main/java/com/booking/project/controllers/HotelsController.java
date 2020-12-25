package com.booking.project.controllers;

import com.booking.project.models.*;
import com.booking.project.payload.request.AddHotelRequest;
import com.booking.project.payload.response.MessageResponse;
import com.booking.project.repository.HotelsRepository;
import com.booking.project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.booking.project.payload.response.MessageResponse;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/hotels")
public class HotelsController {

    @Autowired
    HotelsRepository hotelsRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getallHotels(@RequestParam(required = false) String name) {
        try {
            List<Hotel> hotels = new ArrayList<>();

            if (name == null)
                hotelsRepository.findAll().forEach(hotels::add);
            else
                hotelsRepository.findByName(name).forEach(hotels::add);

            if (hotels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(hotels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createHotel(@Valid @RequestBody AddHotelRequest addHotelRequest) {

        if (hotelsRepository.existsByName(addHotelRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Hotel name is already taken!"));
        }

        Hotel hotel = new Hotel(addHotelRequest.getName(),
                addHotelRequest.getPrice(),
                addHotelRequest.getAddress());

        Set<String> strReviews = addHotelRequest.getReviewList();
        Set<Review> reviews = new HashSet<>();

        if (strReviews == null)
        {
            Review review = reviewRepository.findByRating(Rating.AVERAGE)
                    .orElseThrow(()-> new RuntimeException("Error : Rating is not found."));
            reviews.add(review);

        }else {
            strReviews.forEach(review -> {
                switch (review) {
                    case "exceptional":
                        Review exceptionalReview = reviewRepository.findByRating(Rating.EXCEPTIONAL)
                                .orElseThrow(() -> new RuntimeException("Error: Rating is not found."));
                        reviews.add(exceptionalReview);

                        break;
                    case "good":
                        Review goodReview = reviewRepository.findByRating(Rating.GOOD)
                                .orElseThrow(() -> new RuntimeException("Error: Rating is not found."));
                        reviews.add(goodReview);

                        break;
                    case "average":
                        Review averageReview = reviewRepository.findByRating(Rating.AVERAGE)
                                .orElseThrow(() -> new RuntimeException("Error: Rating is not found."));
                        reviews.add(averageReview);

                        break;
                    default:
                        Review poorReview = reviewRepository.findByRating(Rating.POOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        reviews.add(poorReview);
                }
            });
        }
       hotel.setReviewList(reviews);
        hotelsRepository.save(hotel);

        return ResponseEntity.ok(new MessageResponse("Hotel Added Successfully ! "));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String id) {
        Optional<Hotel> hotelData = hotelsRepository.findById(id);

        if (hotelData.isPresent()) {
            return new ResponseEntity<>(hotelData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteHotel(@PathVariable("id") String id) {
        try {
            hotelsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") String id, @RequestBody Hotel hotel) {
        Optional<Hotel> hotelData = hotelsRepository.findById(id);

        if (hotelData.isPresent()) {
            Hotel _hotel = hotelData.get();
            _hotel.setName(hotel.getName());
            _hotel.setPrice(hotel.getPrice());
            _hotel.setAddress(hotel.getAddress());
            _hotel.setReviewList(hotel.getReviewList());

            return new ResponseEntity<>(hotelsRepository.save(_hotel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
