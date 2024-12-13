package com.example.storageApp.repository;
import com.example.storageApp.dto.ProductDTO;
import com.example.storageApp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByCategoryCid(Integer cid);
    @Modifying
    @Query("UPDATE Products p SET p.pstatus = 0 WHERE p.pid = :id")
    void softDeleteById(@Param("id") Integer id);

}