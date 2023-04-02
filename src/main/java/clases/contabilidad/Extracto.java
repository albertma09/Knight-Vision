/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankstatement")
public class Extracto {

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int bankstatementid;
    private Timestamp startdate;
    private Timestamp enddate;
    private double balance;

    public Extracto() {
    }

    public Extracto(int bankstatementid, Timestamp startdate, Timestamp enddate, double balance) {
        this.bankstatementid = bankstatementid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.balance = balance;
    }

    public int getBankstatementid() {
        return bankstatementid;
    }

    public void setBankstatementid(int bankstatementid) {
        this.bankstatementid = bankstatementid;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Extracto{" + "bankstatementid=" + bankstatementid + ", startdate=" + startdate + ", enddate=" + enddate + ", balance=" + balance + '}';
    }

}
