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
@Table(name = "CARGOCINCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargocinco.findAll", query = "SELECT c FROM Cargocinco c")
    , @NamedQuery(name = "Cargocinco.findByIdCargo", query = "SELECT c FROM Cargocinco c WHERE c.idCargo = :idCargo")
    , @NamedQuery(name = "Cargocinco.findByNombreCargo", query = "SELECT c FROM Cargocinco c WHERE c.nombreCargo = :nombreCargo")})
public class Cargocinco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_cargoCinco")
    @SequenceGenerator(name = "secuencia_cargoCinco", sequenceName = "secuencia_cargoCinco", allocationSize = 1)
    @Column(name = "ID_CARGO")
    private BigDecimal idCargo;
    
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private Collection<Empleadocinco> empleadocincoCollection;

    public Cargocinco() {
    }

    public Cargocinco(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public Cargocinco(BigDecimal idCargo, String nombreCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }

    public BigDecimal getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
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
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargocinco)) {
            return false;
        }
        Cargocinco other = (Cargocinco) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cargocinco[ idCargo=" + idCargo + " ]";
    }
    
}
