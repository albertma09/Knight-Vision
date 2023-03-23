/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankstatementdetails")
public class LineaExtracto {

}
