package com.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculadora.services.ConversorService;

@Controller
public class ConversorController {

	private final ConversorService conversorService; 
	public ConversorController(ConversorService conversorService){ 
		this.conversorService = conversorService; } 
	
	@GetMapping("/calculadora/conversores") 
	public String mostrar(Model model){ 
		model.addAttribute("categoria", "temperatura"); 
		model.addAttribute("entrada", ""); 
		model.addAttribute("salida", ""); 
		model.addAttribute("descripcion", "");
		return "calculadora/conversores"; 
	} 
	@PostMapping("/calculadora/conversores/convert") 
	public String convertir(@RequestParam String categoria, @RequestParam double entrada, Model model){ 
		double salida = 0; 
		String descripcion = "";
		switch (categoria){ 
			case "temperatura": 
				salida = conversorService.celsiusToFahrenheit(entrada); 
				descripcion = "Convirtiendo de Celsius a Fahrenheit";
				break; 
			case "longitud": 
				salida = conversorService.cmToM(entrada); 
				descripcion = "Convirtiendo de centímetros a metros";
				break; 
			case "peso": 
				salida = conversorService.kgToLb(entrada); 
				descripcion = "Convirtiendo de kilogramos a libras";
				break; 
			case "tiempo": 
				salida = conversorService.minToHoras(entrada); 
				descripcion = "Convirtiendo de minutos a horas";
				break; 
			case "moneda": 
				salida = conversorService.usdToEur(entrada); 
				descripcion = "Convirtiendo de USD a EUR";
				break; 
		} 
		model.addAttribute("categoria", categoria); 
		model.addAttribute("entrada", entrada); 
		model.addAttribute("salida", salida); 
		model.addAttribute("descripcion", descripcion);

		return "calculadora/conversores"; 
	}
}
