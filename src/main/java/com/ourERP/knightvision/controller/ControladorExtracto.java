/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.contabilidad.Cuenta;
import clases.contabilidad.Extracto;
import com.ourERP.knightvision.service.CuentaService;
import com.ourERP.knightvision.service.ExtractoService;
import java.util.ArrayList;
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
public class ControladorExtracto {

    @Autowired
    private ExtractoService extractoService;

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/extractos")
    public String comienzo(Model model) {
        model.addAttribute("nav", "Extractos");

        List<Extracto> extractos = extractoService.listExtractos();
        model.addAttribute("extractos", extractos);

        return "extractos";
    }

    @GetMapping("/anexarExtracto")
    public String agnadir(Extracto extracto, Model model) {
        List<Cuenta> cuentas = cuentaService.listCuentas();
        List<Integer> ids = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            ids.add(cuenta.getBankaccountid());
        }
        model.addAttribute("ids", ids);
        return "cambiarExtracto";
    }

    @PostMapping("/salvarExtracto")
    public String salvar(Extracto extracto) {
        extractoService.salvar(extracto);
        return "redirect:/extractos";

    }

    @GetMapping("/cambiarExtracto/{bankstatementid}")
    public String cambiar(Extracto extracto, Model model) {
        extracto = extractoService.localizarExtracto(extracto);
        model.addAttribute("extracto", extracto);
        return "cambiarExtracto";
    }

    @GetMapping("/borrarExtracto/{bankstatementid}")
    public String borrar(Extracto extracto) {
        extractoService.borrar(extracto);
        return "redirect:/extractos";
    }

    @GetMapping("/mostrarLineasExtracto")
    public String irALineasDeExtracto() {
        return "redirect:/lineasExtracto";
    }
}
