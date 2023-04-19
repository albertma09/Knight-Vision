/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.LineaExtracto;
import com.ourERP.knightvision.DAO.LineaExtractoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service("LineaExtractoService")
public class LineaExtractoServiceImpl implements LineaExtractoService {

    private final LineaExtractoDAO lineaExtractoDAO;

    @Autowired
    public LineaExtractoServiceImpl(LineaExtractoDAO lineaExtractoDAO) {
        this.lineaExtractoDAO = lineaExtractoDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LineaExtracto> listLineasExtracto() {
        return (List<LineaExtracto>) lineaExtractoDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(LineaExtracto lineaExtracto) {
        lineaExtractoDAO.save(lineaExtracto);
    }

    @Override
    @Transactional
    public void borrar(LineaExtracto lineaExtracto) {
        lineaExtractoDAO.delete(lineaExtracto);
    }

    @Override
    @Transactional(readOnly = true)
    public LineaExtracto localizarLineaExtracto(LineaExtracto lineaExtracto) {
        return lineaExtractoDAO.findById(lineaExtracto.getBankstatementdetailid()).orElse(null);

    }
}
