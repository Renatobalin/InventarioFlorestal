/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.swinghibernate.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "dadosdap", catalog = "ProjetoEngenharia", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Dadosdap.findAll", query = "SELECT d FROM Dadosdap d"),
    @NamedQuery(name = "Dadosdap.findByIddap", query = "SELECT d FROM Dadosdap d WHERE d.iddap = :iddap"),
    @NamedQuery(name = "Dadosdap.findByAltura", query = "SELECT d FROM Dadosdap d WHERE d.altura = :altura"),
    @NamedQuery(name = "Dadosdap.findByDiametro", query = "SELECT d FROM Dadosdap d WHERE d.diametro = :diametro"),
    @NamedQuery(name = "Dadosdap.findByCalg", query = "SELECT d FROM Dadosdap d WHERE d.calg = :calg"),
    @NamedQuery(name = "Dadosdap.findByCalx", query = "SELECT d FROM Dadosdap d WHERE d.calx = :calx"),
    @NamedQuery(name = "Dadosdap.findByCaly", query = "SELECT d FROM Dadosdap d WHERE d.caly = :caly")})
public class Dadosdap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @Basic(optional = false)
    @Column(name = "iddap")
    private Integer iddap;
    @Basic(optional = false)
    @Column(name = "altura")
    private float altura;
    @Basic(optional = false)
    @Column(name = "diametro")
    private float diametro;
    @Basic(optional = false)
    @Column(name = "calg")
    private float calg;
    @Basic(optional = false)
    @Column(name = "calx")
    private float calx;
    @Basic(optional = false)
    @Column(name = "caly")
    private float caly;

    /**
     *
     */
    public Dadosdap() {
    }

    /**
     *
     * @param iddap
     */
    public Dadosdap(Integer iddap) {
        this.iddap = iddap;
    }

    /**
     *
     * @param iddap
     * @param altura
     * @param diametro
     * @param calg
     * @param calx
     * @param caly
     */
    public Dadosdap(Integer iddap, float altura, float diametro, float calg, float calx, float caly) {
        this.iddap = iddap;
        this.altura = altura;
        this.diametro = diametro;
        this.calg = calg;
        this.calx = calx;
        this.caly = caly;
    }

    /**
     *
     * @return
     */
    public Integer getIddap() {
        return iddap;
    }

    /**
     *
     * @param iddap
     */
    public void setIddap(Integer iddap) {
        Integer oldIddap = this.iddap;
        this.iddap = iddap;
        changeSupport.firePropertyChange("iddap", oldIddap, iddap);
    }

    /**
     *
     * @return
     */
    public float getAltura() {
        return altura;
    }

    /**
     *
     * @param altura
     */
    public void setAltura(float altura) {
        float oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }

    /**
     *
     * @return
     */
    public float getDiametro() {
        return diametro;
    }

    /**
     *
     * @param diametro
     */
    public void setDiametro(float diametro) {
        float oldDiametro = this.diametro;
        this.diametro = diametro;
        changeSupport.firePropertyChange("diametro", oldDiametro, diametro);
    }

    /**
     *
     * @return
     */
    public float getCalg() {
        return calg;
    }

    /**
     *
     * @param calg
     */
    public void setCalg(float calg) {
        float oldCalg = this.calg;
        this.calg = calg;
        changeSupport.firePropertyChange("calg", oldCalg, calg);
    }

    /**
     *
     * @return
     */
    public float getCalx() {
        return calx;
    }

    /**
     *
     * @param calx
     */
    public void setCalx(float calx) {
        float oldCalx = this.calx;
        this.calx = calx;
        changeSupport.firePropertyChange("calx", oldCalx, calx);
    }

    /**
     *
     * @return
     */
    public float getCaly() {
        return caly;
    }

    /**
     *
     * @param caly
     */
    public void setCaly(float caly) {
        float oldCaly = this.caly;
        this.caly = caly;
        changeSupport.firePropertyChange("caly", oldCaly, caly);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddap != null ? iddap.hashCode() : 0);
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
        if (!(object instanceof Dadosdap)) {
            return false;
        }
        Dadosdap other = (Dadosdap) object;
        return (this.iddap != null || other.iddap == null) && (this.iddap == null || this.iddap.equals(other.iddap));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "br.com.swinghibernate.view.Dadosdap[ iddap=" + iddap + " ]";
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
    private static final Logger LOG = Logger.getLogger(Dadosdap.class.getName());
    
}
