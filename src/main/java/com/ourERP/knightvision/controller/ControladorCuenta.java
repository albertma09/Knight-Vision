/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.contabilidad.Cuenta;
import com.ourERP.knightvision.service.CuentaService;
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
public class ControladorCuenta {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/")
    public String comienzo(Model model) {

        //String personas = personaDao.findAll();
        List<Cuenta> cuentas = cuentaService.listCuentas();
        model.addAttribute("cuentas", cuentas);

        return "cuentas";
    }
}
