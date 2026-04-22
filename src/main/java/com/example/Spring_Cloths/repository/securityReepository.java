package com.example.Spring_Cloths.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_Cloths.models.users;
@Repository
public interface securityReepository extends JpaRepository<users,Long> {  
    Optional<users> findByUsername(String username);
}
