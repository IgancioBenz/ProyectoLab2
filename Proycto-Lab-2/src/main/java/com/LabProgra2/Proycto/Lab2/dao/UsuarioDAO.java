/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.dao;

import com.LabProgra2.Proycto.Lab2.modelo.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rodrigo Yiyo
 */
public interface UsuarioDAO extends CrudRepository<Usuario, String> {
    
        @Override
    public List<Usuario> findAll();
    
    public Usuario findByRutAndContrasena (String user, String pass);
    public Usuario findByRut (String rut);
    
}
