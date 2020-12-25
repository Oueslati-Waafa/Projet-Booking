package com.booking.project.controllers;


        import com.booking.project.models.Reservation;
        import com.booking.project.repository.ReservationRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import java.util.ArrayList;
        import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getallReservations(@RequestParam(required = false) String destination) {
        try {
            List<Reservation> reservations = new ArrayList<>();

            if (destination == null)
                reservationRepository.findAll().forEach(reservations::add);
            else
                reservationRepository.findByDestination(destination).forEach(reservations::add);

            if (reservations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @PostMapping("/add")
    public ResponseEntity<?> createTutorial(@Valid @RequestBody AddReservationRequest addReservationRequest) {

        if (reservationRepository.existsById(addReservationRequest.getDestination())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Your request is already Passed!"));
        }

        Reservation reservation = new Reservation(addReservationRequest.getDestination(),
                addReservationRequest.getCheckin(),
                addReservationRequest.getCheckout(),
                addReservationRequest.getNbrAdult(),
                addReservationRequest.getNbrChildren());

        reservationRepository.save(reservation);

        return ResponseEntity.ok(new MessageResponse(" Reservation Added Successfully ! "));
        }*/

    @PostMapping("/add")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation _reservation = reservationRepository.save(new Reservation(
                    reservation.getDestination(),
                    reservation.getCheckin(),
                    reservation.getCheckout(),
                    reservation.getNbrAdult(),
                    reservation.getNbrChildren()

                    ));
            return new ResponseEntity<>(_reservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        }
