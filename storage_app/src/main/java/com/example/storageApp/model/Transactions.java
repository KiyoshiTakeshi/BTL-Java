package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column(nullable = false)
    private String ttype;

    @Column(nullable = false)
    private Integer tquantity;

    @Column(nullable = false)
    private Integer ttotal;

    @Column(nullable = false)
    private String tnote;

    @Column(nullable = false)
    private Date tdate;

    @Column(nullable = false)
    private Integer tstatus;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "uid")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Suppliers suppliers;

}
