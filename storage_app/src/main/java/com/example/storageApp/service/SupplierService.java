package com.example.storageApp.service;

import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.model.Suppliers;
import com.example.storageApp.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Lấy danh sách nhà cung cấp hợp lệ
    public List<SupplierDTO> getValidSuppliers() {
        List<Suppliers> suppliers = supplierRepository.findValidData();
        return suppliers.stream()
                .map(supplier -> new SupplierDTO(
                        supplier.getSId(),
                        supplier.getSName(),
                        supplier.getSEmail(),
                        supplier.getSPhone(),
                        supplier.getSAddress(),
                        supplier.getSType() == 0 ? "Nhà cung cấp" : "Đại lý phân phối"
                ))
                .collect(Collectors.toList());
    }
}
