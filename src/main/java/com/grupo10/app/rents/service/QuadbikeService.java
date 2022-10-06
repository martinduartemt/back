/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Quadbike;
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
    IQuadbikeRepository repository;

    @Autowired
    ICategoryRepository categoryRepository;

    public Iterable<Quadbike> getQuadbike() {

        Iterable<Quadbike> response = repository.findAll();
        return response;

    }

    public Optional<Quadbike> getQuadbike(Integer id) {

        Optional<Quadbike> response = repository.findById(id);
        return response;

    }

    public Quadbike createQuadbike(Quadbike request) {

        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());

        if (!cat.isEmpty()) {
            request.setCategory(cat.get());
        }
        return repository.save(request);

    }

    public Quadbike updateQuadbike(Quadbike quadbike) {

        Quadbike quadbikeToUpdate = new Quadbike();

        if (repository.existsById(quadbike.getId())) {
            quadbikeToUpdate = quadbike;
            repository.save(quadbikeToUpdate);
        }

        return quadbikeToUpdate;

    }
    
    public Boolean deleteQuadbike(Integer id) {

        repository.deleteById(id);
        boolean deleted = true;

        return deleted;

    }

}
