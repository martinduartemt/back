/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.repository.QuadbikeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class QuadbikeService {

    @Autowired
    QuadbikeRepository repository;

    @Autowired
    ICategoryRepository categoryRepository;

    public Iterable<Quadbike> getQuadbike() {

        Iterable<Quadbike> response = repository.findAllQuadbikes();
        return response;

    }

    public Optional<Quadbike> getQuadbike(Integer id) {

        Optional<Quadbike> response = repository.findQuadbikeById(id);
        return response;

    }

    public List<Object[]> getReportQuadbike() {

        List<Quadbike> response = new ArrayList<>();
        List<Object[]> result = repository.quadbikeReport();

        return result;
    }

    public Quadbike createQuadbike(Quadbike request) {

        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());

        if (!cat.isEmpty()) {
            request.setCategory(cat.get());
        }
        return repository.saveQuadbike(request);

    }

    public Quadbike updateQuadbike(Quadbike quadbike) {

        Quadbike quadbikeToUpdate=new Quadbike();
        
        if(repository.existQuadbikeById(quadbike.getId())){
            
            Optional<Quadbike> currentQuadbike = repository.findQuadbikeById(quadbike.getId());
            quadbikeToUpdate = quadbike;
            quadbikeToUpdate.setCategory(currentQuadbike.get().getCategory());
            quadbikeToUpdate.setMessages(currentQuadbike.get().getMessages());
            quadbikeToUpdate.setReservations(currentQuadbike.get().getReservations());
            repository.saveQuadbike(quadbikeToUpdate);
        }        
        return quadbikeToUpdate;
    

    }

    public Boolean deleteQuadbike(Integer id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
    

}
