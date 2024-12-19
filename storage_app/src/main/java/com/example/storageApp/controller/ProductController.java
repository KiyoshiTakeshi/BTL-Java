package com.example.storageApp.controller;

import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.model.Products;
import com.example.storageApp.service.ProductService;
import com.example.storageApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/category/{cid}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Integer cid) {
        List<ProductDTO> products = productService.getProductsByCategory(cid);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Products newProduct) {
        productService.addProduct(newProduct);
        return ResponseEntity.ok("Product added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
