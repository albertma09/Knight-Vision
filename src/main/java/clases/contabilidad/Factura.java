/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bill")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //defineix la clau primaria de la taula
    @GeneratedValue(strategy = GenerationType.IDENTITY) //defineix que el id és autogenerat per la base de dades i és de tipus AI (autoincrement)
    private int billid;
    private String concept;
    private Timestamp billdate;
    private String emisor;
    private float amount;

    public Factura() {
    }

    public Factura(int billid, String concept, Timestamp date, String emisor, float amount) {
        this.billid = billid;
        this.concept = concept;
        this.billdate = date;
        this.emisor = emisor;
        this.amount = amount;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getBilldate() {
        return billdate;
    }

    public void setBilldate(Timestamp billdate) {
        this.billdate = billdate;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    @Override
    public String toString() {
        return "Factura{" + "billid=" + billid + ", concept=" + concept + ", date=" + billdate + ", emisor=" + emisor + ", amount=" + amount + '}';
    }

}
