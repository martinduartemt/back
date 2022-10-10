/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package com.grupo10.app.rents.security;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martinduarteflorez
 */
/**
@RestController
public class UserController {
    
        @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
            System.out.println(principal);
        return Collections.singletonMap("username", principal.getAttribute("login"));
    }

    
}
*/