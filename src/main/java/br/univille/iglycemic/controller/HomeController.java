package br.univille.iglycemic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.univille.iglycemic.service.impl.MyUserDetailsService;

@Controller
@RequestMapping({"/home", ""})
public class HomeController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping({ "/index", ""})
    public ModelAndView index(){
        String header = "Seja bem-vindo " + myUserDetailsService.getUserLogged().getNome();
        return new ModelAndView("home/index","titulo",header);
    }
    @GetMapping("/contato")
    @ResponseBody
    public String contato(){
        return "chris.miranda";
    }
}