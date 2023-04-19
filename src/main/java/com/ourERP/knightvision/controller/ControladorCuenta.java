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
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class ControladorCuenta {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuentas")
    public String comienzo(Model model) {
        model.addAttribute("nav", "Cuentas");

        List<Cuenta> cuentas = cuentaService.listCuentas();
        model.addAttribute("cuentas", cuentas);

        return "cuentas";
    }

    @GetMapping("/anexarCuenta")
    public String agnadir(Cuenta cuenta) {

        return "cambiarCuenta";
    }

    @PostMapping("/salvarCuenta")
    public String salvar(Cuenta cuenta) {
        cuentaService.salvar(cuenta);
        return "redirect:/cuentas";

    }

    @GetMapping("/cambiarCuenta/{bankaccountid}")
    public String cambiar(Cuenta cuenta, Model model) {
        cuenta = cuentaService.localizarCuenta(cuenta);
        model.addAttribute("cuenta", cuenta);
        return "cambiarCuenta";
    }
    //method persist() for save item to Jpa virtual data base;
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(Cuenta cuenta) {
//        cuentaService.salvar(cuenta);
//        return "redirect:/";
//    }
//
//    //method update for find & edit item by item Id;
//    @GetMapping("/edit")
//    @ResponseBody
//    public Optional<Cuenta> update(Integer id) {
//        return cuentaService.localizarCuenta(id);
//    }

    @GetMapping("/borrarCuenta/{bankaccountid}")
    public String borrar(Cuenta cuenta) {
        cuentaService.borrar(cuenta);
        return "redirect:/cuentas";
    }
}
