/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.User;
import com.ourERP.knightvision.DAO.UsersDAO2;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alfred
 */
@Service
public class UserService implements IuserService {

    @Autowired
    private UsersDAO2 data;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> listar() {
        return (List<User>) data.findAll();
    }

    @Override
    public int save(User u) {
        int res = 0;
        String encodedPassword = encoder.encode(u.getPassword()); // Encriptar la contraseña
        u.setPassword(encodedPassword); // Asignar la contraseña encriptada al objeto User
        User user = data.save(u); // Guardar el objeto User en la base de datos
        if (user != null) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
