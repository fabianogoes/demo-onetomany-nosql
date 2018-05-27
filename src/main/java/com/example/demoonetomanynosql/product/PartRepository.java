package com.example.demoonetomanynosql.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository
        extends MongoRepository<Part, String> {
}
