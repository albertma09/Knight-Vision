/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ourERP.knightvision.DAO;

import clases.usuario.Employer;
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
public interface EmployersDAO extends CrudRepository<Employer, Integer> {
    @Transactional
    @Modifying
    void deleteByUsers(@Param("users") User user);

    Optional<Employer> findByUsers(User user);
}
