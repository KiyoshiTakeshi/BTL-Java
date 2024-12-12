package com.example.storageApp.service;

import com.example.storageApp.dto.UserDTO;
import com.example.storageApp.model.Users;
import com.example.storageApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;
//
//    // Xác thực người dùng đăng nhập
//    public boolean authenticate(UserDTO loginDTO) {
//        Optional<Users> userOpt = userRepository.findByUName(loginDTO.getUName());
//
//        if (userOpt.isPresent()) {
//            Users uname = userOpt.get();
//            return uname.getUpassword().equals(loginDTO.getUPassword());
//        }
//        return false;
//    }
}
