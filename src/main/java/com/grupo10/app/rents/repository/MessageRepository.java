/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martinduarteflorez
 */
@Repository
public class MessageRepository {

    @Autowired
    IMessageRepository Repository;

    public Iterable<Message> getAllMessages() {

        return Repository.findAll();
    }

    public Optional<Message> findMessageById(Integer id) {
        Optional<Message> response = Repository.findById(id);
        return response;
    }

    public Message saveMessage(Message message) {

        return Repository.save(message);
    }



    public Boolean existMessageById(Integer id) {

        return Repository.existsById(id);
    }

}
