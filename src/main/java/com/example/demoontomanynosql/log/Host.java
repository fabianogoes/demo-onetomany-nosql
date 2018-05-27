package com.example.demoontomanynosql.log;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@Document
public class Host {
    @Id
    private String id ;
    private String name;
    private String ipaddr;
    // Getters and Setters...
}
