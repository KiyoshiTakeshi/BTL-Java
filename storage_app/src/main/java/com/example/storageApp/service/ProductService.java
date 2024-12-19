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

    public List<ProductDTO> getAllProducts() {
        List<Products> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductDTO(
                        product.getPid(),
                        product.getPname(),
                        product.getPdescribe(),
                        product.getPprice(),
                        product.getPquantity(),
                        product.getPstatus(),
                        product.getCategory() != null ? product.getCategory().getCid() : null))
                .collect(Collectors.toList());
    }


    public List<ProductDTO> getProductsByCategory(Integer cid) {
        return productRepository.findByCategoryCid(cid);
    }

    public void addProduct(Products newProduct) {
        // Lưu sản phẩm mới vào cơ sở dữ liệu
        newProduct.setPname(newProduct.getPname());
        newProduct.setPdescribe(newProduct.getPdescribe());
        newProduct.setPprice(newProduct.getPprice());
        newProduct.setPquantity(newProduct.getPquantity());
        newProduct.setPstatus(1);
        productRepository.save(newProduct);
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(Integer id, ProductDTO productDTO) {
        Products existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        // Cập nhật thông tin sản phẩm
        existingProduct.setPname(productDTO.getPname());
        existingProduct.setPdescribe(productDTO.getPdescribe());
        existingProduct.setPprice(productDTO.getPprice());
        existingProduct.setPquantity(productDTO.getPquantity());

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
