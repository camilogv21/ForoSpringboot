package com.example.foro.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.foro.models.Entity.Usuario;
import com.example.foro.models.Service.IUsuarioService;


@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @GetMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuario", usuarioService.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String,Object> model){
        Usuario usuario = new Usuario();

        model.put("usuario",usuario);
        model.put("titulo","Formulario del usuario");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario,BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de usuario ERROR!!!");
            return "form";
        }
        usuarioService.save(usuario);
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable Long id,Map<String,Object> model) {

        Usuario usuario = null;

        if(id > 0){
            usuario = usuarioService.findOne(id);
        }
        else{
            return "redirect:/listar";
        }

        model.put("usuario",usuario);
        model.put("titulo","Editar cliente");

        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){

        if(id > 0)
        usuarioService.delete(id);

        return "redirect:/listar";

    }
    
    
}
