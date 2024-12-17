package com.example.storageApp.controller;

import com.example.storageApp.dto.UserDTO;
import com.example.storageApp.model.Users;
import com.example.storageApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    // Đăng ký người dùng mới
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        try {
            // Kiểm tra nếu người dùng đã tồn tại
            if (userService.findUserByName(userDTO.getUName()) != null) {
                return new ResponseEntity<>("Username already exists. Please choose a different username.", HttpStatus.BAD_REQUEST);
            }

            // Thêm người dùng vào cơ sở dữ liệu
            userService.addUser(userDTO);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.severe("Error registering user: " + e.getMessage());
            e.printStackTrace();  // In ra thông tin chi tiết về lỗi
            return new ResponseEntity<>("An error occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Lấy thông tin người dùng theo tên
    @GetMapping("/find/{uname}")
    public ResponseEntity<Users> getUserByName(@PathVariable String uname) {
        Users user = userService.findUserByName(uname);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
