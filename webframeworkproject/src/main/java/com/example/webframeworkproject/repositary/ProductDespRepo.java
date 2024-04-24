package com.example.webframeworkproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webframeworkproject.model.ProductDescription;



@Repository
public interface ProductDespRepo extends JpaRepository<ProductDescription, Integer> {

    ProductDescription findByDescriptionEndsWith(String description);
} 