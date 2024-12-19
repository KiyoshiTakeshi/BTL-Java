package com.example.storageApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierDTO {
    private Integer sid;
    private String sname;
    private String semail;
    private String sphone;
    private String saddress;
    private String stype;
    private Integer sstatus;
}
