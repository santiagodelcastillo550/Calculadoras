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
class ConversorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrar() throws Exception {
        mockMvc.perform(get("/calculadora/conversores"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("categoria", "temperatura"))
                .andExpect(model().attribute("entrada", ""))
                .andExpect(model().attribute("salida", ""))
                .andExpect(model().attribute("descripcion", ""))
                .andExpect(view().name("calculadora/conversores"));
    }

    @Test
    void testConvertirTemperatura() throws Exception {
        mockMvc.perform(post("/calculadora/conversores/convert")
                        .param("categoria", "temperatura")
                        .param("entrada", "0"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("salida", 32.0))
                .andExpect(model().attribute("descripcion", "Convirtiendo de Celsius a Fahrenheit"))
                .andExpect(view().name("calculadora/conversores"));
    }

    @Test
    void testConvertirLongitud() throws Exception {
        mockMvc.perform(post("/calculadora/conversores/convert")
                        .param("categoria", "longitud")
                        .param("entrada", "100"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("salida", 1.0))
                .andExpect(model().attribute("descripcion", "Convirtiendo de centímetros a metros"))
                .andExpect(view().name("calculadora/conversores"));
    }

    @Test
    void testConvertirPeso() throws Exception {
        mockMvc.perform(post("/calculadora/conversores/convert")
                        .param("categoria", "peso")
                        .param("entrada", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("salida", 2.20462))
                .andExpect(model().attribute("descripcion", "Convirtiendo de kilogramos a libras"))
                .andExpect(view().name("calculadora/conversores"));
    }

    @Test
    void testConvertirTiempo() throws Exception {
        mockMvc.perform(post("/calculadora/conversores/convert")
                        .param("categoria", "tiempo")
                        .param("entrada", "60"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("salida", 1.0))
                .andExpect(model().attribute("descripcion", "Convirtiendo de minutos a horas"))
                .andExpect(view().name("calculadora/conversores"));
    }

    @Test
    void testConvertirMoneda() throws Exception {
        mockMvc.perform(post("/calculadora/conversores/convert")
                        .param("categoria", "moneda")
                        .param("entrada", "100"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("salida", 90.0))
                .andExpect(model().attribute("descripcion", "Convirtiendo de USD a EUR"))
                .andExpect(view().name("calculadora/conversores"));
    }
}
