/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martinduarteflorez
 */
@Repository
public class QuadbikeRepository {

    @Autowired
    IQuadbikeRepository Repository;

    public Iterable<Quadbike> findAllQuadbikes() {

        return Repository.findAll();
    }

    public Optional<Quadbike> findQuadbikeById(Integer id) {
        Optional<Quadbike> response = Repository.findById(id);
        return response;
    }
    
    public List<Object[]> quadbikeReport(){
        return Repository.countTotalQuadbikeByYear();
    }

    public Quadbike saveQuadbike(Quadbike quadbike) {

        return Repository.save(quadbike);
    }

    public Boolean existQuadbikeById(Integer id) {

        return Repository.existsById(id);
    }

    public void deleteQuadbikeById(Integer id) {

        Repository.deleteById(id);
    }

}
