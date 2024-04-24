package com.example.webframeworkproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webframeworkproject.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,Integer> {

    
} 