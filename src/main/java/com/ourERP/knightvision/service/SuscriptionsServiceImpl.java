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
    private final SuscriptionAtributeDAO suscriptionAtributeDAO = null;
    @Autowired
    private final PlayersSuscriptionDAO playersSuscriptionDAO = null;
    @Autowired
    private final SuscriptionsDAO suscriptionsDAO = null;
    
    @Override
    @Transactional (readOnly = true)
    public List<SuscriptionAtribute> listSuscriptionsAtributes() {
      return (List<SuscriptionAtribute>) suscriptionAtributeDAO.findAll();
    }

    @Override
    public void salvar(SuscriptionAtribute item) {
        this.suscriptionAtributeDAO.save(item);
    }

    @Override
    public void borrar(SuscriptionAtribute item) {
        this.suscriptionAtributeDAO.delete(item);
    }
    
    @Override
    @Transactional (readOnly = true)
    public List<PlayersSuscription> listPlayersSuscription() {
      return (List<PlayersSuscription>) playersSuscriptionDAO.findAll();
    }
    
   @Override
    public void salvarPlayersSuscription(PlayersSuscription item) {
        this.playersSuscriptionDAO.save(item);
    }

    @Override
    public void borrarPlayersSuscription(PlayersSuscription item) {
        this.playersSuscriptionDAO.delete(item);
    }
    
        @Override
    @Transactional (readOnly = true)
    public List<Suscriptions> listSuscriptions() {
      return (List<Suscriptions>) suscriptionsDAO.findAll();
    }
    
   @Override
   @Transactional
    public void salvarSuscriptions(Suscriptions item) {
        this.suscriptionsDAO.save(item);
    }

    @Override
    @Transactional
    public void borrarSuscriptions(Suscriptions item) {
        this.suscriptionsDAO.delete(item);
    }

    
}
