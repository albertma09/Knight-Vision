/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.User;
import java.util.List;

/**
 *
 * @author Alfred
 */
public interface IuserService {
    public List<User>listar();
    
    public int save(User u);
    
    public void delete(int id);
    
}
