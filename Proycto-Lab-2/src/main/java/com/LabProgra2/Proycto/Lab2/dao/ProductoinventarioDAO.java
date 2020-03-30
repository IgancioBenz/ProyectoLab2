/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.dao;

import com.LabProgra2.Proycto.Lab2.modelo.Productoinventario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rodrigo Yiyo
 */
public interface ProductoinventarioDAO extends CrudRepository<Productoinventario, Integer> {
    
        @Override
    public List<Productoinventario> findAll();
    
}
