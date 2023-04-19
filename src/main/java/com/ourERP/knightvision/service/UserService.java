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
import java.util.Objects;
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

            // Check if the role has changed
            if (!Objects.equals(existingUser.getRol(), user.getRol())) {
                // Delete user from the corresponding table
                if (existingUser.getRol() == 1) {
                    Optional<Employer> optionalEmployer = employerData.findByUsers(existingUser);
                    if (optionalEmployer.isPresent()) {
                        employerData.deleteById(optionalEmployer.get().getEmployeid());
                    }
                } else if (existingUser.getRol() == 2) {
                    Optional<Player> optionalPlayer = playerData.findByUsers(existingUser);
                    if (optionalPlayer.isPresent()) {
                        playerData.deleteById(optionalPlayer.get().getPlayerid());
                    }
                }

                // Add user to the other table
                if (user.getRol() == 1) {
                    // Delete existing user from player table
                    Optional<Player> optionalPlayer = playerData.findByUsers(existingUser);
                    if (optionalPlayer.isPresent()) {
                        playerData.deleteById(optionalPlayer.get().getPlayerid());
                    }

                    // Add user to employer table
                    Employer employer = new Employer();
                    employer.setUser(user);
                    employer.setUsername(user.getUsername());
                    employerData.save(employer);
                } else if (user.getRol() == 2) {
                    // Delete existing user from employer table
                    Optional<Employer> optionalEmployer = employerData.findByUsers(existingUser);
                    if (optionalEmployer.isPresent()) {
                        employerData.deleteById(optionalEmployer.get().getEmployeid());
                    }

                    // Add user to player table
                    Player player = new Player();
                    player.setUser(user);
                    player.setUsername(user.getUsername());
                    playerData.save(player);
                }
            }

            // Check if the username has been modified
            if (!Objects.equals(existingUser.getUsername(), user.getUsername())) {
                // Update the username in the users table
                existingUser.setUsername(user.getUsername());
                userData.save(existingUser);

                // Update the username in the related table
                if (existingUser.getRol() == 1) {
                    Optional<Employer> optionalEmployer = employerData.findByUsers(existingUser);
                    if (optionalEmployer.isPresent()) {
                        Employer employer = optionalEmployer.get();
                        employer.setUsername(user.getUsername());
                        employerData.save(employer);
                    }
                } else if (existingUser.getRol() == 2) {
                    Optional<Player> optionalPlayer = playerData.findByUsers(existingUser);
                    if (optionalPlayer.isPresent()) {
                        Player player = optionalPlayer.get();
                        player.setUsername(user.getUsername());
                        playerData.save(player);
                    }
                }
            }  // Check if the email has been modified
            if (!Objects.equals(existingUser.getEmail(), user.getEmail())) {
                // Check if the new email already exists
                if (userData.findByEmail(user.getEmail()).isPresent()) {
                    // The new email already exists
                    return result;
                } else {
                    // Update the email
                    existingUser.setEmail(user.getEmail());
                }
            }
            userData.save(user);

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

    @Override
    public Optional<User> findByEmail(String email) {
        return userData.findByEmail(email);
    }
}
