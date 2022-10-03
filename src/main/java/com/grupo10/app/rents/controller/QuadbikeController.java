/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.model.Category;
import com.grupo10.app.rents.model.ICategoryRepository;
import com.grupo10.app.rents.model.IQuadbikeRepository;
import com.grupo10.app.rents.model.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {
    
    @Autowired
    IQuadbikeRepository repository;
    @Autowired
    ICategoryRepository categoryRepository;
    
    @GetMapping("/save")
    public Iterable<Quadbike> getQuadbikes(){
        
        Iterable<Quadbike> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/all")
    public String createQuadbike(@RequestBody Quadbike request){
        
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        repository.save(request);
        
        return "crated....";
    }


    
    
}