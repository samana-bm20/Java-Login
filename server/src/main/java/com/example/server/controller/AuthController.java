package com.example.server.controller;

import com.example.server.model.User;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController  // Marks this class as a REST controller (which returns JSON responses)
@RequestMapping("/api/auth")  // The base URL for all endpoints in this controller is "/api/auth"
@CrossOrigin(origins = "http://localhost:5173")  // Add this to allow CORS for specific origins
public class AuthController {

    @Autowired
    private UserService userService;  // Injects the UserService to handle business logic

    @PostMapping("/login")  // Handles HTTP POST requests at "/api/auth/login"
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // Calls the authenticate method of UserService to check credentials
        Optional<User> user = userService.authenticate(request.getUsername(), request.getPassword());

        // If user is found and authenticated
        if (user.isPresent()) {
            return ResponseEntity.ok("Hello, " + user.get().getName());  // Return greeting message
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");  // If credentials are wrong
        }
    }

    // Inner class to map incoming JSON to a Java object
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
