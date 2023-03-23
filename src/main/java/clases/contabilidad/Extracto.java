/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankstatement")
public class Extracto {

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int bankstatementid;
    private Timestamp startdate;
    private Timestamp enddate;
    private double balance;

}
