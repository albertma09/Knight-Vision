package clases.usuario;

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
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    private String username;

    private String name;

    private String lastname;

    private String password;

    private String email;

    private Integer rol;

    @JoinColumn(name = "iduser", referencedColumnName = "userid")
    @OneToOne(mappedBy = "users")
    private Player player;

    @JoinColumn(name = "iduser", referencedColumnName = "userid")
    @OneToOne(mappedBy = "users")
    private Employer employer;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return this.userid;
    }

}