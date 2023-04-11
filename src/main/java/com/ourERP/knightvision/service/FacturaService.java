/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Factura;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FacturaService {

    public List<Factura> listFacturas();

    public void salvar(Factura factura);

    public void borrar(Factura factura);

    public Factura localizarFactura(Factura factura);
}
