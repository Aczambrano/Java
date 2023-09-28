/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
@Table(name = "DOCUMENTOCINCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentocinco.findAll", query = "SELECT d FROM Documentocinco d")
    , @NamedQuery(name = "Documentocinco.findByIdDocumento", query = "SELECT d FROM Documentocinco d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documentocinco.findByNombreDocumento", query = "SELECT d FROM Documentocinco d WHERE d.nombreDocumento = :nombreDocumento")})
public class Documentocinco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_documentoCinco")
    @SequenceGenerator(name = "secuencia_documentoCinco", sequenceName = "secuencia_documentoCinco", allocationSize = 1)
    @Column(name = "ID_DOCUMENTO")
    private BigDecimal idDocumento;

    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private Collection<Empleadocinco> empleadocincoCollection;

    public Documentocinco() {
    }

    public Documentocinco(BigDecimal idDocumento) {
        this.idDocumento = idDocumento;
    }

    public BigDecimal getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(BigDecimal idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentocinco)) {
            return false;
        }
        Documentocinco other = (Documentocinco) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Documentocinco[ idDocumento=" + idDocumento + " ]";
    }
    
}
