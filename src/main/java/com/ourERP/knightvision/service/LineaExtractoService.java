/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.LineaExtracto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LineaExtractoService {

    public List<LineaExtracto> listLineaExtractos();

    public void salvar(LineaExtracto lineaExtracto);

    public void borrar(LineaExtracto lineaExtracto);

    //public LineaExtracto localizarLineaExtracto(LineaExtracto lineaExtracto);
}
