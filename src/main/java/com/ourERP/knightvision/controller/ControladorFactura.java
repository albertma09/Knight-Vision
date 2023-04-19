/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.contabilidad.Factura;
import com.ourERP.knightvision.service.FacturaService;
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
public class ControladorFactura {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas")
    public String comienzo(Model model) {
        model.addAttribute("nav", "Facturas");

        List<Factura> facturas = facturaService.listFacturas();
        model.addAttribute("facturas", facturas);

        return "facturas";
    }

    @GetMapping("/anexarFactura")
    public String agnadir(Factura factura) {

        return "cambiarFactura";
    }

    @PostMapping("/salvarFactura")
    public String salvar(Factura factura) {
        facturaService.salvar(factura);
        return "redirect:/facturas";

    }

    @GetMapping("/cambiarFactura/{billid}")
    public String cambiar(Factura factura, Model model) {
        factura = facturaService.localizarFactura(factura);
        model.addAttribute("factura", factura);
        return "cambiarFactura";
    }

    @GetMapping("/borrarFactura/{billid}")
    public String borrar(Factura factura) {
        facturaService.borrar(factura);
        return "redirect:/facturas";
    }
}
