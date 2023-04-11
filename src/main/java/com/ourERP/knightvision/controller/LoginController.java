/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import com.ourERP.knightvision.service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @GetMapping("/login")
    public String login(Model model) {
        // Agregar una variable de modelo para mostrar un mensaje de error
        model.addAttribute("error", false);
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession session, Model model) {
        User oauthUser = (User) userService.loadUserByUsername(user.getUsername());
        if (Objects.nonNull(oauthUser)) {
            session.setAttribute("user", oauthUser);
            return "redirect:/cuentas";
        } else {
            model.addAttribute("error", true); // Agrega el atributo de error con valor true
            return "login";
        }
    }
}
