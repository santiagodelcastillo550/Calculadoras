package com.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculadora.services.CientificaService;

@Controller
public class CientificaController {

	private final CientificaService cientificaService;

    public CientificaController(CientificaService cientificaService) {
        this.cientificaService = cientificaService;
    }

    @GetMapping("/calculadora/cientifica")
    public String mostrar(Model model) {
        model.addAttribute("display", "");
        return "calculadora/cientifica";
    }

    @PostMapping("/calculadora/cientifica/input")
    public String input(@RequestParam String valor,
                        @RequestParam String display,
                        Model model) {

        model.addAttribute("display", cientificaService.agregarValor(display, valor));
        return "calculadora/cientifica";
    }

    @PostMapping("/calculadora/cientifica/igual")
    public String igual(@RequestParam String display, Model model) {
        model.addAttribute("display", cientificaService.calcular(display));
        return "calculadora/cientifica";
    }

    @PostMapping("/calculadora/cientifica/clear")
    public String clear(Model model) {
        model.addAttribute("display", "");
        return "calculadora/cientifica";
    }
}
