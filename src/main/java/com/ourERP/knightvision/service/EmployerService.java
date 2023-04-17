/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Employer;
import clases.usuario.User;
import com.ourERP.knightvision.DAO.EmployersDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alfred
 */
@Service
public class EmployerService implements IemployerService {

    @Autowired
    private EmployersDAO data;

    @Override
    public List<Employer> listar() {
        return (List<Employer>) data.findAll();
    }

    @Override
    public Optional<Employer> listarId(int Employerid) {
        return data.findById(Employerid);
    }

    @Override
    public int save(Employer e) {
         Employer savedEmployer = data.save(e);
        return savedEmployer.getEmployeid();
    }
}
