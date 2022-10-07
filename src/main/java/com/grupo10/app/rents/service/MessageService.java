/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.repository.ClientRepository;
import com.grupo10.app.rents.repository.MessageRepository;
import com.grupo10.app.rents.repository.QuadbikeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class MessageService {

    @Autowired
    MessageRepository repository;
    @Autowired
    QuadbikeRepository quadbikeRepository;
    @Autowired
    ClientRepository clientRepository;

    public Iterable<Message> getMessage() {
        Iterable<Message> response = repository.getAllMessages();

        return response;
    }
    
    public Optional<Message> getMessage(Integer id) {

        Optional<Message> response = repository.findMessageById(id);
        return response;

    }

    public Message createMessage(@RequestBody Message request) {

        Optional<Quadbike> quad = quadbikeRepository.findQuadbikeById(request.getQuadbike().getId());
        if (!quad.isEmpty()) {
            request.setQuadbike(quad.get());
        }

        Optional<Client> cli;
        cli = clientRepository.findClientById(request.getClient().getIdClient());
        if (!cli.isEmpty()) {
            request.setClient(cli.get());

        }

        return repository.saveMessage(request);
        }
        public Message updateMessage(Message message) {

        Message messageToUpdate = new Message();

        if (repository.existMessageById(message.getIdMessage())) {
            messageToUpdate = message;
            repository.saveMessage(messageToUpdate);
        }

        return messageToUpdate;

    }
     

}

