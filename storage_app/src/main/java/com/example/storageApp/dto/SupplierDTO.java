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

    public Integer getSid() {
        return sId;
    }

    public String getSname() {
        return sName;
    }

    public String getSemail() {
        return sEmail;
    }

    public String getSphone() {
        return sPhone;
    }

    public String getSaddress() {
        return sAddress;
    }

    public int getStype() {
        return 1;
    }

}
