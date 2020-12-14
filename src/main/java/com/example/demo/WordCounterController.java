package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/words")
public class WordCounterController {
    @PostMapping("/count")
    public Map<String, Integer> countWords(@RequestBody String words) {
        WordCounter wc =new WordCounter();
        return wc.count(words);
    }

}
