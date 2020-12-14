package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WordCounter {
    @Bean
    public WordCounter WordCounter() {
        return new WordCounter();
    }

    Map<String, Integer> count (String s) {
        Map<String, Integer> return_value = new HashMap();
        s = s.replaceAll("\\p{P}", "");
        String[] s_split = s.split(" ");
        for (String word : s_split) {
            if (return_value.containsKey(word)) {
                Integer current_val = return_value.get(word);
                return_value.put(word, current_val+1);
            } else {
                return_value.put(word, 1);
            }
        }
        return return_value;
    }
}
