/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;


import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import java.util.Optional;
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
public class ReservationService {

    @Autowired
    IReservationRepository repository;
    @Autowired
    IQuadbikeRepository quadbikeRepository;
    @Autowired
    IClientRepository clientRepository;

    @GetMapping("/all")
    public Iterable<Reservation> get() {

        Iterable<Reservation> response = repository.findAll();

        return response;
    }

    @PostMapping("/save")
    public String create(@RequestBody Reservation request) {

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
