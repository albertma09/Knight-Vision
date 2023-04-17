/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Player;
import clases.usuario.User;
import com.ourERP.knightvision.service.IplayerService;
import com.ourERP.knightvision.service.IuserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class PlayerController {

    @Autowired
    private IplayerService servicePlayer;

    @Autowired
    private IuserService serviceUser;

    @GetMapping("/players")
    public String irPlayers(Model model) {
        List<User> users = serviceUser.listar();
        model.addAttribute("users", users);
        List<Player> players = servicePlayer.listar();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player()); // Add an empty User object to the model
        return "players";
    }

    @GetMapping("/verPlayers")
    public String irverPlayers(Model model) {
        List<User> users = serviceUser.listar();
        model.addAttribute("users", users);
        List<Player> players = servicePlayer.listar();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player()); // Add an empty User object to the model
        return "players";
    }

    @PostMapping("/registroPlayers")
    public String save(Player p, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nav", "Registro");
            List<Player> players = servicePlayer.listar();
            model.addAttribute("players", players);
            return "verPlayers";
        }
        User user = serviceUser.findByUsername(p.getUsername());
        if (user != null) {
            p.setUser(user);
            p.setIduser(user.getUserid());
            servicePlayer.save(p);
            return "redirect:/verPlayers";
        }
        return "redirect:/verPlayers";
    }
}
