/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IClientRepository;
import java.util.Optional;
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
    
    
    public Iterable<Client> getClient(){
        Iterable<Client> response = repository.findAll();
        
        return response;
    }
    
    public Optional<Client> getClient(Integer id) {

        Optional<Client> response = repository.findById(id);
        return response;

    }
    
    
    public Client createClient(@RequestBody Client request){
                
        return repository.save(request);
    }
    
    public Client updateCLient(Client client) {

        Client clientToUpdate = new Client();

        if (repository.existsById(client.getIdClient())) {
            clientToUpdate = client;
            repository.save(clientToUpdate);
        }

        return clientToUpdate;


    }
    public Boolean deleteClient(Integer id) {

        repository.deleteById(id);
        boolean deleted = true;

        return deleted;

    }
    
}
