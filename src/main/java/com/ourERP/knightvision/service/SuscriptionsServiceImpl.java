/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.suscriptions.PlayersSuscription;
import clases.suscriptions.SuscriptionAtribute;
import clases.suscriptions.Suscriptions;
import com.ourERP.knightvision.DAO.PlayersSuscriptionDAO;
import com.ourERP.knightvision.DAO.SuscriptionAtributeDAO;
import com.ourERP.knightvision.DAO.SuscriptionsDAO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alber
 */
@Service("SuscriptionsService")
@Slf4j
public class SuscriptionsServiceImpl implements SuscriptionsService {

    @Autowired
    private final SuscriptionAtributeDAO sucriptionAtributeDAO = null;
    @Autowired
    private final PlayersSuscriptionDAO playersSuscriptionDAO = null;
    @Autowired
    private final SuscriptionsDAO suscriptionsDAO = null;
    
    @Override
    @Transactional (readOnly = true)
    public List<SuscriptionAtribute> listSuscriptionsAtributes() {
      return (List<SuscriptionAtribute>) sucriptionAtributeDAO.findAll();
    }

    @Override
    public void salvar(SuscriptionAtribute cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(SuscriptionAtribute cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    @Transactional (readOnly = true)
    public List<PlayersSuscription> listPlayersSuscription() {
      return (List<PlayersSuscription>) playersSuscriptionDAO.findAll();
    }
    
   @Override
    public void salvarPlayersSuscription(PlayersSuscription item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarPlayersSuscription(PlayersSuscription cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        @Override
    @Transactional (readOnly = true)
    public List<Suscriptions> listSuscriptions() {
      return (List<Suscriptions>) suscriptionsDAO.findAll();
    }
    
   @Override
    public void salvarSuscriptions(Suscriptions item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarSuscriptions(Suscriptions cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
