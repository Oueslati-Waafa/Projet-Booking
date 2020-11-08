package com.booking.project.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.project.models.ERole;
import com.booking.project.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
