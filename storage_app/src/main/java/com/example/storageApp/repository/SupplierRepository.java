package com.example.storageApp.repository;
import com.example.storageApp.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
    @Query("SELECT s FROM Suppliers s WHERE s.stype = :stype AND s.sstatus = 1")
    List<Suppliers> findSuppliersByType(@Param("stype") String stype);
}

