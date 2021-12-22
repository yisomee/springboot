package com.example.test.repository;

// import java.util.Optional;

import com.example.test.model.YssUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface YssUserRepository extends JpaRepository<YssUser, Long>{
    YssUser findByUserName(String userName);    
}
