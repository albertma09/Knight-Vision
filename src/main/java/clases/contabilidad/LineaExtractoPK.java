/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.contabilidad;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
@Embeddable
public class LineaExtractoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer bankstatementid;
    protected Integer bankstatementdetailid;

    public LineaExtractoPK() {
    }

    public LineaExtractoPK(Integer bankstatementid, Integer bankstatementdetailid) {
        this.bankstatementid = bankstatementid;
        this.bankstatementdetailid = bankstatementdetailid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.bankstatementid);
        hash = 97 * hash + Objects.hashCode(this.bankstatementdetailid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineaExtractoPK other = (LineaExtractoPK) obj;
        if (!Objects.equals(this.bankstatementid, other.bankstatementid)) {
            return false;
        }
        return Objects.equals(this.bankstatementdetailid, other.bankstatementdetailid);
    }

}
