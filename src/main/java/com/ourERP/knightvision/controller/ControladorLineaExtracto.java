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
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("nav", "Líneas de Extracto");

        List<LineaExtracto> lineasExtracto = lineaExtractoService.listLineasExtracto();
        model.addAttribute("lineasExtracto", lineasExtracto);

        return "lineasExtracto";
    }

    @GetMapping("/anexarLineaExtracto")
    public String agnadir(LineaExtracto lineaExtracto) {

        return "cambiarLineaExtracto";
    }

    @PostMapping("/salvarLineaExtracto")
    public String salvar(LineaExtracto lineaExtracto) {
        lineaExtractoService.salvar(lineaExtracto);
        return "redirect:/lineasExtracto";

    }

    @GetMapping("/cambiarLineaExtracto/{bankstatementdetailid}")
    public String cambiar(LineaExtracto lineaExtracto, Model model) {
        lineaExtracto = lineaExtractoService.localizarLineaExtracto(lineaExtracto);
        model.addAttribute("lineaExtracto", lineaExtracto);
        return "cambiarLineaExtracto";
    }

    @GetMapping("/borrarLineaExtracto/{bankstatementdetailid}")
    public String borrar(LineaExtracto lineaExtracto) {
        lineaExtractoService.borrar(lineaExtracto);
        return "redirect:/lineasExtracto";
    }
}
