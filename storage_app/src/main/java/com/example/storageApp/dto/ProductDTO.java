package com.example.storageApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Integer pId;
    private String pName;
    private String pDescribe;
    private Double pPrice;
    private Integer pQuantity;
}
