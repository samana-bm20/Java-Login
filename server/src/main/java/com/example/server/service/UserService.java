package com.example.server.service;

import com.example.server.model.User;
import com.example.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Marks this class as a service component for Spring to manage
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Injects UserRepository to interact with the database

    // This method is responsible for authenticating the user
    public Optional<User> authenticate(String username, String password) {
        // Finds the user in the database by username
        Optional<User> user = userRepository.findByUsername(username);

        // If the user is found and the password matches, return the user, else return empty
        return user.filter(u -> u.getPassword().equals(password));  // Compare passwords (in real apps, passwords should be hashed)
    }
}
