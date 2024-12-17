package com.example.storageApp.service;

import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.model.Products;
import com.example.storageApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getProductsByCategory(Integer cid) {
        return productRepository.findByCategoryCid(cid);
    }

    public void addProduct(Products newProduct) {
        // Lưu sản phẩm mới vào cơ sở dữ liệu
        Products newProduct1 = new Products();
        newProduct.setPname(newProduct1.getPname());
        newProduct.setPdescribe(newProduct1.getPdescribe());
        newProduct.setPprice(newProduct1.getPprice());
        newProduct.setPquantity(newProduct1.getPquantity());
        newProduct.setPstatus(1);
        productRepository.save(newProduct1);
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(Integer id, ProductDTO productDTO) {
        Products existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        // Cập nhật thông tin sản phẩm
        existingProduct.setPname(productDTO.getPName());
        existingProduct.setPdescribe(productDTO.getPDescribe());
        existingProduct.setPprice(productDTO.getPPrice());
        existingProduct.setPquantity(productDTO.getPQuantity());

        productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        Products existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        // Cập nhật trạng thái pstatus thành 0 (soft delete)
        existingProduct.setPstatus(0);

        // Lưu lại thay đổi trong cơ sở dữ liệu
        productRepository.save(existingProduct);
    }
}
