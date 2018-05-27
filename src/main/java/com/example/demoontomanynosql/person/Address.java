package com.example.demoontomanynosql.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String city;
    private String cc;
    // Getters and Setters...
}
