/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.eventos.Eventos;
import clases.suscriptions.PlayersSuscription;
import clases.suscriptions.PlayersSuscription.PlayersSuscriptionId;
import clases.suscriptions.prueba;
import clases.suscriptions.SuscriptionAtribute;
import clases.suscriptions.Suscriptions;
import clases.usuario.Player;
import com.ourERP.knightvision.DTO.PlayersSuscriptionDTO;
import com.ourERP.knightvision.DTO.SuscriptionAtributeDTO;
import com.ourERP.knightvision.service.IplayerService;
import com.ourERP.knightvision.service.SuscriptionsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */

@Controller
public class SuscriptionsController {
    @Autowired
    private SuscriptionsService suscriptionsService;
    @Autowired
    private IplayerService servicePlayer;
    
    @GetMapping("/suscriptions")
    public String irASuscriptions(Model model){
        // suscripciones
        
        List<PlayersSuscription> playersSusc = suscriptionsService.listPlayersSuscription();
        model.addAttribute("playersSusc", playersSusc);
        
        List<SuscriptionAtribute> suscAtr = suscriptionsService.listSuscriptionsAtributes();
        model.addAttribute("suscAtr", suscAtr);
        
        List<Suscriptions> susc = suscriptionsService.listSuscriptions();
        model.addAttribute("susc", susc);
        
        return "suscriptions";
    }
    
    @PostMapping("/crearSuscription") 
    public String guardarSuscription(Suscriptions susc) {
        suscriptionsService.salvarSuscriptions(susc); 

        return "redirect:/suscriptions"; 
    }
    
    @GetMapping("/eliminarSuscription/{id}") 
    public String eliminarSuscription(@PathVariable int id) {
        List<Suscriptions> susc = suscriptionsService.listSuscriptions();
        for (int i = 0; i < susc.size(); i++) {
            if(susc.get(i).getId()==id){
                //eliminar atributos
                List<SuscriptionAtribute> atributes = suscriptionsService.listSuscriptionsAtributes();
                for (int j = 0; j < atributes.size(); j++) {
                    if(atributes.get(i).getSuscription().getId()==id){
                        suscriptionsService.borrar(atributes.get(i));
                    }
                }
                
                //eliminar players
                //TODO
                suscriptionsService.borrarSuscriptions(susc.get(i));
                break;
            }
        }
        return "redirect:/suscriptions"; 
    }
    
    @GetMapping("/eliminarPlayerSuscription/{suscid}/{playerid}") 
    public String eliminarPlayerSuscription(@PathVariable int suscid, @PathVariable int playerid) {
            System.out.println(suscid);
            System.out.println(playerid);
            List<Player> players = servicePlayer.listar();
            List<Suscriptions> suscriptions = suscriptionsService.listSuscriptions();
            Player player = null;
            Suscriptions suscription = null;
            
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getPlayerid()==playerid){
                    player = players.get(i);
                    break;
                }
            }
            
            for (int i = 0; i < suscriptions.size(); i++) {
                if(suscriptions.get(i).getId()==suscid){
                    suscription = suscriptions.get(i);
                    break;
                }
            }
            
            PlayersSuscriptionId psid= new PlayersSuscriptionId(playerid,suscid);
            
            PlayersSuscription playerSusc = new PlayersSuscription(psid,player,suscription);
            
            suscriptionsService.borrarPlayersSuscription(playerSusc);
        return "redirect:/suscriptions"; 
    }
    
        @PostMapping("/crearPlayerSuscription") 
    public String crearPlayerSuscription(PlayersSuscriptionDTO playersSuscriptionDTO) {
            int suscid = playersSuscriptionDTO.getSuscid();
            int playerid = playersSuscriptionDTO.getPlayerid();
            
            List<Player> players = servicePlayer.listar();
            List<Suscriptions> suscriptions = suscriptionsService.listSuscriptions();
            Player player = null;
            Suscriptions suscription = null;
            
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getPlayerid()==playerid){
                    player = players.get(i);
                    break;
                }
            }
            
            for (int i = 0; i < suscriptions.size(); i++) {
                if(suscriptions.get(i).getId()==suscid){
                    suscription = suscriptions.get(i);
                    break;
                }
            }
            
            PlayersSuscriptionId psid= new PlayersSuscriptionId(playerid, suscid);
            
            PlayersSuscription playerSusc = new PlayersSuscription(psid,player,suscription);
            suscriptionsService.salvarPlayersSuscription(playerSusc);
        return "redirect:/suscriptions"; 
    }
    
    @PostMapping("/addAtribute") 
    public String addAtribute(SuscriptionAtributeDTO suscAtrDto) {
        //suscriptionsService.salvar(suscAtr); 

        List<Suscriptions> suscsArr = suscriptionsService.listSuscriptions();
        
        
        Suscriptions susc = new Suscriptions();
        for (int i = 0; i < suscsArr.size(); i++) {
            if(suscsArr.get(i).getId()==suscAtrDto.getSuscriptionid()){
                SuscriptionAtribute suscAtr = new SuscriptionAtribute(suscsArr.get(i), suscAtrDto.getAtribute());
                suscriptionsService.salvar(suscAtr);
            }
        }
        return "redirect:/suscriptions"; 
    }
    @GetMapping("/deleteAtribute/{suscId}/{atribute}") 
    public String deleteAtribute(@PathVariable int suscId, @PathVariable String atribute) {
        List<SuscriptionAtribute> arr = suscriptionsService.listSuscriptionsAtributes();
        
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getSuscription().getId() == suscId && arr.get(i).getAtribute().equals(atribute)){
                suscriptionsService.borrar(arr.get(i));
                break;
            }
        }

        return "redirect:/suscriptions"; 
    }
}

