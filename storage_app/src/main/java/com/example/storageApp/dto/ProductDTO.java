package com.example.storageApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Integer pid;
    private String pname;
    private String pdescribe;
    private Double pprice;
    private Integer pquantity;
    private Integer pstatus;
    private Integer cid;
}
