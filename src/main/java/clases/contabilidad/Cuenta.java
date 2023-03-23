/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankaccount")
public class Cuenta {

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int bankaccountid;
    private String accountnumber;
    private String bank;
    private int idbankstatement;

    public Cuenta() {
    }

    public Cuenta(int bankaccountid, String accountnumber, String bank, int idbankstatement) {
        this.bankaccountid = bankaccountid;
        this.accountnumber = accountnumber;
        this.bank = bank;
        this.idbankstatement = idbankstatement;
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

    public int getIdbankstatement() {
        return idbankstatement;
    }

    public void setIdbankstatement(int idbankstatement) {
        this.idbankstatement = idbankstatement;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "bankaccountid=" + bankaccountid + ", accountnumber=" + accountnumber + ", bank=" + bank + ", idbankstatement=" + idbankstatement + '}';
    }

}
