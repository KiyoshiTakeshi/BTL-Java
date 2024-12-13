package com.example.storageApp.controller;

import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<SupplierDTO> getSuppliers() {
        return supplierService.getValidSuppliers();
    }
}

