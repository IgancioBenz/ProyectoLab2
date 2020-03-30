/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.controlador;

import com.LabProgra2.Proycto.Lab2.dao.UsuarioDAO;
import com.LabProgra2.Proycto.Lab2.modelo.Usuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rodrigo Yiyo
 */
@Controller
public class LoginControlador {
    
    @Autowired
    UsuarioDAO uDAO;
    
    @RequestMapping("/url")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }
    
    @GetMapping("/inicio")
    public String mostrarInicio(Model model) {

        return "inicio";
    }
    
    @GetMapping("/login")
    public String mostrarLogin(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "login";
    }
    
    @PostMapping("/login")
    public String loginn(Model model, @ModelAttribute Usuario u, HttpServletRequest request) { //funcion para el loggin

        Usuario usuarioBD = uDAO.findByRutAndContrasena(u.getRut(), u.getContrasena());

        if (usuarioBD != null) {

            request.getSession().setAttribute("usuarioLogueado", usuarioBD);
            //return "inicio";
            return "redirect:/inicio";

        } else {

            model.addAttribute("usuario", new Usuario());
            model.addAttribute("error", true);
            return "login";
        }

    }
    
}
