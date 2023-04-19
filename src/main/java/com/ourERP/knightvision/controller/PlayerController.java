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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/editarplayer/{playerid}")
    public String editar(@PathVariable int playerid, Model model) {
        Optional<Player> playerOpt = servicePlayer.listarId(playerid);
        model.addAttribute("player", playerOpt.orElse(null));
        return "editarplayer";
    }

    @PostMapping("/editarplayer")
    public String editar(Player player, RedirectAttributes redirectAttributes) {
        String username = player.getUsername();
        User user = serviceUser.findByUsername(username);
        if (user != null) {
            player.setUser(user);
            player.setIduser(user.getUserid());
            int result = servicePlayer.save(player);
            if (result == 0) {
                redirectAttributes.addFlashAttribute("error", "No se pudo actualizar el jugador");
            } else {
                redirectAttributes.addFlashAttribute("success", "Jugador actualizado exitosamente");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró el usuario correspondiente al jugador");
        }
        return "redirect:/players";
    }
}
