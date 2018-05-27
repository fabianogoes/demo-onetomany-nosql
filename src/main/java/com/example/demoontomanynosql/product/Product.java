package com.example.demoontomanynosql.product;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String manufacturer;
    private int catalogNumber;
    @DBRef
    private List<Part> parts;
    // Getters and Setters...
}
