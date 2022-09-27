/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.grupo10.app.rents.model.IQuadbikeRepository;
import com.grupo10.app.rents.model.Quadbike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martinduarteflorez
 */
@RestController
@RequestMapping("/api/quadbike")
public class QuadbikeController {
    
    @Autowired
    IQuadbikeRepository repository;
    
    @GetMapping("/all")
    public Iterable<Quadbike> getQuadbike() {
        Iterable<Quadbike> response = repository.findAll();
        return response;
    }
    
    @PostMapping("/save")
    public String createQuadbike() {
        return "created...";
    }
    
    @PutMapping("/update")
    public String updateQuadbike(){
        return "update";
    }
}