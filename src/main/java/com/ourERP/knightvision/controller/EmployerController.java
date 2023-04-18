/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Employer;
import clases.usuario.User;
import com.ourERP.knightvision.service.IemployerService;
import com.ourERP.knightvision.service.IuserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alfred
 */
@Controller
public class EmployerController {
    
   @Autowired
    private IemployerService serviceEmployer;

    @Autowired
    private IuserService serviceUser;

    @RequestMapping(value = "/verEmployers", method = RequestMethod.GET)
    public String irverEmployers(Model model) {
        List<User> users = serviceUser.listar();
        model.addAttribute("users", users);
        List<Employer> employers = serviceEmployer.listar();
        model.addAttribute("employers", employers);
        model.addAttribute("employer", new Employer()); // Add an empty User object to the model
        return "employers";
    }

    @PostMapping("/registroEmployers")
    public String save(Employer e, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nav", "Registro");
            List<Employer> employers = serviceEmployer.listar();
            model.addAttribute("employers", employers);
            return "verEmployers";
        }
        User user = serviceUser.findByUsername(e.getUsername());
        if (user != null) {
            e.setUser(user);
            e.setIduser(user.getUserid());
            serviceEmployer.save(e);
            return "redirect:/verEmployers";
        }
        return "redirect:/verEmployers";
    }
}