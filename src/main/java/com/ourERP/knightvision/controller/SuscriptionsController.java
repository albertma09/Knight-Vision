/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.suscriptions.PlayersSuscription;
import clases.suscriptions.prueba;
import clases.suscriptions.SuscriptionAtribute;
import com.ourERP.knightvision.service.SuscriptionsService;
import java.util.ArrayList;
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
public class SuscriptionsController {
    @Autowired
    private SuscriptionsService suscriptionsService;
    
    @GetMapping("/suscriptions")
    public String irASuscriptions(Model model){
        // suscripciones
        
        List<PlayersSuscription> playersSusc = suscriptionsService.listPlayersSuscription();
        model.addAttribute("playersSusc", playersSusc);
        
        List<SuscriptionAtribute> suscAtr = suscriptionsService.listSuscriptionsAtributes();
        model.addAttribute("suscAtr", suscAtr);
        
        return "suscriptions";
    }
}

