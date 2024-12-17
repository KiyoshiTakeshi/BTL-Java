package com.example.storageApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierDTO {
    private Integer sId;
    private String sName;
    private String sEmail;
    private String sPhone;
    private String sAddress;
    private String sType;
}
