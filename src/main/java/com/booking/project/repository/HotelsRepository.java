package com.booking.project.repository;

import com.booking.project.models.Hotel;
import com.booking.project.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HotelsRepository extends MongoRepository<Hotel,String> {

    Boolean existsByName(String name);
    List<Hotel> findByName(String name);

}
