package com.calculadora.services;

import org.springframework.stereotype.Service;

@Service
public class ProgramadoraService {

	public String toBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public String toHex(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    public String toOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public int fromBinary(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public int fromHex(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public int fromOctal(String oct) {
        return Integer.parseInt(oct, 8);
    }
}
