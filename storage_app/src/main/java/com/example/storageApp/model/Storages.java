package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Storages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer strId;


    @Column(nullable = false)
    private String strName;

    @Column(nullable = false)
    private String strLocation;

    @Column(nullable = false)
    private Integer strStatus;
}
