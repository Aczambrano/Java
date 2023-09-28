/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "EMPLEADOCINCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleadocinco.findAll", query = "SELECT e FROM Empleadocinco e")
    , @NamedQuery(name = "Empleadocinco.findByIdEmpleado", query = "SELECT e FROM Empleadocinco e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleadocinco.findByNombreEmpleado", query = "SELECT e FROM Empleadocinco e WHERE e.nombreEmpleado = :nombreEmpleado")
    , @NamedQuery(name = "Empleadocinco.findByApellidoEmpleado", query = "SELECT e FROM Empleadocinco e WHERE e.apellidoEmpleado = :apellidoEmpleado")})
public class Empleadocinco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_empleadoCinco")
    @SequenceGenerator(name = "secuencia_empleadoCinco", sequenceName = "secuencia_empleadoCinco", allocationSize = 1)
    @Column(name = "ID_EMPLEADO")
    private BigDecimal idEmpleado;
    
    @Column(name = "NOMBRE_EMPLEADO")
    private String nombreEmpleado;
    
    @Column(name = "APELLIDO_EMPLEADO")
    private String apellidoEmpleado;
    
    @JoinColumn(name = "ID_AREA", referencedColumnName = "ID_AREA")
    @ManyToOne(optional = false)
    private Areacinco idArea;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargocinco idCargo;
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private Documentocinco idDocumento;

    public Empleadocinco() {
    }

    public Empleadocinco(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleadocinco(BigDecimal idEmpleado, String nombreEmpleado, String apellidoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public BigDecimal getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public Areacinco getIdArea() {
        return idArea;
    }

    public void setIdArea(Areacinco idArea) {
        this.idArea = idArea;
    }

    public Cargocinco getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargocinco idCargo) {
        this.idCargo = idCargo;
    }

    public Documentocinco getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documentocinco idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadocinco)) {
            return false;
        }
        Empleadocinco other = (Empleadocinco) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Empleadocinco[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
