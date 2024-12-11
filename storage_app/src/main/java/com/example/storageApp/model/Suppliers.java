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
    private Integer sid;

    @Column(nullable = false)
    private String sname;

    @Column(nullable = false)
    private String semail;

    @Column(nullable = false)
    private String sphone;

    @Column(nullable = false)
    private String saddress;

    @Column(nullable = false)
    private Integer stype;

    @Column(nullable = false)
    private Integer sstatus;
}