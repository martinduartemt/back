/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class CategoryService {

    @Autowired
    ICategoryRepository repository;

    public Iterable<Category> get() {
        Iterable<Category> response = repository.findAll();

        return response;
    }

    public Optional<Category> get(Integer id) {

        Optional<Category> response = repository.findById(id);
        return response;

    }

    public Category create(@RequestBody Category request) {

        return repository.save(request);
    }

    public Category update(Category category) {

        Category categoryToUpdate = new Category();

        if (repository.existsById(category.getId())) {
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }

        return categoryToUpdate;

    }

    public Boolean delete(Integer id) {

        repository.deleteById(id);
        boolean deleted = true;

        return deleted;

    }

}
