package com.example.storageApp.controller;

import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.service.ProductService;
import com.example.storageApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getValidProducts();
    }
}
