package com.example.storageApp.repository;
import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
    @Query("SELECT new com.example.storageApp.dto.SupplierDTO(s.sid, s.sname, s.semail, s.sphone, s.saddress, " +
            "CASE WHEN s.stype = 0 THEN 'Nhà cung cấp' ELSE 'Đại lý phân phối' END) " +
            "FROM Suppliers s WHERE s.sstatus = 1")
    List<SupplierDTO> findValidData();
}

