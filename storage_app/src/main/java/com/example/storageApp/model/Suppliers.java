package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @Column
    private String sname;

    @Column
    private String semail;

    @Column
    private String sphone;

    @Column
    private String saddress;

    @Column
    private String stype;

    @Column
    private Integer sstatus;

//    @OneToMany(mappedBy = "suppliers")
//    private List<Transactions> transactions;
}