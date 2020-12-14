package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Component
public class WordCounter {
    private Config config;
    public WordCounter(Config config) {
        this.config = config;
    }

    Map<String, Integer> count (String s) {
        Map<String, Integer> return_value = new HashMap();
        if (this.config.getCaseSensitive() == false) {
            s = s.toLowerCase();
        }
        s = s.replaceAll("\\p{P}", "");

        for (String skip : this.config.getSkip()) {
            s = s.replaceAll(skip, "");
        }

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
