/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.Player;
import com.ourERP.knightvision.service.PlayerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alber
 */
@Controller
public class InformationController {

    @Autowired
    private PlayerService eventoService;

    @GetMapping("/informacion")
    public String informacion(Model model) {
        List<Player> players = eventoService.listar();
        model.addAttribute("nav","Informacion");
        List<Integer> eloCatalan = new ArrayList<>();
        List<Integer> eloInternacional = new ArrayList<>();
        for (Player player:players) {
            eloCatalan.add(player.getEloCatalan());
            System.out.println(player.getEloFide());
            eloInternacional.add(player.getEloFide());
        }
        model.addAttribute("eloCatalan", eloCatalan);
        model.addAttribute("eloInternacional", eloInternacional);
        return "informacion";
    }
}
