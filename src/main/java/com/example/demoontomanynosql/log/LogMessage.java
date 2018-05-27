package com.example.demoontomanynosql.log;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class LogMessage {
    @Id
    private String id;
    private Date time;
    private String message;
    @DBRef
    private Host host;
    // Getters and Setters...
}
