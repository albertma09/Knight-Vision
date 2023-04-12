/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Eventos;
import com.ourERP.knightvision.service.EventosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class HomeController {

    @GetMapping("/registrousers")
    public String irARegistroUsers(Model model) {
        model.addAttribute("nav","Registro");
        return "registrousers"; 
    }
    
    @Autowired
    private EventosService eventoService;
    
    @GetMapping("/eventos")
    public String irAEventos(Model model){
        model.addAttribute("nav","Eventos");
        List<Eventos> eventos = eventoService.listEventos();
        
        model.addAttribute("eventos", eventos);
        return "eventos";
    }



    @GetMapping("/contabilidad")
    public String irAContabilidad() {
        return "contabilidad";
    }
    
    @PostMapping("/guardarEvento") 
    public String guardarEvento(Eventos evento) {

        eventoService.salvar(evento); 

        return "redirect:/eventos"; 
    }
}
