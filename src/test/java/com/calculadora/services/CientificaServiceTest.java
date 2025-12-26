package com.calculadora.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CientificaServiceTest {

    private CientificaService service;

    @BeforeEach
    void setUp() {
        service = new CientificaService();
    }

    @Test
    void testAgregarValor() {
        assertEquals("12", service.agregarValor("1", "2"));
        assertEquals("1+", service.agregarValor("1", "+"));
    }

    @Test
    void testCalcularSuma() {
        assertEquals("7.0", service.calcular("3+4"));
    }

    @Test
    void testCalcularTrigonometria() {
        assertEquals(String.valueOf(Math.sin(1)), service.calcular("sin(1)"));
    }

    @Test
    void testCalcularFactorial() {
        assertEquals("120.0", service.calcular("fact(5)"));
    }

    @Test
    void testCalcularRoot() {
        // root(3, 27) = 3
        assertEquals("3.0", service.calcular("root(3,27)"));
    }

    @Test
    void testCalcularConConstantes() {
        assertEquals(String.valueOf(Math.PI + Math.E), service.calcular("pi+e"));
    }

    @Test
    void testCalcularError() {
        assertEquals("Error", service.calcular("5+"));
        assertEquals("Error", service.calcular("fact()"));
        assertEquals("Error", service.calcular("root(2)"));
    }
}
