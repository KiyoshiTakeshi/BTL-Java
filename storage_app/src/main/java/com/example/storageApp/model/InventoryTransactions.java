package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InventoryTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(nullable = false)
    private Integer transactionType;

    @Column(nullable = false)
    private Integer transactionQuantity;

    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private String transactions_note;
}
