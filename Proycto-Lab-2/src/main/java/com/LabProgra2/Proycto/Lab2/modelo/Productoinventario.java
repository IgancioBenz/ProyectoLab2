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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "productoinventario")
@NamedQueries({
    @NamedQuery(name = "Productoinventario.findAll", query = "SELECT p FROM Productoinventario p")})
public class Productoinventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantidadProducto")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DetalleProducto")
    private String detalleProducto;
    @Size(max = 255)
    @Column(name = "ImagenProducto")
    private String imagenProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DeptoIdDepto")
    private int deptoIdDepto;

    public Productoinventario() {
    }

    public Productoinventario(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productoinventario(Integer idProducto, String nombreProducto, int cantidadProducto, String detalleProducto, int deptoIdDepto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.detalleProducto = detalleProducto;
        this.deptoIdDepto = deptoIdDepto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getDeptoIdDepto() {
        return deptoIdDepto;
    }

    public void setDeptoIdDepto(int deptoIdDepto) {
        this.deptoIdDepto = deptoIdDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productoinventario)) {
            return false;
        }
        Productoinventario other = (Productoinventario) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.LabProgra2.ProyectoLab2Logic.modelo.Productoinventario[ idProducto=" + idProducto + " ]";
    }
    
}
