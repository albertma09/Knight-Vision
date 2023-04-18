/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankstatementdetails")
public class LineaExtracto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankstatementdetailid;
    private int bankstatementid;
    private Date eventdate;
    private String thirdparty;
    private float amount;
    private String pagoocobro;

    public LineaExtracto() {
    }

    public LineaExtracto(int bankstatementdetailid, int bankstatementid, Date eventdate, String thirdparty, float amount, String pagoocobro) {
        this.bankstatementdetailid = bankstatementdetailid;
        this.bankstatementid = bankstatementid;
        this.eventdate = eventdate;
        this.thirdparty = thirdparty;
        this.amount = amount;
        this.pagoocobro = pagoocobro;
    }

    public int getBankstatementdetailid() {
        return bankstatementdetailid;
    }

    public void setBankstatementdetailid(int bankstatementdetailid) {
        this.bankstatementdetailid = bankstatementdetailid;
    }

    public int getBankstatementid() {
        return bankstatementid;
    }

    public void setBankstatementid(int bankstatementid) {
        this.bankstatementid = bankstatementid;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getThirdparty() {
        return thirdparty;
    }

    public void setThirdparty(String thirdparty) {
        this.thirdparty = thirdparty;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPagoocobro() {
        return pagoocobro;
    }

    public void setPagoocobro(String pagoocobro) {
        this.pagoocobro = pagoocobro;
    }

    @Override
    public String toString() {
        return "LineaExtracto{" + "bankstatementid=" + bankstatementid + ", bankstatementdetailid=" + bankstatementdetailid + ", eventdate=" + eventdate + ", thirdparty=" + thirdparty + ", amount=" + amount + ", pagoocobro=" + pagoocobro + '}';
    }

}
