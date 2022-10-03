/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.model.Client;
import com.grupo10.app.rents.model.IClientRepository;
import com.grupo10.app.rents.model.IQuadbikeRepository;
import com.grupo10.app.rents.model.IReservationRepository;
import com.grupo10.app.rents.model.Quadbike;
import com.grupo10.app.rents.model.Reservation;
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
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    IReservationRepository repository;
    @Autowired
    IQuadbikeRepository quadbikeRepository;
    @Autowired
    IClientRepository clientRepository;

    @GetMapping("/save")
    public Iterable<Reservation> getReservation() {

        Iterable<Reservation> response = repository.findAll();

        return response;
    }

    @PostMapping("/all")
    public String createReservation(@RequestBody Reservation request) {

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