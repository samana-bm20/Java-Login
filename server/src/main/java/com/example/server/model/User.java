package com.example.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")  // Maps this class to the "users" collection in MongoDB
public class User {
    @Id  // Marks the id field as the primary key
    private String id;
    private String username;
    private String password;
    private String name;

     // Manually adding getters for now
     public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
