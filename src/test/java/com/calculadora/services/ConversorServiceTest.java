package com.calculadora.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConversorServiceTest {

    private ConversorService service;

    @BeforeEach
    void setUp() {
        service = new ConversorService();
    }

    // Temperatura
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, service.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, service.celsiusToFahrenheit(100), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, service.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, service.fahrenheitToCelsius(212), 0.001);
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, service.celsiusToKelvin(0), 0.001);
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(0, service.kelvinToCelsius(273.15), 0.001);
    }

    // Longitud
    @Test
    void testCmToM() {
        assertEquals(1, service.cmToM(100), 0.001);
    }

    @Test
    void testMmToCm() {
        assertEquals(10, service.mmToCm(100), 0.001);
    }

    @Test
    void testMToKm() {
        assertEquals(2.5, service.mToKm(2500), 0.001);
    }

    // Peso
    @Test
    void testKgToLb() {
        assertEquals(2.20462, service.kgToLb(1), 0.001);
    }

    @Test
    void testLbToKg() {
        assertEquals(1, service.lbToKg(2.20462), 0.001);
    }

    // Tiempo
    @Test
    void testMinToHoras() {
        assertEquals(1, service.minToHoras(60), 0.001);
    }

    @Test
    void testHorasToDias() {
        assertEquals(1, service.horasToDias(24), 0.001);
    }

    // Moneda
    @Test
    void testUsdToEur() {
        assertEquals(90, service.usdToEur(100), 0.001);
    }

    @Test
    void testEurToUsd() {
        assertEquals(100, service.eurToUsd(90), 0.001);
    }
}
