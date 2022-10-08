/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface ICategoryRepository extends CrudRepository<Category, Integer> {
    /* ejemplo de reporte
    @Query("SELECT c.year, COUNT(c.year) from tb_category AS c group by c.year order by COUNT(c.year) DESC")
    public List<Category[]> countTotalCategoryByYear();
    */

}
