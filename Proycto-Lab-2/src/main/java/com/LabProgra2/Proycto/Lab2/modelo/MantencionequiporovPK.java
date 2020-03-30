/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodrigo Yiyo
 */
@Embeddable
public class MantencionequiporovPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EquipoRovidEquipoRov")
    private int equipoRovidEquipoRov;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioIdUsuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "UsuarioRut")
    private String usuarioRut;

    public MantencionequiporovPK() {
    }

    public MantencionequiporovPK(int equipoRovidEquipoRov, int usuarioIdUsuario, String usuarioRut) {
        this.equipoRovidEquipoRov = equipoRovidEquipoRov;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.usuarioRut = usuarioRut;
    }

    public int getEquipoRovidEquipoRov() {
        return equipoRovidEquipoRov;
    }

    public void setEquipoRovidEquipoRov(int equipoRovidEquipoRov) {
        this.equipoRovidEquipoRov = equipoRovidEquipoRov;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public String getUsuarioRut() {
        return usuarioRut;
    }

    public void setUsuarioRut(String usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) equipoRovidEquipoRov;
        hash += (int) usuarioIdUsuario;
        hash += (usuarioRut != null ? usuarioRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantencionequiporovPK)) {
            return false;
        }
        MantencionequiporovPK other = (MantencionequiporovPK) object;
        if (this.equipoRovidEquipoRov != other.equipoRovidEquipoRov) {
            return false;
        }
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if ((this.usuarioRut == null && other.usuarioRut != null) || (this.usuarioRut != null && !this.usuarioRut.equals(other.usuarioRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.LabProgra2.ProyectoLab2Logic.modelo.MantencionequiporovPK[ equipoRovidEquipoRov=" + equipoRovidEquipoRov + ", usuarioIdUsuario=" + usuarioIdUsuario + ", usuarioRut=" + usuarioRut + " ]";
    }
    
}
