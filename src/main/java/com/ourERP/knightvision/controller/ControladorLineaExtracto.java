/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.contabilidad.LineaExtracto;
import com.ourERP.knightvision.service.LineaExtractoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class ControladorLineaExtracto {

    @Autowired
    private LineaExtractoService lineaExtractoService;

    @GetMapping("/lineasExtracto")
    public String comienzo(Model model) {

        List<LineaExtracto> lineasExtracto = lineaExtractoService.listLineasExtracto();
        model.addAttribute("lineasExtracto", lineasExtracto);

        return "lineasExtracto";
    }
}
