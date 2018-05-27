package com.example.demoontomanynosql.log;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMessageRepository extends MongoRepository<LogMessage, String> {
    List<LogMessage> findByHost(Host host);
}
