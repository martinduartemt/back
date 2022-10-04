/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class ClientService {

    @Autowired
    IClientRepository repository;
    
    @GetMapping("/all")
    public Iterable<Client> get(){
        Iterable<Client> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    public String create(@RequestBody Client request){
        
        repository.save(request);
        
        return "crated....";
    }


    
    
}
