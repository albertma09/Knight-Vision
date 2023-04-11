/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankaccount")
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int bankaccountid;
    private String bank;
    private String accountnumber;
    private float panoja;

    public Cuenta() {
    }

    public Cuenta(int bankaccountid, String bank, String accountnumber, float panoja) {
        this.bankaccountid = bankaccountid;
        this.bank = bank;
        this.accountnumber = accountnumber;
        this.panoja = panoja;
    }

    public int getBankaccountid() {
        return bankaccountid;
    }

    public void setBankaccountid(int bankaccountid) {
        this.bankaccountid = bankaccountid;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public float getPanoja() {
        return panoja;
    }

    public void setPanoja(float panoja) {
        this.panoja = panoja;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "bankaccountid=" + bankaccountid + ", bank=" + bank + ", accountnumber=" + accountnumber + ", panoja=" + panoja + '}';
    }

}
