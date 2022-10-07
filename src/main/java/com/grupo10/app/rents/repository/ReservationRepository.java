/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martinduarteflorez
 */
@Repository
public class ReservationRepository {

    @Autowired
    IReservationRepository Repository;

    public Iterable<Reservation> findAllReservation() {

        return Repository.findAll();
    }

    public Optional<Reservation> findReservationById(Integer id) {
        Optional<Reservation> response = Repository.findById(id);
        return response;
    }

    public Reservation saveReservation(Reservation reservation) {

        return Repository.save(reservation);
    }

    public Boolean existReservationById(Integer id) {

        return Repository.existsById(id);
    }



}
