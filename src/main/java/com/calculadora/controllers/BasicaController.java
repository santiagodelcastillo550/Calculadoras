package com.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculadora.services.BasicaService;

@Controller
public class BasicaController {

	private final BasicaService basicaService;

    public BasicaController(BasicaService basicaService) {
        this.basicaService = basicaService;
    }

    @GetMapping("/calculadora/basica")
    public String mostrar(Model model) {
        model.addAttribute("display", "");
        model.addAttribute("operando1", "");
        model.addAttribute("operador", "");
        return "calculadora/basica";
    }

    @PostMapping("/calculadora/basica/input")
    public String input(@RequestParam String valor,
                        @RequestParam String display,
                        @RequestParam String operando1,
                        @RequestParam String operador,
                        Model model) {

        model.addAttribute("display", basicaService.agregarValor(display, valor));
        model.addAttribute("operando1", operando1);
        model.addAttribute("operador", operador);
        return "calculadora/basica";
    }

    @PostMapping("/calculadora/basica/op")
    public String op(@RequestParam String op,
                     @RequestParam String display,
                     Model model) {

        model.addAttribute("operando1", display);
        model.addAttribute("operador", op);
        model.addAttribute("display", basicaService.agregarOperador(display, op));
        return "calculadora/basica";
    }

    @PostMapping("/calculadora/basica/igual")
    public String igual(@RequestParam String display, Model model) {
        model.addAttribute("display", basicaService.calcular(display));
        model.addAttribute("operando1", "");
        model.addAttribute("operador", "");
        return "calculadora/basica";
    }


    @PostMapping("/calculadora/basica/clear")
    public String clear(Model model) {
        model.addAttribute("display", "");
        model.addAttribute("operando1", "");
        model.addAttribute("operador", "");
        return "calculadora/basica";
    }
}
