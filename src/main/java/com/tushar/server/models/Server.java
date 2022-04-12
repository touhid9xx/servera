package com.tushar.server.models;

import com.tushar.server.models.enumuration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address can not empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String imageUrl;
    private String type;
    private Status status;
}
