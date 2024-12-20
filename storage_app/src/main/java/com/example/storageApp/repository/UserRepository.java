package com.example.storageApp.repository;
import com.example.storageApp.dto.UserNameDTO;
import com.example.storageApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
    Optional<Users> findUserByUname(String uname);
    @Query("SELECT new com.example.storageApp.dto.UserNameDTO(u.uname) FROM Users u")
    List<UserNameDTO> getAllUserNames();


}
