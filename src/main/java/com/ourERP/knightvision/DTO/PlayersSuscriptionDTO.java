/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.DTO;

/**
 *
 * @author alber
 */
public class PlayersSuscriptionDTO {
    
    int suscid;
    int playerid;
    String username;

    public PlayersSuscriptionDTO(int suscid, int playerid, String username) {
        this.suscid = suscid;
        this.playerid = playerid;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSuscid() {
        return suscid;
    }

    public void setSuscid(int suscid) {
        this.suscid = suscid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }
    
}