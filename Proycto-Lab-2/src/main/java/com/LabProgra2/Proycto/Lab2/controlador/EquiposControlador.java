/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.controlador;

import com.LabProgra2.Proycto.Lab2.dao.EquiporovDAO;
import com.LabProgra2.Proycto.Lab2.modelo.Equiporov;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rodrigo Yiyo
 */
@Controller
public class EquiposControlador {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)

    @Autowired
    private EquiporovDAO equiDAO;
    

    @GetMapping("/inicio/equipos")
    public String mostrarequipo(Model model) {

        List<Equiporov> lista = equiDAO.findAll();

        model.addAttribute("listaEquipos", lista);

        return "equipos";
    }

    @GetMapping("/inicio/equipos/regequipo")
    public String mostrarRegequipo(Model model) {

        model.addAttribute("nuevoEquipo", new Equiporov());

        return "regequipo";
    }

    @PostMapping("/inicio/equipos/regequipo")
    public String crearEquipo(@ModelAttribute Equiporov eq) {

        equiDAO.save(eq);

        return "redirect:/inicio";
    }

}
