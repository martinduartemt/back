/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.service.CategoryService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Category/")
public class CategoryController {

    @Autowired
    CategoryService service;
    
    @GetMapping("/all")
    public Iterable<Category> get(){
       
        return service.get();
    }
    
    @GetMapping("/{id}") 
    public Optional<Category> get(@PathVariable("id") Integer id){
       
        return service.get(id);
    }
    
    @PostMapping("/save")
    public String create(@RequestBody Category request){
        
        return service.create(request);
    }
    
    @PutMapping("/update")
    public String update(@RequestBody Category request){
        
        return service.create(request);
    }
    
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id ){
        
                return service.delete(id);
    }
   
}