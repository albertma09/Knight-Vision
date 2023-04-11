package clases.suscriptions;

import clases.usuario.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Alfred
 */
public class prueba {
    
    private int SuscriptionAtributeid;

    private String atribute;

    public prueba(int SuscriptionAtributeid, String atribute) {
        this.SuscriptionAtributeid = SuscriptionAtributeid;
        this.atribute = atribute;
    }

    public int getSuscriptionAtributeid() {
        return SuscriptionAtributeid;
    }

    public void setSuscriptionAtributeid(int SuscriptionAtributeid) {
        this.SuscriptionAtributeid = SuscriptionAtributeid;
    }

    public String getAtribute() {
        return atribute;
    }

    public void setAtribute(String atribute) {
        this.atribute = atribute;
    }
    
    
}

