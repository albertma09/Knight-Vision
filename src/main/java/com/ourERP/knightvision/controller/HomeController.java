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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/editar/{userid}")
    public String mostrarFormularioEditar(@PathVariable("userid") int userid, Model model) {
        // buscar el usuario por id y agregarlo al modelo
        Optional<User> user = service.listarId(userid);
        model.addAttribute("user", user);

        // redirigir a la misma página
        return "formeditaruser";
    }

    @GetMapping("/eliminar/{userid}")
    public String delete(User user) {
        service.delete(user);
        return "redirect:/registrosers";
    }

    @Autowired
    private EventosService eventoService;

    @GetMapping("/eventos")
    public String irAEventos(Model model) {
        model.addAttribute("nav", "Eventos");
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
