package com.example.storageApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column
    private String uname;

    @Column
    private String upassword;

    @Column
    private String ufullName;

    @Column
    private String uphone;

    @Column
    private String urole;

    @Column
    private String ustatus;

}
