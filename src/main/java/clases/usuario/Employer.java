/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.usuario;

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
import lombok.Data;

/**
 *
 * @author Alfred
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employes")
public class Employer implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int Employeid;
    
    private String username;
    
    private float salary;
    
    private String type;

    @OneToOne
    @JoinColumn(name = "iduser", referencedColumnName = "userid")
    private User users;
    
   public User getUser() {
        return this.users;
    }

    public void setUser(User user) {
        this.users = user;
        if (user != null) {
            this.users.getUserid();
        }
    }

    public int getUserid() {
        if (this.users != null) {
            return this.users.getUserid();
        } else {
            return 0;
        }
    }

    public void setIduser(int iduser) {
        if (this.users != null) {
            this.users.setUserid(iduser);
        }
    }
    
}