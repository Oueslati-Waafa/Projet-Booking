package com.booking.project.repository;



import com.booking.project.models.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation,String> {

    boolean existsById(String Id);
    List<Reservation> findByDestination(String destination);

}
