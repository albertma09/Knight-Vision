/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "bankstatementdetails")
public class LineaExtracto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LineaExtractoPK lineaExtractoPK;

    private Date date;
    private String thirdparty;
    private float amount;

    public LineaExtracto() {
    }

    public LineaExtracto(LineaExtractoPK lineaExtractoPK, Date date, String thirdparty, float amount) {
        this.lineaExtractoPK = lineaExtractoPK;
        this.date = date;
        this.thirdparty = thirdparty;
        this.amount = amount;
    }

    public LineaExtractoPK getLineaExtractoPK() {
        return lineaExtractoPK;
    }

    public void setLineaExtractoPK(LineaExtractoPK lineaExtractoPK) {
        this.lineaExtractoPK = lineaExtractoPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "LineaExtracto{" + "lineaExtractoPK=" + lineaExtractoPK + ", date=" + date + ", thirdparty=" + thirdparty + ", amount=" + amount + '}';
    }

}
