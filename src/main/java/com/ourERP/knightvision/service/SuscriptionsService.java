/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.suscriptions.PlayersSuscription;
import clases.suscriptions.SuscriptionAtribute;
import clases.suscriptions.Suscriptions;
import java.util.List;

/**
 *
 * @author alber
 */
public interface SuscriptionsService {
    
    public List<SuscriptionAtribute> listSuscriptionsAtributes();

    public void salvar(SuscriptionAtribute item);

    public void borrar(SuscriptionAtribute item);
    //

    public List<PlayersSuscription> listPlayersSuscription();

    public void salvarPlayersSuscription(PlayersSuscription item);

    public void borrarPlayersSuscription(PlayersSuscription item);
    
    //
    public List<Suscriptions> listSuscriptions();

    public void salvarSuscriptions(Suscriptions item);

    public void borrarSuscriptions(Suscriptions item);

}
