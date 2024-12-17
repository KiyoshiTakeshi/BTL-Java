//package com.example.storageApp.service;
//import com.example.storageApp.model.Users;
//import com.example.storageApp.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public Users findByUName(String uName) {
//        return userRepository.findByUserName(uName).orElse(null);
//    }
//
//    public boolean validatePassword(String rawPassword, String storedPassword) {
//        return rawPassword.equals(storedPassword);    }
//}
