/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Costume")
public class CostumeController {
    
    @GetMapping("/save")
    public String getCostumes(){
        return "costume 1, costume 2....";
    }
    
    @PostMapping("/all")
    public String createCostume(){
        return "crated....";
    }
}
