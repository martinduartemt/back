/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    //reports
    public List<Reservation> findReservationByStatus (String status){
        return Repository.findAllByStatus(status);
    }
    
    public List<Reservation> findInformByDate (Date a, Date b){
        return Repository.findAllByDate(a, b);
    }
    
    public List<CountClient> findTopClient(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = Repository.countTotalReservationByClient();
        for(int i=0;i < report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }



}
