/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class HomeController {

    @GetMapping("/registrousers")
    public String irAOtraPagina() {
        return "registrousers";
    }

    @GetMapping("/contabilidad")
    public String irAContabilidad() {
        return "contabilidad";
    }
}
