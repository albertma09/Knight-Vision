/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.suscriptions;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author alber
 */
@Entity
@Table(name = "suscriptionatribute")
public class SuscriptionAtribute {

    @EmbeddedId
    private SuscriptionAtributeId id;

    public SuscriptionAtribute() {
    }

    public SuscriptionAtribute(Suscriptions suscription, String atribute) {
        this.id = new SuscriptionAtributeId(suscription, atribute);
    }

    public SuscriptionAtributeId getId() {
        return id;
    }

    public void setId(SuscriptionAtributeId id) {
        this.id = id;
    }

    public Suscriptions getSuscription() {
        return id.getSuscription();
    }

    public void setSuscription(Suscriptions suscription) {
        id.setSuscription(suscription);
    }

    public String getAtribute() {
        return id.getAtribute();
    }

    public void setAtribute(String atribute) {
        id.setAtribute(atribute);
    }

    // equals and hashCode methods
    @Embeddable
    public static class SuscriptionAtributeId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "suscriptionid")
        private Suscriptions suscription;

        @Column(name = "atribute")
        private String atribute;

        public SuscriptionAtributeId() {
        }

        public SuscriptionAtributeId(Suscriptions suscription, String atribute) {
            this.suscription = suscription;
            this.atribute = atribute;
        }

        public Suscriptions getSuscription() {
            return suscription;
        }

        public void setSuscription(Suscriptions suscription) {
            this.suscription = suscription;
        }

        public String getAtribute() {
            return atribute;
        }

        public void setAtribute(String atribute) {
            this.atribute = atribute;
        }

        // equals and hashCode methods
    }
}