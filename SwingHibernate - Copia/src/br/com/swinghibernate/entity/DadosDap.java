package br.com.swinghibernate.entity;

import java.io.Serializable;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author renato
 */
@Entity
@Table(name = "DadosDap")
public class DadosDap implements Serializable {
    private static final Logger LOG = getLogger(DadosDap.class.getName());
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @Column(name = "idDAP", nullable = false, insertable = true)
    private int idDAP;
    @Column(name = "Altura", length = 5, nullable = false)
    private float Altura;
    @Column(name = "Diametro", length = 5, nullable = false)
    private float Diametro;
    @Column(name = "calG", length = 6, nullable = false)
    private float calG;
    @Column(name = "calX", length = 6, nullable = false)
    private float calX;
    @Column(name = "calY", length = 6, nullable = false)
    private float calY;

    /**
     *
     */
    public DadosDap() {
        idDAP = 0;
    }

    /**
     *
     * @return
     */
    public long getIdDAP() {
        return idDAP;
    }

    /**
     *
     * @param idDAP
     */
    public void setIdDAP(int idDAP) {
        this.idDAP = idDAP;
    }

    /**
     *
     * @return
     */
    public float getAltura() {
        return Altura;
    }

    /**
     *
     * @param Altura
     */
    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    /**
     *
     * @return
     */
    public float getDiametro() {
        return Diametro;
    }

    /**
     *
     * @param Diametro
     */
    public void setDiametro(float Diametro) {
        this.Diametro = Diametro;
    }

    /**
     *
     * @return
     */
    public float getCalG() {
        return calG;
    }

    /**
     *
     * @param calG
     */
    public void setCalG(float calG) {
        this.calG = calG;
    }

    /**
     *
     * @return
     */
    public float getCalX() {
        return calX;
    }

    /**
     *
     * @param calX
     */
    public void setCalX(float calX) {
        this.calX = calX;
    }

    /**
     *
     * @return
     */
    public float getCalY() {
        return calY;
    }

    /**
     *
     * @param calY
     */
    public void setCalY(float calY) {
        this.calY = calY;
    }

}
