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
    private Integer supplierId; // Khóa chính

    @Column(nullable = false)
    private String supplierName;

    @Column(nullable = false)
    private String contactInfo;
}