package com.example.storageApp.service;

import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getValidProducts() {
        List<ProductDTO> products = productRepository.findProductData();
        return products.stream()
                .map(product -> new ProductDTO(
                        product.getPId(),
                        product.getPName(),
                        product.getPDescribe(),
                        product.getPPrice(),
                        product.getPQuantity()
                ))
                .collect(Collectors.toList());
    }
}
