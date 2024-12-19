package com.example.storageApp.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO {
    private Integer tid;
    private String pname;
    private String uname;
    private String sname;
    private String ttype;
    private Integer tquantity;
    private String tnote;
    private Date tdate;
    private Integer tstatus;
}
