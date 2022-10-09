/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.repository.ClientRepository;
import com.grupo10.app.rents.repository.QuadbikeRepository;
import com.grupo10.app.rents.repository.ReservationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class ReservationService {

    @Autowired
    ReservationRepository repository;
    @Autowired
    QuadbikeRepository quadbikeRepository;
    @Autowired
    ClientRepository clientRepository;

    public Iterable<Reservation> getReservation() {

        Iterable<Reservation> response = repository.findAllReservation();

        return response;
    }
    
    public Optional<Reservation> getReservation(Integer id) {

        Optional<Reservation> response = repository.findReservationById(id);
        return response;

    }

    public Reservation createReservation(@RequestBody Reservation request) {

        Optional<Quadbike> quad = quadbikeRepository.findQuadbikeById(request.getQuadbike().getId());
        if (!quad.isEmpty()) {
            request.setQuadbike(quad.get());
        }

        Optional<Client> cli;
        cli = clientRepository.findClientById(request.getClient().getIdClient());
        if (!cli.isEmpty()) {
            request.setClient(cli.get());

        }

        return repository.saveReservation(request);

    }
    
    public Reservation updateReservation(Reservation reservation) {

        Reservation reservationToUpdate = new Reservation();

        if (repository.existReservationById(reservation.getIdReservation())) {
            reservationToUpdate = reservation;
            repository.saveReservation(reservationToUpdate);
        }

        return reservationToUpdate;

    }

    
}
