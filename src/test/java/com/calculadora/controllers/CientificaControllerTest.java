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
class CientificaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMostrar() throws Exception {
        mockMvc.perform(get("/calculadora/cientifica"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", ""))
                .andExpect(view().name("calculadora/cientifica"));
    }

    @Test
    void testInput() throws Exception {
        mockMvc.perform(post("/calculadora/cientifica/input")
                        .param("valor", "2")
                        .param("display", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", "12"))
                .andExpect(view().name("calculadora/cientifica"));
    }

    @Test
    void testIgual() throws Exception {
        mockMvc.perform(post("/calculadora/cientifica/igual")
                        .param("display", "3+4"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", "7.0"))
                .andExpect(view().name("calculadora/cientifica"));
    }

    @Test
    void testClear() throws Exception {
        mockMvc.perform(post("/calculadora/cientifica/clear"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("display", ""))
                .andExpect(view().name("calculadora/cientifica"));
    }
}
