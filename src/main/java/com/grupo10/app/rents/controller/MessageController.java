/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;


import com.grupo10.app.rents.model.IMessageRepository;
import com.grupo10.app.rents.model.Message;
import java.util.List;
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
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired
    IMessageRepository repository;
    
    @GetMapping("/all")
    public Iterable<Message> getMessages(){
        Iterable<Message> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    public String createMessage(@RequestBody Message request){
        
        repository.save(request);
        
        return "crated....";
    }


    
    
}