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
@Data
@Entity
@Table(name = "suscriptionatribute")
public class SuscriptionAtribute implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    private int SuscriptionAtributeid;

    private String atribute;
    
}
