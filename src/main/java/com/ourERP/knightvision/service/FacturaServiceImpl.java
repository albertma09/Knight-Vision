/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Factura;
import com.ourERP.knightvision.DAO.FacturaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service("FacturaService")
public class FacturaServiceImpl implements FacturaService {

    private final FacturaDAO facturaDAO;

    @Autowired
    public FacturaServiceImpl(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> listFacturas() {
        return (List<Factura>) facturaDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(Factura factura) {
        facturaDAO.save(factura);
    }

    @Override
    @Transactional
    public void borrar(Factura factura) {
        facturaDAO.delete(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura localizarFactura(Factura factura) {
        return facturaDAO.findById(factura.getBillid()).orElse(null);

    }
}
