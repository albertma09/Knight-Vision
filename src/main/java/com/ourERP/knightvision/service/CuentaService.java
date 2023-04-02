/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CuentaService {

    public List<Cuenta> listCuentas();

    public void salvar(Cuenta cuenta);

    public void borrar(Cuenta cuenta);

    public Cuenta localizarCuenta(Cuenta cuenta);
}
