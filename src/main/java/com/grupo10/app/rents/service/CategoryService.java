/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.repository.CategoryRepository;
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
    CategoryRepository repository;

    public Iterable<Category> getCategory() {
        Iterable<Category> response = repository.getCategoryAll();

        return response;
    }

    public Optional<Category> getCategory(Integer id) {

        Optional<Category> response = repository.findCategoryById(id);
        return response;

    }
    /*
    ejemplo de reporte
    public List<Category[]> getReportCategory() {
        
        

        return repository.CategoryReport();

    }*/
    
    public Category createCategory(@RequestBody Category request) {

        return repository.saveCategory(request);
    }

    public Category updateCategory(Category category) {

        Category categoryToUpdate = new Category();

        if (repository.existCategoryById(category.getId())) {
            categoryToUpdate = category;
            repository.saveCategory(categoryToUpdate);
        }

        return categoryToUpdate;

    }

    public Boolean deleteCategory(Integer id) {

        repository.deleteCategoryById(id);
        boolean deleted = true;

        return deleted;

    }

}
