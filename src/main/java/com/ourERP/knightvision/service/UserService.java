/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Employer;
import clases.usuario.Player;
import clases.usuario.User;
import com.ourERP.knightvision.DAO.EmployersDAO;
import com.ourERP.knightvision.DAO.PlayersDAO;
import com.ourERP.knightvision.DAO.UsersDAO2;
import java.util.List;
import java.util.Optional;
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
    private UsersDAO2 userData;

    @Autowired
    PlayersDAO playerData;

    @Autowired
    EmployersDAO employerData;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> listar() {
        return (List<User>) userData.findAll();
    }

    @Override
    public Optional<User> listarId(int userid) {
        return userData.findById(userid);
    }

    @Override
    public int save(User u) {
        int res = 0;
        String encodedPassword = encoder.encode(u.getPassword()); // Encriptar la contraseña
        u.setPassword(encodedPassword); // Asignar la contraseña encriptada al objeto User

        // Crear el usuario en la tabla User
        User user = userData.save(u);

        // Crear el usuario en la tabla correspondiente según el rol
        if (u.getRol() == 1) { // Employer
            Employer employer = new Employer();
            employer.setUsername(u.getUsername());
            employer.setUser(user);
            employerData.save(employer);
        } else if (u.getRol() == 2) { // Player
            Player player = new Player();
            player.setUsername(u.getUsername());
            player.setUser(user);
            playerData.save(player);
        }

        if (user != null) {
            res = 1;
        }
        return res;
    }

    @Override
    public int update(User user) {
        int result = 0;

        User existingUser = userData.findById(user.getUserid()).orElse(null);
        if (existingUser != null) {
            // Check if the password has been modified
            if (user.getPassword().equals(existingUser.getPassword())) {
                // Use the existing password
                user.setPassword(existingUser.getPassword());
            } else {
                // Encode the new password
                user.setPassword(encoder.encode(user.getPassword()));
            }

            // Save user
            User savedUser = userData.save(user);

            // Update user in employer or player tables
            if (user.getRol() == 1) {
                Optional<Employer> optionalEmployer = employerData.findByUsers(savedUser);
                if (optionalEmployer.isPresent()) {
                    Employer employer = optionalEmployer.get();
                    employer.setUser(savedUser);
                    employer.setUsername(savedUser.getUsername());
                    employerData.save(employer);
                }
            } else if (user.getRol() == 2) {
                Optional<Player> optionalPlayer = playerData.findByUsers(savedUser);
                if (optionalPlayer.isPresent()) {
                    Player player = optionalPlayer.get();
                    player.setUser(savedUser);
                    player.setUsername(savedUser.getUsername());
                    playerData.save(player);
                }
            }

            result = 1;
        }

        return result;
    }

    @Override
    public void delete(int userid) {
        Optional<User> user = listarId(userid);
        if (user.isPresent()) {
            // Eliminar registros relacionados en la tabla "players"
            playerData.deleteByUsers(user.get());
            // Eliminar registro correspondiente en la tabla "users"
            userData.deleteById(userid);
        }
    }

    @Override
    public User findByUsername(String username) {
        return this.userData.findByUsername(username);
    }
}
