package com.example.webframeworkproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webframeworkproject.model.ProductDescription;
import com.example.webframeworkproject.repositary.ProductDespRepo;

@Service
public class ProductDespService {
    @Autowired
    private ProductDespRepo pRepo;

    public ProductDescription postmethod(ProductDescription productDescription)
    {
        return pRepo.save(productDescription);
    }
}
