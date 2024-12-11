package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false)
    private String uName;

    @Column(nullable = false)
    private String uPassword;

    @Column(nullable = false)
    private String uFullName;

    @Column(nullable = false)
    private String uPhone;

    @Column(nullable = false)
    private String uRole;

    @Column(nullable = false)
    private String uStatus;

}
