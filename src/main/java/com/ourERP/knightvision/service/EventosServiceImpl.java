/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Eventos;
import com.ourERP.knightvision.DAO.EventosDAO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alber
 */
@Service("EventosService")
@Slf4j
public class EventosServiceImpl implements EventosService {

    @Autowired
    private final EventosDAO eventoDAO = null;
    
    @Override
    @Transactional (readOnly = true)
    public List<Eventos> listEventos() {
      return (List<Eventos>) eventoDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(Eventos evento) {
        this.eventoDAO.save(evento);
    }

    @Override
    public void borrar(Eventos evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Eventos localizarCuenta(Eventos evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
