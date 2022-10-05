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
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class ClientService {

    @Autowired
    IClientRepository repository;
    
    
    public Iterable<Client> get(){
        Iterable<Client> response = repository.findAll();
        
        return response;
    }
    
    
    public Client create(@RequestBody Client request){
                
        return repository.save(request);
    }


    
    
}
