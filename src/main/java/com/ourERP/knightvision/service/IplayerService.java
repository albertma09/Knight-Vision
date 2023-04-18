/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Player;
import clases.usuario.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alfred
 */
public interface IplayerService {
    public List<Player>listar();
    
    public Optional<Player>listarId(int Playerid);
    
    public int save(Player p);
    
    public void delete(int userid);
}
