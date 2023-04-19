/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Employer;
import clases.usuario.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alfred
 */
public interface IemployerService {
    public List<Employer>listar();
    
    public Optional<Employer>listarId(int Employerid);
    
    public int save(Employer e);
}
