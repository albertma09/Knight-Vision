/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.suscriptions;

/**
 *
 * @author Gerardo S
 */
public class PlayersSuscription {
    private int idplayer;
    private int idsuscription;

    public PlayersSuscription(int idplayer, int idsuscription) {
        this.idplayer = idplayer;
        this.idsuscription = idsuscription;
    }

    public int getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(int idplayer) {
        this.idplayer = idplayer;
    }

    public int getIdsuscription() {
        return idsuscription;
    }

    public void setIdsuscription(int idsuscription) {
        this.idsuscription = idsuscription;
    }
    
    
}
