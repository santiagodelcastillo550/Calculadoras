package com.calculadora.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProgramadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrar() throws Exception {
        mockMvc.perform(get("/calculadora/programadora"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", ""))
                .andExpect(model().attribute("binario", ""))
                .andExpect(model().attribute("hexadecimal", ""))
                .andExpect(model().attribute("octal", ""))
                .andExpect(view().name("calculadora/programadora"));
    }

    @Test
    void testConvertirDesdeDecimal() throws Exception {
        mockMvc.perform(post("/calculadora/programadora/convert")
                        .param("tipo", "decimal")
                        .param("valor", "10"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", 10))
                .andExpect(model().attribute("binario", "1010"))
                .andExpect(model().attribute("hexadecimal", "A"))
                .andExpect(model().attribute("octal", "12"))
                .andExpect(view().name("calculadora/programadora"));
    }

    @Test
    void testConvertirDesdeBinario() throws Exception {
        mockMvc.perform(post("/calculadora/programadora/convert")
                        .param("tipo", "binario")
                        .param("valor", "1010"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", 10))
                .andExpect(model().attribute("binario", "1010"))
                .andExpect(model().attribute("hexadecimal", "A"))
                .andExpect(model().attribute("octal", "12"))
                .andExpect(view().name("calculadora/programadora"));
    }

    @Test
    void testConvertirDesdeHexadecimal() throws Exception {
        mockMvc.perform(post("/calculadora/programadora/convert")
                        .param("tipo", "hexadecimal")
                        .param("valor", "FF"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", 255))
                .andExpect(model().attribute("binario", "11111111"))
                .andExpect(model().attribute("hexadecimal", "FF"))
                .andExpect(model().attribute("octal", "377"))
                .andExpect(view().name("calculadora/programadora"));
    }

    @Test
    void testConvertirDesdeOctal() throws Exception {
        mockMvc.perform(post("/calculadora/programadora/convert")
                        .param("tipo", "octal")
                        .param("valor", "12"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", 10))
                .andExpect(model().attribute("binario", "1010"))
                .andExpect(model().attribute("hexadecimal", "A"))
                .andExpect(model().attribute("octal", "12"))
                .andExpect(view().name("calculadora/programadora"));
    }

    @Test
    void testError() throws Exception {
        mockMvc.perform(post("/calculadora/programadora/convert")
                        .param("tipo", "binario")
                        .param("valor", "10201")) // inválido
                .andExpect(status().isOk())
                .andExpect(model().attribute("decimal", "Error"))
                .andExpect(model().attribute("binario", "Error"))
                .andExpect(model().attribute("hexadecimal", "Error"))
                .andExpect(model().attribute("octal", "Error"))
                .andExpect(view().name("calculadora/programadora"));
    }
}
