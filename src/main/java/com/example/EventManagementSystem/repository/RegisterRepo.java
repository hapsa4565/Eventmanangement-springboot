package com.example.EventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventManagementSystem.Model.Register;

public interface RegisterRepo extends JpaRepository<Register,Long> {
    
}
