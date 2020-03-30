/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.controlador;

import com.LabProgra2.Proycto.Lab2.dao.ProductoinventarioDAO;
import com.LabProgra2.Proycto.Lab2.modelo.Productoinventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rodrigo Yiyo
 */
@Controller
public class InventarioControlador {
    
    @Autowired
    private ProductoinventarioDAO proDAO;
    
    @GetMapping("/inicio/inventario")
    public String mostrarinventario(Model model) {
        
        List<Productoinventario> lista = proDAO.findAll();

        model.addAttribute("listaInventario", lista);

        return "inventario";
    
}
}