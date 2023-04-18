/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Employer;
import clases.usuario.Player;
import clases.usuario.User;
import com.ourERP.knightvision.service.IemployerService;
import com.ourERP.knightvision.service.IplayerService;
import com.ourERP.knightvision.service.IuserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class UsersController {

    @Autowired
    private IuserService serviceUser;

    @Autowired
    private IemployerService serviceEmploye;

    @Autowired
    private IplayerService servicePlayer;

    @GetMapping("/registrousers")
    public String irARegistroUsers(Model model) {
        model.addAttribute("nav", "Registro");
        List<User> users = serviceUser.listar();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // Add an empty User object to the model
        return "registrousers";
    }

    @PostMapping("/registroUsers") // Update the URL to match the form action
    public String save(User u, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nav", "Registro");
            List<User> users = serviceUser.listar();
            model.addAttribute("users", users);
            return "registrousers";
        }
        serviceUser.save(u);
        return "redirect:/registrousers";
    }

    @GetMapping("/eliminarusuario/{userid}")
    public String delete(Model model, @PathVariable int userid) {
        serviceUser.delete(userid);
        return "redirect:/registrousers";
    }

    @GetMapping("/editarusuario/{userid}")
    public String editar(@PathVariable int userid, Model model) {
        Optional<User> userOptional = serviceUser.listarId(userid);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            model.addAttribute("rolInicial", user.getRol());
            return "editarusuario";
        } else {
            return "redirect:/registrousers";
        }
    }

    @PostMapping("/editarusuario")
    public String actualizarUsuario(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editarusuario";
        }
        serviceUser.update(user);
        return "redirect:/registrousers";
    }
}
