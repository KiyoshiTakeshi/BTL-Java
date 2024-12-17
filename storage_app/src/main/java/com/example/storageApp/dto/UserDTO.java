package com.example.storageApp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer uId;
    private String uName;
    private String uPassword;
    private String uFullName;
    private String uPhone;
    private String uRole;
}
