/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/costume")
public class CostumeController {

    @GetMapping("/all")
    public String getCostumes() {
        return "costume 1, cestume 2...";
    }
    
    @PostMapping("/save")
    public String createCostumes() {
        return "created...";
    }
    
    @PutMapping("/update")
    public String updateCostumes(){
        return "update";
    }
}
