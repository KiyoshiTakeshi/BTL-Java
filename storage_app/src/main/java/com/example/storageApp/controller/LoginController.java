package com.example.storageApp.controller;

import com.example.storageApp.dto.LoginDTO;
import com.example.storageApp.model.Users;
import com.example.storageApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute LoginDTO loginRequest, Model model) {
        Users user = userService.findUserByName(loginRequest.getUName());

        if (user != null && userService.validatePassword(loginRequest.getUPassword(), user.getUpassword())) {
            // Đăng nhập thành công
            model.addAttribute("message", "Login successful!");
            return "redirect:/home"; // Điều hướng đến trang chính
        } else {
            // Đăng nhập thất bại
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Quay lại trang đăng nhập
        }
    }
}
