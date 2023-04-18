/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.contabilidad.Cuenta;
import com.ourERP.knightvision.DAO.CuentaDAO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service("CuentaService")
@Slf4j
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private final CuentaDAO cuentaDAO = null;

//    public CuentaServiceImpl(CuentaDAO cuentaDAO) {
//        this.cuentaDAO = cuentaDAO;
//    }
    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> listCuentas() {
        return (List<Cuenta>) cuentaDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(Cuenta cuenta) {
        cuentaDAO.save(cuenta);
    }

    @Override
    @Transactional
    public void borrar(Cuenta cuenta) {
        cuentaDAO.delete(cuenta);
    }

    @Override
    @Transactional(readOnly = true)
    public Cuenta localizarCuenta(Cuenta cuenta) {
        return cuentaDAO.findById(cuenta.getBankaccountid()).orElse(null);
    }
}
