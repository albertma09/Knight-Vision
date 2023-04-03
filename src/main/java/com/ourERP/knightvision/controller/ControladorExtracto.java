/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.contabilidad.Extracto;
import com.ourERP.knightvision.service.ExtractoService;
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
public class ControladorExtracto {

    @Autowired
    private ExtractoService extractoService;

    @GetMapping("/extractos")
    public String comienzo(Model model) {

        List<Extracto> extractos = extractoService.listExtractos();
        model.addAttribute("extractos", extractos);

        return "extractos";
    }
}
