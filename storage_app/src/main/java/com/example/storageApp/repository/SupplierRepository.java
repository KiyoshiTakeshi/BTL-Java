package com.example.storageApp.repository;
import com.example.storageApp.dto.AreaDTO;
import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.dto.SupplierNameDTO;
import com.example.storageApp.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
    @Query("SELECT new com.example.storageApp.dto.SupplierDTO(s.sid, s.sname, s.semail, s.sphone, s.saddress, s.stype, s.sstatus) " +
            "FROM Suppliers s WHERE s.stype = :stype AND s.sstatus = 1")
    List<SupplierDTO> findSuppliersByType(@Param("stype") String stype);

    @Query("SELECT new com.example.storageApp.dto.SupplierNameDTO(s.sname, s.stype) FROM Suppliers s WHERE s.stype = :stype")
    List<SupplierNameDTO> getAllSupplierNamesByType(@Param("stype") String stype);

    @Query("SELECT new com.example.storageApp.dto.AreaDTO(s.sid, s.sname, s.saddress, s.scity, s.sdistrict) FROM Suppliers s ")
    List<AreaDTO> getAllSupplierAddress();
}

