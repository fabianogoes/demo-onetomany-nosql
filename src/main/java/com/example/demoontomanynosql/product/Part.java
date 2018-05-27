package com.example.demoontomanynosql.product;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Part {
    @Id
    private String id;
    private String partNo;
    private String name;
    private int qty;
    private double cost;
    private double price;
    // Getters and Setters...
}
