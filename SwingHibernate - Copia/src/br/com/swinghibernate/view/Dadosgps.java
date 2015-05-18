/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.swinghibernate.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "dadosgps", catalog = "ProjetoEngenharia", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Dadosgps.findAll", query = "SELECT d FROM Dadosgps d"),
    @NamedQuery(name = "Dadosgps.findById", query = "SELECT d FROM Dadosgps d WHERE d.id = :id"),
    @NamedQuery(name = "Dadosgps.findByCoordx", query = "SELECT d FROM Dadosgps d WHERE d.coordx = :coordx"),
    @NamedQuery(name = "Dadosgps.findByCoordy", query = "SELECT d FROM Dadosgps d WHERE d.coordy = :coordy"),
    @NamedQuery(name = "Dadosgps.findByData", query = "SELECT d FROM Dadosgps d WHERE d.data = :data"),
    @NamedQuery(name = "Dadosgps.findByHora", query = "SELECT d FROM Dadosgps d WHERE d.hora = :hora"),
    @NamedQuery(name = "Dadosgps.findByModelo", query = "SELECT d FROM Dadosgps d WHERE d.modelo = :modelo"),
    @NamedQuery(name = "Dadosgps.findByPosicao", query = "SELECT d FROM Dadosgps d WHERE d.posicao = :posicao"),
    @NamedQuery(name = "Dadosgps.findByT", query = "SELECT d FROM Dadosgps d WHERE d.t = :t"),
    @NamedQuery(name = "Dadosgps.findByUtm", query = "SELECT d FROM Dadosgps d WHERE d.utm = :utm")})
public class Dadosgps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private final PropertyChangeSupport changeSupport;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "coordx")
    private float coordx;
    @Basic(optional = false)
    @Column(name = "coordy")
    private float coordy;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "posicao")
    private float posicao;
    @Basic(optional = false)
    @Column(name = "t")
    private String t;
    @Basic(optional = false)
    @Column(name = "utm")
    private String utm;

    /**
     *
     */
    public Dadosgps() {
        this.changeSupport = new PropertyChangeSupport(this);
    }

    /**
     *
     * @param id
     */
    public Dadosgps(Integer id) {
        this.changeSupport = new PropertyChangeSupport(this);
        this.id = id;
    }

    /**
     *
     * @param id
     * @param coordx
     * @param coordy
     * @param data
     * @param hora
     * @param modelo
     * @param posicao
     * @param t
     * @param utm
     */
    public Dadosgps(Integer id, float coordx, float coordy, Date data, Date hora, String modelo, float posicao, String t, String utm) {
        this.changeSupport = new PropertyChangeSupport(this);
        this.id = id;
        this.coordx = coordx;
        this.coordy = coordy;
        this.data = data;
        this.hora = hora;
        this.modelo = modelo;
        this.posicao = posicao;
        this.t = t;
        this.utm = utm;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
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
        float oldCoordx = this.coordx;
        this.coordx = coordx;
        changeSupport.firePropertyChange("coordx", oldCoordx, coordx);
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
    public void setCoordy(float coordy) {
        float oldCoordy = this.coordy;
        this.coordy = coordy;
        changeSupport.firePropertyChange("coordy", oldCoordy, coordy);
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    /**
     *
     * @return
     */
    public Date getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
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
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
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
    public void setPosicao(float posicao) {
        float oldPosicao = this.posicao;
        this.posicao = posicao;
        changeSupport.firePropertyChange("posicao", oldPosicao, posicao);
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
        String oldT = this.t;
        this.t = t;
        changeSupport.firePropertyChange("t", oldT, t);
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
        String oldUtm = this.utm;
        this.utm = utm;
        changeSupport.firePropertyChange("utm", oldUtm, utm);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dadosgps)) {
            return false;
        }
        Dadosgps other = (Dadosgps) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "br.com.swinghibernate.view.Dadosgps[ id=" + id + " ]";
    }

    /**
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    /**
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    private static final Logger LOG = Logger.getLogger(Dadosgps.class.getName());
    
}
