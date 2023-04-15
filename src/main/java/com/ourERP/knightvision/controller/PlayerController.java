/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Player;
import com.ourERP.knightvision.service.IplayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class PlayerController {

    @Autowired
    private IplayerService servicePlayer;

    @GetMapping("/verPlayers")
    public String irverPlayers(Model model) {
        List<Player> players = servicePlayer.listar();
        model.addAttribute("players", players);
        model.addAttribute("player", new Player()); // Add an empty User object to the model
        return "players";
    }

}
