package com.mistymorning.housekeeper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistymorning.housekeeper.classes.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);
    
    @Override
    void delete(User user);
}