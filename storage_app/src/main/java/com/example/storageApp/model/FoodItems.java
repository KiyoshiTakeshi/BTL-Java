package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @Column(nullable = false)
    private String fName;

    @Column(nullable = false)
    private String fDescribe;

    @Column(nullable = false)
    private Double fPrice;

    @Column(nullable = false)
    private Integer fQuantity;

    @Column(nullable = false)
    private Integer fStatus;
}