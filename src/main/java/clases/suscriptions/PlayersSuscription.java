/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.suscriptions;

import clases.usuario.Player;
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
 * @author Gerardo S
 */

@Entity
@Table(name = "players-suscription")
public class PlayersSuscription implements Serializable {

    @EmbeddedId
    private PlayersSuscriptionId id;

    @ManyToOne
    @JoinColumn(name = "idplayer", insertable = false, updatable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "idsuscription", insertable = false, updatable = false)
    private Suscriptions suscription;

    // Constructors
    public PlayersSuscription() {}

    public PlayersSuscription(PlayersSuscriptionId id, Player player, Suscriptions suscription) {
        this.id = id;
        this.player = player;
        this.suscription = suscription;
    }

    // Getters and setters
    public PlayersSuscriptionId getId() {
        return id;
    }

    public void setId(PlayersSuscriptionId id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Suscriptions getSuscription() {
        return suscription;
    }

    public void setSuscription(Suscriptions suscription) {
        this.suscription = suscription;
    }

    // Inner class for composite primary key
    @Embeddable
    public static class PlayersSuscriptionId implements Serializable {

        @Column(name = "idplayer")
        private Integer idplayer;

        @Column(name = "idsuscription")
        private Integer suscriptionid;

        // Constructors
        public PlayersSuscriptionId() {}

        public PlayersSuscriptionId(Integer idplayer, Integer suscriptionid) {
            this.idplayer = idplayer;
            this.suscriptionid = suscriptionid;
        }

        // Getters and setters
        public Integer getIdplayer() {
            return idplayer;
        }

        public void setIdplayer(Integer idplayer) {
            this.idplayer = idplayer;
        }

        public Integer getSuscriptionid() {
            return suscriptionid;
        }

        public void setSuscriptionid(Integer suscriptionid) {
            this.suscriptionid = suscriptionid;
        }

        // Override equals and hashCode
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlayersSuscriptionId)) {
                return false;
            }
            PlayersSuscriptionId other = (PlayersSuscriptionId) obj;
            return idplayer.equals(other.idplayer) && suscriptionid.equals(other.suscriptionid);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + idplayer;
            result = 31 * result + suscriptionid;
            return result;
        }
    }
}
