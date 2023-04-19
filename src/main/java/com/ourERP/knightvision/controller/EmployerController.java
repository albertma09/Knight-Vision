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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @GetMapping("/editaremployer/{Employeid}")
    public String editar(@PathVariable int Employeid, Model model) {
        Optional<Employer> employerOpt = serviceEmployer.listarId(Employeid);
        model.addAttribute("employer", employerOpt.orElse(null));
        return "editaremployer";
    }
    
    @PostMapping("/editaremployer")
    public String editar(Employer employer, RedirectAttributes redirectAttributes) {
        String username = employer.getUsername();
        User user = serviceUser.findByUsername(username);
        if (user != null) {
            employer.setUser(user);
            employer.setIduser(user.getUserid());
            int result = serviceEmployer.save(employer);
            if (result == 0) {
                redirectAttributes.addFlashAttribute("error", "No se pudo actualizar al Empleado");
            } else {
                redirectAttributes.addFlashAttribute("success", "Empleado actualizado exitosamente");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró el usuario correspondiente al empleado");
        }
        return "redirect:/verEmployers";
    }
}