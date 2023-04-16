/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.DTO;

/**
 *
 * @author alber
 */
public class SuscriptionAtributeDTO {
    
    int suscriptionid;
    String atribute;

    public SuscriptionAtributeDTO(int suscriptionid, String atribute) {
        this.suscriptionid = suscriptionid;
        this.atribute = atribute;
    }

    public SuscriptionAtributeDTO() {
    }

    public int getSuscriptionid() {
        return suscriptionid;
    }

    public void setSuscriptionid(int suscriptionid) {
        this.suscriptionid = suscriptionid;
    }

    public String getAtribute() {
        return atribute;
    }

    public void setAtribute(String atribute) {
        this.atribute = atribute;
    }

    @Override
    public String toString() {
        return "SuscriptionAtributeDTO{" + "suscriptionid=" + suscriptionid + ", atribute=" + atribute + '}';
    }
    
    
}