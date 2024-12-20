package com.example.storageApp.service;

import com.example.storageApp.dto.AreaDTO;
import com.example.storageApp.dto.SupplierDTO;
import com.example.storageApp.dto.SupplierNameDTO;
import com.example.storageApp.model.Suppliers;
import com.example.storageApp.repository.SupplierRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private static final String GPT_API_URL = "https://api-inference.huggingface.co/models/gpt2";
    private static final String GPT_API_KEY = "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";
    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierDTO> getSuppliersByType(String stype) {
        return supplierRepository.findSuppliersByType(stype);
    }

    public List<SupplierNameDTO> getAllSupplierNamesByType(String stype) {
        return supplierRepository.getAllSupplierNamesByType(stype);
    }

    public Map<String, String> parseAddress(String saddress) {
        RestTemplate restTemplate = new RestTemplate();
        String prompt = "Phân tích: \"" + saddress + "\". Trả về JSON với city và district.";

        // API URL và API Key cho Hugging Face GPT-2 model
        String huggingFaceApiUrl = "https://api-inference.huggingface.co/models/gpt2";

        // Cấu trúc request body theo yêu cầu của Hugging Face
        Map<String, Object> requestBody = Map.of(
                "inputs", prompt  // Cấu trúc yêu cầu với trường 'inputs'
        );

        // Cấu hình HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + GPT_API_KEY);
        headers.set("Content-Type", "application/json");

        // Tạo HttpEntity với body và headers
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            // Gửi yêu cầu POST đến Hugging Face API và nhận phản hồi
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    huggingFaceApiUrl,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<List<Map<String, Object>>>() {} // Đảm bảo nhận phản hồi dưới dạng List
            );

            // In ra phản hồi để kiểm tra cấu trúc của nó
            System.out.println(response.getBody());

            // Lấy kết quả từ phản hồi
            if (response.getBody() != null && !response.getBody().isEmpty()) {
                Map<String, Object> resultMap = response.getBody().get(0); // Lấy đối tượng đầu tiên trong danh sách
                String result = (String) resultMap.get("generated_text");

                // Trả về kết quả đã phân tích (trong trường hợp này là JSON)
                return new ObjectMapper().readValue(result, Map.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi, trả về city và district mặc định
            return Map.of("city", "N/A", "district", "N/A");
        }

        return Map.of("city", "N/A", "district", "N/A");  // Nếu không có dữ liệu
    }




    // Hàm lấy tất cả địa chỉ và phân tích bằng AI
    public List<AreaDTO> getAllSupplierAddress() {
        List<AreaDTO> suppliers = supplierRepository.getAllSupplierAddress();

        // Gọi GPT API để phân tích địa chỉ
        suppliers.forEach(supplier -> {
            Map<String, String> parsedAddress = parseAddress(supplier.getSaddress());
            supplier.setScity(parsedAddress.get("city"));
            supplier.setSdistrict(parsedAddress.get("district"));
        });
        return suppliers;
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
