/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.grupo10.app.rents.model.Category;
import com.grupo10.app.rents.model.ICategoryRepository;
import com.grupo10.app.rents.model.IQuadbikeRepository;
import com.grupo10.app.rents.model.Quadbike;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author martinduarteflorez
 */
@Service
public class quadbikeService {
    
    @Autowired
    IQuadbikeRepository reposytory;
    
    @Autowired
    ICategoryRepository categoryRepository;
    
    public Iterable<Quadbike> get() {
        
        Iterable<Quadbike> response = reposytory.findAll();
        return response;
        
    }
    
    public String create(Quadbike request){
        
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        
        if(!cat.isEmpty()) {
            request.setCategory(cat.get());
        }
        if (request.getName() != null)  {
            reposytory.save(request);
            return  "created...";
        } else {
            return "falta el nombre";
        }
    }
    
    
}