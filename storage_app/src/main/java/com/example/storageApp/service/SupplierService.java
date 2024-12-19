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

    public List<SupplierDTO> getSuppliersByType(String stype) {
        return supplierRepository.findSuppliersByType(stype);
    }

    public void addSupplier(SupplierDTO supplierDTO) {
        Suppliers supplier = new Suppliers();
        supplier.setSname(supplierDTO.getSname());
        supplier.setSemail(supplierDTO.getSemail());
        supplier.setSphone(supplierDTO.getSphone());
        supplier.setSaddress(supplierDTO.getSaddress());
        supplier.setStype(supplierDTO.getStype());
        supplier.setSstatus(1);
        supplierRepository.save(supplier);
    }

    public void updateSupplier(Integer id, SupplierDTO supplierDTO) {
        Suppliers existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with id: " + id));

        existingSupplier.setSname(supplierDTO.getSname());
        existingSupplier.setSemail(supplierDTO.getSemail());
        existingSupplier.setSphone(supplierDTO.getSphone());
        existingSupplier.setSaddress(supplierDTO.getSaddress());
        existingSupplier.setStype(supplierDTO.getStype());

        supplierRepository.save(existingSupplier);
    }

    public void softDeleteSupplier(Integer id) {
        Suppliers existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with id: " + id));

        existingSupplier.setSstatus(0);
        supplierRepository.save(existingSupplier);
    }
}
