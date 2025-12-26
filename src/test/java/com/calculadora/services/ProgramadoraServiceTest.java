package com.calculadora.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgramadoraServiceTest {

    private ProgramadoraService service;

    @BeforeEach
    void setUp() {
        service = new ProgramadoraService();
    }

    // Conversiones a otras bases
    @Test
    void testToBinary() {
        assertEquals("1010", service.toBinary(10));
        assertEquals("0", service.toBinary(0));
    }

    @Test
    void testToHex() {
        assertEquals("A", service.toHex(10));
        assertEquals("FF", service.toHex(255));
    }

    @Test
    void testToOctal() {
        assertEquals("12", service.toOctal(10));
        assertEquals("377", service.toOctal(255));
    }

    // Conversiones desde otras bases
    @Test
    void testFromBinary() {
        assertEquals(10, service.fromBinary("1010"));
        assertEquals(255, service.fromBinary("11111111"));
    }

    @Test
    void testFromHex() {
        assertEquals(10, service.fromHex("A"));
        assertEquals(255, service.fromHex("FF"));
    }

    @Test
    void testFromOctal() {
        assertEquals(10, service.fromOctal("12"));
        assertEquals(255, service.fromOctal("377"));
    }

    @Test
    void testInvalidBinary() {
        assertThrows(NumberFormatException.class, () -> service.fromBinary("10201"));
    }

    @Test
    void testInvalidHex() {
        assertThrows(NumberFormatException.class, () -> service.fromHex("GHI"));
    }

    @Test
    void testInvalidOctal() {
        assertThrows(NumberFormatException.class, () -> service.fromOctal("89"));
    }
}
