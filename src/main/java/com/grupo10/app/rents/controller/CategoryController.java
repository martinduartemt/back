/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.service.CategoryService;
import com.grupo10.app.rents.service.QuadbikeService;
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
@RequestMapping("/apiCategory/")
public class CategoryController {
    
    
    @Autowired
    CategoryService service;
    
    @GetMapping("/all")
    public Iterable<Category> get(){
        
       
        
        return service.get();
    }
    
    @PostMapping("/save")
    public String createCategory(@RequestBody Category request){
        
        
        return service.create(request);
    }


    
    
}