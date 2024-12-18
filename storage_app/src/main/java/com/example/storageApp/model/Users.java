package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String uname;

    @Column(nullable = false)
    private String upassword;

    @Column(nullable = false)
    private String ufullName;

    @Column(nullable = false)
    private String uphone;

    @Column(nullable = false)
    private String urole;

    @Column(nullable = false)
    private Integer ustatus;

//    @OneToMany(mappedBy = "users")
//    private List<Transactions> transactions;
}
