/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author martinduarteflorez
 */
@Repository
public class CategoryRepository {

    @Autowired
    ICategoryRepository Repository;

    public Iterable<Category> getCategoryAll() {

        return Repository.findAll();
    }

    public Optional<Category> findCategoryById(Integer id) {
        Optional<Category> response = Repository.findById(id);
        return response;
    }

    public Category saveCategory(Category category) {

        return Repository.save(category);
    }

    public Boolean existCategoryById(Integer id) {

        return Repository.existsById(id);
    }

    public void deleteCategoryById(Integer id) {

        Repository.deleteById(id);
    }
    /* ejemplode reporte
    public List<Category[]> CategoryReport(){
        return Repository.countTotalCategoryByYear();
    }
    */
}
