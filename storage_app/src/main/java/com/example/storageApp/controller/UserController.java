package com.example.storageApp.controller;

import com.example.storageApp.dto.UserDTO;
import com.example.storageApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public String login(@RequestBody UserDTO userDTODTO) {
//        boolean authenticated = userService.authenticate(userDTODTO);
//
//        if (authenticated) {
//            return "Login successful!";
//        } else {
//            return "Invalid username or password!";
//        }
//    }
}
