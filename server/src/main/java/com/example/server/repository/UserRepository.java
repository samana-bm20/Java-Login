package com.example.server.repository;

import com.example.server.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query to find a user by their username
    Optional<User> findByUsername(String username);
}