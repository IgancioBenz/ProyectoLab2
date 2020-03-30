/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodrigo Yiyo
 */
@Entity
@Table(name = "mantencionequiporov")
@NamedQueries({
    @NamedQuery(name = "Mantencionequiporov.findAll", query = "SELECT m FROM Mantencionequiporov m")})
public class Mantencionequiporov implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MantencionequiporovPK mantencionequiporovPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaMantencion")
    @Temporal(TemporalType.DATE)
    private Date fechaMantencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detalleMantencion")
    private String detalleMantencion;
    @JoinColumn(name = "UsuarioRut", referencedColumnName = "Rut", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumn(name = "EquipoRovidEquipoRov", referencedColumnName = "idEquipoRov", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equiporov equiporov;

    public Mantencionequiporov() {
    }

    public Mantencionequiporov(MantencionequiporovPK mantencionequiporovPK) {
        this.mantencionequiporovPK = mantencionequiporovPK;
    }

    public Mantencionequiporov(MantencionequiporovPK mantencionequiporovPK, Date fechaMantencion, String detalleMantencion) {
        this.mantencionequiporovPK = mantencionequiporovPK;
        this.fechaMantencion = fechaMantencion;
        this.detalleMantencion = detalleMantencion;
    }

    public Mantencionequiporov(int equipoRovidEquipoRov, int usuarioIdUsuario, String usuarioRut) {
        this.mantencionequiporovPK = new MantencionequiporovPK(equipoRovidEquipoRov, usuarioIdUsuario, usuarioRut);
    }

    public MantencionequiporovPK getMantencionequiporovPK() {
        return mantencionequiporovPK;
    }

    public void setMantencionequiporovPK(MantencionequiporovPK mantencionequiporovPK) {
        this.mantencionequiporovPK = mantencionequiporovPK;
    }

    public Date getFechaMantencion() {
        return fechaMantencion;
    }

    public void setFechaMantencion(Date fechaMantencion) {
        this.fechaMantencion = fechaMantencion;
    }

    public String getDetalleMantencion() {
        return detalleMantencion;
    }

    public void setDetalleMantencion(String detalleMantencion) {
        this.detalleMantencion = detalleMantencion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equiporov getEquiporov() {
        return equiporov;
    }

    public void setEquiporov(Equiporov equiporov) {
        this.equiporov = equiporov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mantencionequiporovPK != null ? mantencionequiporovPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantencionequiporov)) {
            return false;
        }
        Mantencionequiporov other = (Mantencionequiporov) object;
        if ((this.mantencionequiporovPK == null && other.mantencionequiporovPK != null) || (this.mantencionequiporovPK != null && !this.mantencionequiporovPK.equals(other.mantencionequiporovPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.LabProgra2.ProyectoLab2Logic.modelo.Mantencionequiporov[ mantencionequiporovPK=" + mantencionequiporovPK + " ]";
    }
    
}
