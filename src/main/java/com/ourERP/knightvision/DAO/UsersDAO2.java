/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.DAO;

import clases.usuario.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alfred
 */
@Repository
public interface UsersDAO2 extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
}

