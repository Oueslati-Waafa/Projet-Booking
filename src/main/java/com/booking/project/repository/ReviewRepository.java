package com.booking.project.repository;


import com.booking.project.models.Rating;
import com.booking.project.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {

    Optional<Review> findByRating(Rating name);
}
