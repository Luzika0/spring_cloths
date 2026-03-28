package com.example.Spring_Cloths.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Cloths.models.productModels;

public interface serviceRepository extends JpaRepository<productModels,Long> {
}
