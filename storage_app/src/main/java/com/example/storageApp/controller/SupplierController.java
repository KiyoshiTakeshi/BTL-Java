package com.example.storageApp.controller;

import com.example.storageApp.dto.SupplierDTO;
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

    @GetMapping
    public List<SupplierDTO> getSuppliers() {
        return supplierService.getValidSuppliers();
    }

    @PostMapping
    public ResponseEntity<String> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        supplierService.addSupplier(supplierDTO);
        return ResponseEntity.ok("Supplier created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO supplierDTO) {
        supplierService.updateSupplier(id, supplierDTO);
        return ResponseEntity.ok("Supplier updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        supplierService.softDeleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}

