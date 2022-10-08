/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.repository.ClientRepository;
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
    ClientRepository repository;
    
    
    public Iterable<Client> getClient(){
        Iterable<Client> response = repository.findAllCLients();
        
        return response;
    }
    
    public Optional<Client> getClient(Integer id) {

        Optional<Client> response = repository.findClientById(id);
        return response;

    }
    
    
    public Client createClient(@RequestBody Client request){
                
        return repository.saveClient(request);
    }
    
    public Client updateCLient(Client client) {

        Client clientToUpdate = new Client();

        if (repository.existClientById(client.getIdClient())) {
            clientToUpdate = client;
            repository.saveClient(clientToUpdate);
        }

        return clientToUpdate;


    }
    public Boolean deleteClient(Integer id) {

        repository.deleteClientById(id);
        boolean deleted = true;

        return deleted;

    }
    
}
