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
class BasicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrar() throws Exception {
        mockMvc.perform(get("/calculadora/basica"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", ""))
                .andExpect(model().attribute("operando1", ""))
                .andExpect(model().attribute("operador", ""))
                .andExpect(view().name("calculadora/basica"));
    }

    @Test
    void testInput() throws Exception {
        mockMvc.perform(post("/calculadora/basica/input")
                        .param("valor", "2")
                        .param("display", "1")
                        .param("operando1", "")
                        .param("operador", ""))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", "12"))
                .andExpect(model().attribute("operando1", ""))
                .andExpect(model().attribute("operador", ""))
                .andExpect(view().name("calculadora/basica"));
    }

    @Test
    void testOp() throws Exception {
        mockMvc.perform(post("/calculadora/basica/op")
                        .param("op", "+")
                        .param("display", "5"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", "5+"))
                .andExpect(model().attribute("operando1", "5"))
                .andExpect(model().attribute("operador", "+"))
                .andExpect(view().name("calculadora/basica"));
    }

    @Test
    void testIgual() throws Exception {
        mockMvc.perform(post("/calculadora/basica/igual")
                        .param("display", "3+4"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", "7.0"))
                .andExpect(model().attribute("operando1", ""))
                .andExpect(model().attribute("operador", ""))
                .andExpect(view().name("calculadora/basica"));
    }

    @Test
    void testClear() throws Exception {
        mockMvc.perform(post("/calculadora/basica/clear"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", ""))
                .andExpect(model().attribute("operando1", ""))
                .andExpect(model().attribute("operador", ""))
                .andExpect(view().name("calculadora/basica"));
    }
}
