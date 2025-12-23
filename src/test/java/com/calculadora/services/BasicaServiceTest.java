package com.calculadora.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicaServiceTest {

	private BasicaService service; 
	
	@BeforeEach 
	void setUp() { 
		service = new BasicaService(); 
	} 
	
	@Test 
	void testAgregarValor() { 
		assertEquals("12", service.agregarValor("1", "2")); 
		assertEquals("1.", service.agregarValor("1", ".")); 
	} 
	
	@Test 
	void testAgregarOperador() { 
		assertEquals("1+", service.agregarOperador("1", "+")); 
		assertEquals("5*", service.agregarOperador("5", "*")); 
	} 
	
	@Test 
	void testCalcular() { 
		assertEquals("7.0", service.calcular("3+4")); 
		assertEquals("6.0", service.calcular("2*3")); 
		assertEquals("2.0", service.calcular("10/5")); 
	} 
	
	@Test 
	void testCalcularError() { 
		assertEquals("Error", service.calcular("3+")); 
		assertEquals("Error", service.calcular("abc")); 
	}
}
