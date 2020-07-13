package br.univille.iglycemic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.iglycemic.model.Alimento;
import br.univille.iglycemic.service.AlimentoService;


@Controller
@RequestMapping("/alimento")
public class AlimentoController {
    
    @Autowired
    private AlimentoService service;
    
    @GetMapping("")
    public ModelAndView index(){
        List<Alimento> listaAlimento = service.getAll();
        return new ModelAndView("alimento/index","listaalimento",listaAlimento);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Alimento alimento) {
        return new ModelAndView("alimento/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Alimento alimento){
        service.save(alimento);
        return new ModelAndView("redirect:/alimento");
    }

    @GetMapping(value="/alterar/{id}")
    public ModelAndView edit(@PathVariable("id") Alimento alimento){
        return new ModelAndView("alimento/form","alimento",alimento);
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Alimento alimento){
        service.delete(alimento);
        return new ModelAndView("redirect:/alimento");
    }
    
}
