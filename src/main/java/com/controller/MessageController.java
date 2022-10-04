/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.model.Client;
import com.model.IClientRepository;
import com.model.IMessageRepository;
import com.model.IQuadbikeRepository;
import com.model.Message;
import com.model.Quadbike;
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
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    IMessageRepository repository;
    @Autowired
    IQuadbikeRepository quadbikeRepository;
    @Autowired
    IClientRepository clientRepository;

    @GetMapping("/all")
    public Iterable<Message> getMessages() {
        Iterable<Message> response = repository.findAll();

        return response;
    }

    @PostMapping("/save")
    public String createMessage(@RequestBody Message request) {

        Optional<Quadbike> quad = quadbikeRepository.findById(request.getQuadbike().getId());
        if (!quad.isEmpty()) {
            request.setQuadbike(quad.get());
        }

        Optional<Client> cli;
        cli = clientRepository.findById(request.getClient().getIdClient());
        if (!cli.isEmpty()) {
            request.setClient(cli.get());

        }
        repository.save(request);
         
        return "crated....";

    }

}
