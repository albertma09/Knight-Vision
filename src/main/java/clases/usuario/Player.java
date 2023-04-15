/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Alfred
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "players")
public class Player  {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Playerid")
    private int playerid;
    
    @Column(name = "elo_catalan")
    private int eloCatalan;
    
    @Column(name = "elo_fide")
    private int eloFide;
    
    @OneToOne
    @JoinColumn(name = "iduser")
    private User users;

    // Setter para playerid
    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }
    
    // Getter para playerid
    public int getPlayerid() {
        return playerid;
    }
    
    // Setter para eloCatalan
    public void setEloCatalan(int eloCatalan) {
        this.eloCatalan = eloCatalan;
    }
    
    // Getter para eloCatalan
    public int getEloCatalan() {
        return eloCatalan;
    }
    
    // Setter para eloFide
    public void setEloFide(int eloFide) {
        this.eloFide = eloFide;
    }
    
    // Getter para eloFide
    public int getEloFide() {
        return eloFide;
    }
    
    // Setter para users
    public void setUsers(User users) {
        this.users = users;
    }
    
    // Getter para users
    public User getUsers() {
        return users;
    }
}

