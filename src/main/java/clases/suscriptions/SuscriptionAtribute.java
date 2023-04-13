/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.suscriptions;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author alber
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "suscriptionatribute")
public class SuscriptionAtribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suscriptionatributeid")
    private Integer SuscriptionAtributeid;

    @Column(name = "atribute")
    private String atribute;


    
    
}
