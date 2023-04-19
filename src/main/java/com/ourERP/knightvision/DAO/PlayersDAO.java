/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.DAO;

import clases.usuario.Player;
import clases.usuario.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alfred
 */
@Repository
public interface PlayersDAO extends CrudRepository<Player, Integer> {
    @Transactional
    @Modifying
    void deleteByUsers(@Param("users") User user);
    
    Optional<Player> findByUsers(User user);
}