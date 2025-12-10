package com.calculadora.services;

import org.springframework.stereotype.Service;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class BasicaService {

	public String agregarValor(String display, String valor) {
        return display + valor;
    }

    public String agregarOperador(String display, String operador) {
        return display + operador;
    }

    public String calcular(String display) {
        try {
            Expression expression = new ExpressionBuilder(display).build();
            double result = expression.evaluate();
            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }
    }
}
