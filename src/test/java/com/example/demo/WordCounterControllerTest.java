package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WordCounterControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testCount() {
        WordCounter wc = new WordCounter();
        Map<String, Integer> m = new HashMap();
        m.put("How", 1);
        m.put("now", 1);
        m.put("cow", 1);
        m.put("brown", 1);
        assertEquals(wc.count("How now, brown cow"), m, "Did not get correct count!");
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
