/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Player;
import clases.usuario.User;
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
public class PlayerService implements IplayerService {

    @Autowired
    private PlayersDAO data;

    @Autowired
    private IuserService serviceUser;

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
        Player savedPlayer = data.save(p);
        return savedPlayer.getPlayerid();
    }

    @Override
    public void delete(int userid) {
        Optional<User> user = serviceUser.listarId(userid);
        if (user.isPresent()) {
            // Eliminar registros relacionados en la tabla "players"
            data.deleteByUsers(user.get());
            // Eliminar registro correspondiente en la tabla "users"
            serviceUser.delete(userid);
        }
    }
}
