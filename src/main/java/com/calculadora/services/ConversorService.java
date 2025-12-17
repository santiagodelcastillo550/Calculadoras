package com.calculadora.services;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {

	// Temperatura 
	public double celsiusToFahrenheit(double c) { return c * 9/5 + 32; } 
	public double fahrenheitToCelsius(double f) { return (f - 32) * 5/9; } 
	public double celsiusToKelvin(double c) { return c + 273.15; } 
	public double kelvinToCelsius(double k) { return k - 273.15; } 
	
	// Longitud 
	public double mmToCm(double mm) { return mm / 10; } 
	public double cmToM(double cm) { return cm / 100; } 
	public double mToKm(double m) { return m / 1000; } 
	
	// Peso 
	public double gToKg(double g) { return g / 1000; } 
	public double kgToLb(double kg) { return kg * 2.20462; } 
	public double lbToKg(double lb) { return lb / 2.20462; } 
	
	// Tiempo 
	public double minToHoras(double min) { return min / 60; } 
	public double horasToDias(double h) { return h / 24; } 
	
	// Moneda (tasas fijas configuradas manualmente) 
	private final double tasaUsdEur = 0.9; // ejemplo 
	public double usdToEur(double usd) { return usd * tasaUsdEur; } 
	public double eurToUsd(double eur) { return eur / tasaUsdEur; }
}
