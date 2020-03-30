/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodrigo Yiyo
 */
@Entity
@Table(name = "mensaje")
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMensaje")
    private Integer idMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdRecceptor")
    private int idRecceptor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Cuerpo")
    private String cuerpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioIdUsuario")
    private int usuarioIdUsuario;
    @JoinColumn(name = "UsuarioRut", referencedColumnName = "Rut")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioRut;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Mensaje(Integer idMensaje, int idRecceptor, String cuerpo, int usuarioIdUsuario) {
        this.idMensaje = idMensaje;
        this.idRecceptor = idRecceptor;
        this.cuerpo = cuerpo;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdRecceptor() {
        return idRecceptor;
    }

    public void setIdRecceptor(int idRecceptor) {
        this.idRecceptor = idRecceptor;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Usuario getUsuarioRut() {
        return usuarioRut;
    }

    public void setUsuarioRut(Usuario usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.LabProgra2.ProyectoLab2Logic.modelo.Mensaje[ idMensaje=" + idMensaje + " ]";
    }
    
}
