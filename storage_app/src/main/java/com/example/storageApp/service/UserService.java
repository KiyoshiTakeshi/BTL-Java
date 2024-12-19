package com.example.storageApp.service;

import com.example.storageApp.dto.UserDTO;
import com.example.storageApp.model.Users;
import com.example.storageApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser (UserDTO userDTO){
        Users users = new Users();
        users.setUid(userDTO.getUId());
        users.setUname(userDTO.getUName());
        users.setUpassword(userDTO.getUPassword());
        users.setUfullname(userDTO.getUFullName());
        users.setUrole("NV");
        users.setUstatus(1);
        userRepository.save(users);
    }

    public Users findUserByName(String uname) {
        return userRepository.findUserByUname(uname).orElse(null);
    }

    public boolean validatePassword(String rawPassword, String storedPassword) {
        return rawPassword.equals(storedPassword);    }
}
