/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Extracto;
import com.ourERP.knightvision.DAO.ExtractoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service("ExtractoService")
public class ExtractoServiceImpl implements ExtractoService {

    private final ExtractoDAO extractoDAO;

    @Autowired
    public ExtractoServiceImpl(ExtractoDAO extractoDAO) {
        this.extractoDAO = extractoDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Extracto> listExtractos() {
        return (List<Extracto>) extractoDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(Extracto extracto) {
        extractoDAO.save(extracto);
    }

    @Override
    @Transactional
    public void borrar(Extracto extracto) {
        extractoDAO.delete(extracto);
    }

    @Override
    @Transactional(readOnly = true)
    public Extracto localizarExtracto(Extracto extracto) {
        return extractoDAO.findById(extracto.getBankstatementid()).orElse(null);

    }
}
