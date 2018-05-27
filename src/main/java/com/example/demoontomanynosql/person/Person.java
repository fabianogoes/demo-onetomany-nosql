package com.example.demoontomanynosql.person;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class Person {
    private String id;
    private String name;
    private String ssn;
    private List<Address> addresses;
    // Getters and Setters...
}
