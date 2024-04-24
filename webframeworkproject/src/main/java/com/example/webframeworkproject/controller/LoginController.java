package com.example.webframeworkproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.webframeworkproject.model.LoginModel;
import com.example.webframeworkproject.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {
    private LoginService LoginService;
    public LoginController( LoginService LoginService)
    {
        this.LoginService=LoginService;
    }
    
    @GetExchange("/customer")
    public List <LoginModel> display(){
        return LoginService.gModels();
    }

    @GetMapping("/customer/{id}")
    public LoginModel display(@PathVariable Integer id){
        return LoginService.get(id);
    }

    @PostMapping("/customer")
    public LoginModel create(@RequestBody LoginModel m)
    {
        return LoginService.create(m);

    }
    @PutMapping("/customer/{id}")
    public String update(@RequestBody LoginModel m,@PathVariable Integer id){
        return LoginService.update(m, id);
    }
    @DeleteMapping("/customer/{id}")
    public String delete(@PathVariable Integer id)
    {
        return LoginService.delete(id);
    }

}
