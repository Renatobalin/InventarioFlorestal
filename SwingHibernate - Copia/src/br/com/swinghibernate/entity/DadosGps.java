package br.com.swinghibernate.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author renato
 */
@Entity
@Table(name = "DadosGps")
public class DadosGps implements Serializable {
    private static final Logger LOG = getLogger(DadosGps.class.getName());
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @Column(name = "idGPS")
    private int id;
    @Column(name = "t", length = 2, nullable = false)
    private String t;
    @Column(name = "utm", length = 3, nullable = false)
    private String utm;
    @Column(name = "modelo", length = 3, nullable = false)
    private String modelo;
    @Column(name = "coordx", length = 10, nullable = false)
    private float coordx;
    @Column(name = "coordy", length = 10, nullable = false)
    private float coordy;
    @Column(name = "data", length = 8, nullable = false)
    private Date datColeta;
    @Column(name = "hora", length = 8, nullable = false)
    private Time hora;
    @Column(name = "posicao", length = 10, nullable = false)
    private float posicao;

    /**
     *
     */
    public DadosGps() {
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getT() {
        return t;
    }

    /**
     *
     * @param t
     */
    public void setT(String t) {
        this.t = t;
    }

    /**
     *
     * @return
     */
    public String getUtm() {
        return utm;
    }

    /**
     *
     * @param utm
     */
    public void setUtm(String utm) {
        this.utm = utm;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public float getCoordx() {
        return coordx;
    }

    /**
     *
     * @param coordx
     */
    public void setCoordx(float coordx) {
        this.coordx = coordx;
    }

    /**
     *
     * @return
     */
    public float getCoordy() {
        return coordy;
    }

    /**
     *
     * @param coordy
     */
    public void setCoordy(long coordy) {
        this.coordy = coordy;
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return datColeta;
    }

    /**
     *
     * @param data
     */
    public void setData(Date data) {
        this.datColeta = data;
    }

    /**
     *
     * @return
     */
    public Time getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     *
     * @return
     */
    public float getPosicao() {
        return posicao;
    }

    /**
     *
     * @param posicao
     */
    public void setPosicao(long posicao) {
        this.posicao = posicao;
    }

}
