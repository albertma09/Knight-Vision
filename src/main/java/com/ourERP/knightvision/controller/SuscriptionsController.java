/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.suscriptions.PlayersSuscription;
import clases.suscriptions.prueba;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Alfred
 */

@Controller
public class SuscriptionsController {
    
    @GetMapping("/suscriptions")
    public String irASuscriptions(Model model){
        // suscripciones
        prueba test = new prueba(1,"gerardo");
        prueba test3 = new prueba(1,"albert");
        prueba test4 = new prueba(1,"george");
        prueba test2 = new prueba(2,"alfredico");
        prueba test5 = new prueba(2,"lindsay");
        prueba test6 = new prueba(2,"ivan");
        ArrayList<prueba> suscAtr = new ArrayList<>();
        suscAtr.add(test);
        suscAtr.add(test2);
        suscAtr.add(test3);
        suscAtr.add(test4);
        suscAtr.add(test5);
        suscAtr.add(test6);
        model.addAttribute("suscAtr", suscAtr);
        
        //suscripciones-players
        PlayersSuscription p1 = new PlayersSuscription(61,2);
        PlayersSuscription p2 = new PlayersSuscription(27,1);
        ArrayList<PlayersSuscription> playersSusc = new ArrayList<>();
        playersSusc.add(p1);
        playersSusc.add(p2);
        model.addAttribute("playersSusc", playersSusc);
        
        return "suscriptions";
    }
}

