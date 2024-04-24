package com.example.webframeworkproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.webframeworkproject.model.Product;
//import com.example.webframeworkproject.model.ProductDescription;
import com.example.webframeworkproject.repositary.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pRepository;
    public Product saveProduct(Product product)
    {
        return pRepository.save(product);
    }

    public List<Product> getProduct()
    
    {
        return pRepository.findAll();
    }

    

    public String deleteString(Integer id) {
        pRepository.deleteById(id);
        return "deleted successfully";
    }

    public String putmethodName(Product product ,int id)
    {
        product.setId(id);
        pRepository.save(product);
        return "update";
    }
    public List<Product> getByCategory(String categoryName){
        return pRepository.findByCategory(categoryName);
    }
public Page<Product> pagenation(int pagno,int size)
{
    return pRepository.findAll(PageRequest.of(pagno, size));
}



}
