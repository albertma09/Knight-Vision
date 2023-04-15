/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Player;
import com.ourERP.knightvision.DAO.PlayersDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alfred
 */
@Service
public class PlayerService implements IplayerService{
    
    @Autowired
    private PlayersDAO data;

    @Override
    public List<Player> listar() {
        return (List<Player>) data.findAll();
    }

    @Override
    public Optional<Player> listarId(int Playerid) {
       return data.findById(Playerid);
    }

    @Override
    public int save(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
