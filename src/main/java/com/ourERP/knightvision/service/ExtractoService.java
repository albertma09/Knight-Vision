/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Extracto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ExtractoService {

    public List<Extracto> listExtractos();

    public void salvar(Extracto extracto);

    public void borrar(Extracto extracto);

    public Extracto localizarExtracto(Extracto extracto);
}
