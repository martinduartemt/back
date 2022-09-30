/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;



import com.grupo10.app.rents.model.IReservationRepository;
import com.grupo10.app.rents.model.Reservation;
import java.util.List;
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
@RequestMapping("/api/Mesagge")
public class ReservationController {
    
    @Autowired
    IReservationRepository repository;
    
    @GetMapping("/all")
    public Iterable<Reservation> getReservation(){
        Iterable<Reservation> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    public String createReservation(@RequestBody Reservation request){
        
        repository.save(request);
        
        return "crated....";
    }


    
    
}