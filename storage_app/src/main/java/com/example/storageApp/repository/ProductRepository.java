package com.example.storageApp.repository;
import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query("SELECT new com.example.storageApp.dto.ProductDTO(p.pid, p.pname, p.pdescribe, p.pprice, p.pquantity) " +
            "FROM Products p WHERE p.pstatus = 1")
    List<ProductDTO> findProductData();
}