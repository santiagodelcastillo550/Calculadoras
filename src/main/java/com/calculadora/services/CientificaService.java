package com.calculadora.services;

import org.springframework.stereotype.Service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

@Service
public class CientificaService {

	public String agregarValor(String display, String valor) {
        return display + valor;
    }

	public String calcular(String display) {
	    try {
	        // Función factorial
	        Function factorial = new Function("fact", 1) {
	            @Override
	            public double apply(double... args) {
	                int n = (int) args[0];
	                double result = 1;
	                for (int i = 2; i <= n; i++) {
	                    result *= i;
	                }
	                return result;
	            }
	        };

	        // Función raíz n-ésima
	        Function root = new Function("root", 2) {
	            @Override
	            public double apply(double... args) {
	                return Math.pow(args[1], 1.0 / args[0]);
	            }
	        };

	        // Construimos la expresión
	        Expression expression = new ExpressionBuilder(display)
	                // exp4j ya soporta sin, cos, tan, log, ln, sqrt, potencias (^)
	                .functions(factorial, root)
	                .variables("pi", "e")
	                .build()
	                .setVariable("pi", Math.PI)
	                .setVariable("e", Math.E);

	        double result = expression.evaluate();
	        return String.valueOf(result);
	    } catch (Exception e) {
	        return "Error";
	    }
	}

}
