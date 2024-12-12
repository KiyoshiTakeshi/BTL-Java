package com.example.storageApp.repository;

import com.example.storageApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
//    Optional<Users> findByUName(String uname);
}
