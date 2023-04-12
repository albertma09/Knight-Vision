/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.eventos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author alber
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "events")
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Eventid")
    private Integer id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "type")
    private String tipo;

    @Column(name = "startdate")
    private LocalDateTime fechaInicio;

    @Column(name = "enddate")
    private LocalDateTime fechaFin;

    
    
}
