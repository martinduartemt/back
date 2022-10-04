/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class CategoryService {

    @Autowired
    ICategoryRepository repository;
    

    public Iterable<Category> get(){
        Iterable<Category> response = repository.findAll();
        
        return response;
    }
    

    public String create(@RequestBody Category request){
        
        repository.save(request);
        
        return "crated....";
    }


    
    
}
