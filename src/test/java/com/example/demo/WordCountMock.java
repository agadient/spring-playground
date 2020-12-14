package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordCounterController.class)
@AutoConfigureMockMvc
public class WordCountMock {
    @Autowired
    MockMvc mvc;

    @MockBean
    WordCounter wc;

    @BeforeEach
    public void setup() {
        String s = "How now, brown cow";
        Map<String, Integer> m = new HashMap();
        m.put("How", 1);
        m.put("now", 1);
        m.put("cow", 1);
        m.put("brown", 1);
        when(wc.count(s)).thenReturn(m);
    }

    @Test
    public void testWordCounter() throws Exception {
        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("How now, brown cow");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"How\":1,\"now\":1,\"cow\":1,\"brown\":1}"));

    }


}
