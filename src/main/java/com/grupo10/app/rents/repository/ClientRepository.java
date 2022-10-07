/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IClientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martinduarteflorez
 */
@Repository
public class ClientRepository {

    @Autowired
    IClientRepository Repository;

    public Iterable<Client> findAllCLients() {

        return Repository.findAll();
    }

    public Optional<Client> findClientById(Integer id) {
        Optional<Client> response = Repository.findById(id);
        return response;
    }

    public Client saveClient(Client client) {

        return Repository.save(client);
    }

    public Boolean existClientById(Integer id) {

        return Repository.existsById(id);
    }

    public void deleteClientById(Integer id) {

        Repository.deleteById(id);
    }

}
