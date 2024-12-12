package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column
    private String pname;

    @Column
    private String pdescribe;

    @Column
    private Double pprice;

    @Column
    private Integer pquantity;

    @Column
    private Integer pstatus;
}