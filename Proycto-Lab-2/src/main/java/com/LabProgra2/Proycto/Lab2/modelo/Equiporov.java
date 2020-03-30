/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "equiporov")
@NamedQueries({
    @NamedQuery(name = "Equiporov.findAll", query = "SELECT e FROM Equiporov e")})
public class Equiporov implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipoRov")
    private Integer idEquipoRov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AnoIngreso")
    @Temporal(TemporalType.DATE)
    private Date anoIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equiporov", fetch = FetchType.LAZY)
    private List<Mantencionequiporov> mantencionequiporovList;

    public Equiporov() {
    }

    public Equiporov(Integer idEquipoRov) {
        this.idEquipoRov = idEquipoRov;
    }

    public Equiporov(Integer idEquipoRov, String tipo, Date anoIngreso, String estado) {
        this.idEquipoRov = idEquipoRov;
        this.tipo = tipo;
        this.anoIngreso = anoIngreso;
        this.estado = estado;
    }

    public Integer getIdEquipoRov() {
        return idEquipoRov;
    }

    public void setIdEquipoRov(Integer idEquipoRov) {
        this.idEquipoRov = idEquipoRov;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(Date anoIngreso) {
        this.anoIngreso = anoIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Mantencionequiporov> getMantencionequiporovList() {
        return mantencionequiporovList;
    }

    public void setMantencionequiporovList(List<Mantencionequiporov> mantencionequiporovList) {
        this.mantencionequiporovList = mantencionequiporovList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoRov != null ? idEquipoRov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equiporov)) {
            return false;
        }
        Equiporov other = (Equiporov) object;
        if ((this.idEquipoRov == null && other.idEquipoRov != null) || (this.idEquipoRov != null && !this.idEquipoRov.equals(other.idEquipoRov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.LabProgra2.ProyectoLab2Logic.modelo.Equiporov[ idEquipoRov=" + idEquipoRov + " ]";
    }
    
}
