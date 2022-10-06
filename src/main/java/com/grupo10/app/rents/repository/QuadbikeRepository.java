/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author martinduarteflorez
 */
public class QuadbikeRepository {
    
    @Autowired
    IQuadbikeRepository Repository;
    
    public Iterable<Quadbike> getAll(){
        
        return Repository.findAll();
    }
    
    
    
    
     
}
