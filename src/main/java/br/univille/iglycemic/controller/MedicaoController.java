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

import br.univille.iglycemic.model.Medicao;
import br.univille.iglycemic.model.Usuario;
import br.univille.iglycemic.service.MedicaoService;


@Controller
@RequestMapping("/medicao")
public class MedicaoController {
    
    @Autowired
    private MedicaoService service;
    
    @GetMapping("")
    public ModelAndView index(){
        List<Medicao> listaMedicao = service.getAll();
        return new ModelAndView("medicao/index","listamedicao",listaMedicao);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Medicao medicao) {
        return new ModelAndView("medicao/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Medicao medicao){
        Usuario usuario = medicao.getUsuario();
        medicao.setTotalInsu((medicao.getGlicemia() - usuario.getAlvoGlic())/usuario.getFatorSens());
        service.save(medicao);
        return new ModelAndView("redirect:/medicao");
    }

    @GetMapping(value="/alterar/{id}")
    public ModelAndView edit(@PathVariable("id") Medicao medicao){
        return new ModelAndView("medicao/form","medicao",medicao);
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Medicao medicao){
        service.delete(medicao);
        return new ModelAndView("redirect:/medicao");
    }
    
}
