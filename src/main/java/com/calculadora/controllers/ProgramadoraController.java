package com.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculadora.services.ProgramadoraService;

@Controller
public class ProgramadoraController {

	private final ProgramadoraService programadoraService;

    public ProgramadoraController(ProgramadoraService programadoraService) {
        this.programadoraService = programadoraService;
    }

    @GetMapping("/calculadora/programadora")
    public String mostrar(Model model) {
        model.addAttribute("decimal", "");
        model.addAttribute("binario", "");
        model.addAttribute("hexadecimal", "");
        model.addAttribute("octal", "");
        return "calculadora/programadora";
    }

    @PostMapping("/calculadora/programadora/convert")
    public String convertir(@RequestParam String tipo,
                            @RequestParam String valor,
                            Model model) {
        try {
            int decimal = 0;
            switch (tipo) {
                case "decimal":
                    decimal = Integer.parseInt(valor);
                    break;
                case "binario":
                    decimal = programadoraService.fromBinary(valor);
                    break;
                case "hexadecimal":
                    decimal = programadoraService.fromHex(valor);
                    break;
                case "octal":
                    decimal = programadoraService.fromOctal(valor);
                    break;
            }

            model.addAttribute("decimal", decimal);
            model.addAttribute("binario", programadoraService.toBinary(decimal));
            model.addAttribute("hexadecimal", programadoraService.toHex(decimal));
            model.addAttribute("octal", programadoraService.toOctal(decimal));
        } catch (Exception e) {
            model.addAttribute("decimal", "Error");
            model.addAttribute("binario", "Error");
            model.addAttribute("hexadecimal", "Error");
            model.addAttribute("octal", "Error");
        }
        return "calculadora/programadora";
    }
}
