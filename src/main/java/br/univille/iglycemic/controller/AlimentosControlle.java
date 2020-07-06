package br.univille.iglycemic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.iglycemic.model.Alimentos;
import br.univille.iglycemic.service.AlimentosService;

@Controller
@RequestMapping("/alimentos")
public class AlimentosControlle {
    
    @Autowired
    private AlimentosService service;
    
    @GetMapping("")
    public ModelAndView index(){
        List<Alimentos> listaAlimentos = service.getAll();
        return new ModelAndView("alimentos/index","listaalimentos",listaAlimentos);
    }
}
