/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "AREACINCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areacinco.findAll", query = "SELECT a FROM Areacinco a")
    , @NamedQuery(name = "Areacinco.findByIdArea", query = "SELECT a FROM Areacinco a WHERE a.idArea = :idArea")
    , @NamedQuery(name = "Areacinco.findByNombreArea", query = "SELECT a FROM Areacinco a WHERE a.nombreArea = :nombreArea")})
public class Areacinco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_areaCinco")
    @SequenceGenerator(name = "secuencia_areaCinco", sequenceName = "secuencia_areaCinco", allocationSize = 1)
    @Column(name = "ID_AREA")
    private BigDecimal idArea;
 
    
    @Column(name = "NOMBRE_AREA")
    private String nombreArea;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private Collection<Empleadocinco> empleadocincoCollection;

    public Areacinco() {
    }

    public Areacinco(BigDecimal idArea) {
        this.idArea = idArea;
    }

    public Areacinco(BigDecimal idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }

    public BigDecimal getIdArea() {
        return idArea;
    }

    public void setIdArea(BigDecimal idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @XmlTransient
    public Collection<Empleadocinco> getEmpleadocincoCollection() {
        return empleadocincoCollection;
    }

    public void setEmpleadocincoCollection(Collection<Empleadocinco> empleadocincoCollection) {
        this.empleadocincoCollection = empleadocincoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areacinco)) {
            return false;
        }
        Areacinco other = (Areacinco) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Areacinco[ idArea=" + idArea + " ]";
    }
    
}
