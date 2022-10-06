/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.service.QuadbikeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {

    @Autowired
    QuadbikeService service;

    @GetMapping("/all")
    public Iterable<Quadbike> get() {

        return service.getQuadbike();
    }

    @GetMapping("/{id}")
    public Optional<Quadbike> get(@PathVariable("id") Integer id) {

        return service.getQuadbike(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Quadbike request) {

        service.createQuadbike(request);
    }

    @PutMapping("/update")
    public Quadbike update(@RequestBody Quadbike request) {

        return service.updateQuadbike(request);
    }
    
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {

        return service.deleteQuadbike(id);
    }

}
