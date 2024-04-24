package com.example.webframeworkproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.webframeworkproject.model.Product;
import com.example.webframeworkproject.model.ProductDescription;
import com.example.webframeworkproject.repositary.ProductDespRepo;
import com.example.webframeworkproject.service.ProductDespService;
import com.example.webframeworkproject.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/com")
public class ProductController {
    @Autowired
    private ProductService pService;
    @Autowired
    private ProductDespService pdesp;
    @Autowired
    private ProductDespRepo repo;
    public ProductController(ProductService pService)
    {
        this.pService=pService;
    }

    @PostMapping("/post")
    public Product postMethodName(@RequestBody Product product ) {
        
       return pService.saveProduct(product);
        
    }
    @GetMapping("/path")
    public List<Product> getMethodName() {
        return pService.getProduct() ;
    }
    
   @PutMapping("/product/{id}")
   public ResponseEntity<String> putMethodName( @RequestBody Product uProduct,@PathVariable int id) {
    pService.putmethodName(uProduct,id);
    return new ResponseEntity<>("updated",HttpStatus.NOT_ACCEPTABLE);

   }

@DeleteMapping("/product/{id}")
public String deleteString(@PathVariable Integer id)
{
     return pService.deleteString(id);
}

@GetMapping("/author/{value}")
    public List<Product> getByCategory(@PathVariable("value") String categoryName) {
        return pService.getByCategory(categoryName);
    }

//  @GetMapping("page/{pg}/{si}")
      
//          public Page<Product> getMethodName(@PathVariable("pg")int pg,@PathVariable("si")int si)
// {
//     return pService.pagenation(pg, si);
//       }

@PostMapping("/pos")
public ProductDescription postdesmethod(@RequestBody ProductDescription productDescription ) {
    
   return pdesp.postmethod(productDescription);
    
}
@PostMapping("/pathdesp")
public String posMethodName(@RequestBody Product product) {
    ProductDescription pDescription=product.getProductDescription();
    ProductDescription obj=repo.findByDescriptionEndsWith(pDescription.getDescription());
    product.getProductDescription().setId(obj.getId());
    pService.saveProduct(product);
    
    return "product";
}


}
