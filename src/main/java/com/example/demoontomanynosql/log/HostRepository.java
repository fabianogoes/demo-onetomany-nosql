package com.example.demoontomanynosql.log;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository
        extends MongoRepository<Host, String> {
}
