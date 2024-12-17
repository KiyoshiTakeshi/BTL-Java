package com.example.storageApp.controller;

import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.model.Products;
import com.example.storageApp.model.Suppliers;
import com.example.storageApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{stype}")
    public ResponseEntity<List<Suppliers>> getSuppliersByType(@PathVariable String stype) {
        List<Suppliers> suppliers = supplierService.getSuppliersByType(stype);
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping
    public ResponseEntity<String> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        if (supplierDTO.getSName() == null || supplierDTO.getSEmail() == null) {
            return ResponseEntity.badRequest().body("Name and Email are required");
        }

        supplierService.addSupplier(supplierDTO);
        return ResponseEntity.ok("Supplier created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO supplierDTO) {
        try {
            supplierService.updateSupplier(id, supplierDTO);
            return ResponseEntity.ok("Supplier updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        try {
            supplierService.softDeleteSupplier(id);
            return ResponseEntity.ok("Supplier deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


