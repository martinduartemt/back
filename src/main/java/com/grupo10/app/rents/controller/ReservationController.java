/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.dto.ReportClientDto;
import com.grupo10.app.rents.dto.ReportStatusDto;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @GetMapping("/all")
    public Iterable<Reservation> get() {

        return service.getReservation();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> get(@PathVariable("id") Integer id) {

        return service.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Reservation request) {

        service.createReservation(request);
    }

    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation request) {

        return service.updateReservation(request);
    }
    //reports 
    @GetMapping("/report-clients")
    public List<ReportClientDto> getReport() {
        return service.getClientReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return service.getReportDates(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public ReportStatusDto getReservationsStatusReport() {
        return service.getReservationsStatusReport();
    }
  
}



