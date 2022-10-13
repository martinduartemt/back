/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.dto.ReportClientDto;
import com.grupo10.app.rents.dto.ReportStatusDto;
import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.repository.ClientRepository;
import com.grupo10.app.rents.repository.QuadbikeRepository;
import com.grupo10.app.rents.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    //resports

   public List<ReportClientDto> getClientReport() {

        List<ReportClientDto> report = new ArrayList<ReportClientDto>();
        List<Object[]> reportData = repository.getReport();

        for (int i = 0; i < reportData.size(); i++) {
            ReportClientDto reportClientDto = new ReportClientDto();
            reportClientDto.client = (Client) reportData.get(i)[0];
            reportClientDto.total = (Long) reportData.get(i)[1];
            report.add(reportClientDto);
        }
        return report;

    }

    public List<Reservation> getReportDates(String dateOne, String dateTwo) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateOne);
            b = parser.parse(dateTwo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return repository.getReservationsPeriod(a, b);
        } else {
            return new ArrayList<>();
        }

    }

    public ReportStatusDto getReservationsStatusReport() {
        ReportStatusDto reportStatusDto = new ReportStatusDto();
        reportStatusDto.completed=repository.getReservationsByStatus("completed").size();
        reportStatusDto.cancelled=repository.getReservationsByStatus("cancelled").size();        
        return reportStatusDto;

    }
}
