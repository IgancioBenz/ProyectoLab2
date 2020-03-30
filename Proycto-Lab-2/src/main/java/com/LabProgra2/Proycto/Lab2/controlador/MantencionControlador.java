/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.controlador;

import com.LabProgra2.Proycto.Lab2.dao.MantencionEquiporovDAO;
import com.LabProgra2.Proycto.Lab2.modelo.Mantencionequiporov;
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
public class MantencionControlador {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)

    @Autowired
    private MantencionEquiporovDAO manDAO;

    @GetMapping("/inicio/mantenciones")
    public String mostrarMantencion(Model model) {

        List<Mantencionequiporov> lista = manDAO.findAll();

        model.addAttribute("listaMantenciones", lista);

        return "mantenciones";
    }


}
