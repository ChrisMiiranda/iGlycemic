package br.univille.iglycemic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.iglycemic.model.Usuario;
import br.univille.iglycemic.service.UsuarioService;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping("")
    public ModelAndView index(){
        List<Usuario> listaUsuario = service.getAll();
        return new ModelAndView("usuario/index","listausuario",listaUsuario);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Usuario usuario) {
        return new ModelAndView("usuario/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Usuario usuario){
        service.save(usuario);
        return new ModelAndView("redirect:/usuario");
    }

    @GetMapping(value="/alterar/{id}")
    public ModelAndView edit(@PathVariable("id") Usuario usuario){
        return new ModelAndView("usuario/form","usuario",usuario);
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Usuario usuario){
        service.delete(usuario);
        return new ModelAndView("redirect:/usuario");
    }
}