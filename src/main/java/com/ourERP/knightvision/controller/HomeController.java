/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.eventos.Eventos;
import clases.usuario.User;
import com.ourERP.knightvision.service.EventosService;
import com.ourERP.knightvision.service.IuserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class HomeController {

    @Autowired
    private IuserService service;

    @GetMapping("/registrousers")
    public String irARegistroUsers(Model model) {
        model.addAttribute("nav", "Registro");
        List<User> users = service.listar();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // Add an empty User object to the model
        return "registrousers";
    }

    @PostMapping("/registroUsers") // Update the URL to match the form action
    public String save(@Valid User u, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nav", "Registro");
            List<User> users = service.listar();
            model.addAttribute("users", users);
            return "registrousers";
        }
        service.save(u);
        return "redirect:/registrousers";
    }
    
    
    
    



    
}
