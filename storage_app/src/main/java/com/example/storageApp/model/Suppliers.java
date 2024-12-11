package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @Column(nullable = false)
    private String sName;

    @Column(nullable = false)
    private String sEmail;

    @Column(nullable = false)
    private String sPhone;

    @Column(nullable = false)
    private String sAddress;

    @Column(nullable = false)
    private Integer sType;

    @Column(nullable = false)
    private Integer sStatus;
}