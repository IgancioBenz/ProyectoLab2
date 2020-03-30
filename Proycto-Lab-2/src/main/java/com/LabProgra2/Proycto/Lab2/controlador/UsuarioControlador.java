/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabProgra2.Proycto.Lab2.controlador;

import com.LabProgra2.Proycto.Lab2.dao.UsuarioDAO;
import com.LabProgra2.Proycto.Lab2.modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Rodrigo Yiyo
 */
@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioDAO uDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)

    @GetMapping("/")
    public String mostrarPrincipal(Model model) {

        return "principal";
    }

    @GetMapping("/inicio/registro")
    public String mostrarRegistro(Model model) {

        model.addAttribute("nuevoUsuario", new Usuario());

        return "registro";
    }

    @PostMapping("/inicio/registro")
    @Transactional
    public String crearUsuario(@ModelAttribute Usuario u) {

        u.setContrasena(u.getRut());
        u.setContrato("Indefinido");
        uDAO.save(u);

        return "redirect:/inicio";
    }

    @GetMapping("/inicio/buscareliminar")
    public String mostrarEdicion(Model model, @RequestParam(required = false) String rut) {

        if (rut != null) {
            Usuario usuarioBD = uDAO.findByRut(rut);
        
            if (usuarioBD!=null) {
                model.addAttribute("usuariox", usuarioBD);
            }else{
                model.addAttribute("error", true);
                model.addAttribute("usuariox", new Usuario());
            }
        }else {

            model.addAttribute("usuariox", new Usuario());
            
        }

        model.addAttribute("usuarioGet", new Usuario());

        return "buscareliminar";
    }

    @PostMapping("/inicio/buscareliminar")
    public String edicion(Model model, @ModelAttribute Usuario u, HttpServletRequest request) { //funcion para editar

        Usuario usuarioBD = uDAO.findByRut(u.getRut());
        model.addAttribute("usuarioGet", new Usuario());

        if (usuarioBD != null) {

            u.setContrasena(u.getRut());
            u.setContrato("Indefinido");
            uDAO.save(u);
            model.addAttribute("usuariox", new Usuario());
            model.addAttribute("succes", true);
            return "buscareliminar";
            

        } else {

            model.addAttribute("usuariox", new Usuario());
            model.addAttribute("error", true);
            return "buscareliminar";
        }

    }
    
    @PostMapping("/borrarUsuario")
    public String borrar(Model model, @ModelAttribute Usuario u, HttpServletRequest request) { //funcion para borrar

        Usuario usuarioBD = uDAO.findByRut(u.getRut());
        model.addAttribute("usuarioGet", new Usuario());

        if (usuarioBD != null) {

            /*u.setContrasena(u.getRut());
            u.setContrato("Indefinido");*/
            uDAO.delete(u);
            model.addAttribute("usuariox", new Usuario());
            model.addAttribute("succesDelete", true);
            return "buscareliminar";

        } else {

            model.addAttribute("usuariox", new Usuario());
            model.addAttribute("errorDelete", true);
            return "buscareliminar";
        }

    }

}
