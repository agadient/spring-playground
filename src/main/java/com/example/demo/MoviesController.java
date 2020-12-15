package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @GetMapping("/")
    public String getMovies(@RequestParam String q) {
        MoviesService ms = new MoviesService();
        return  ms.getMovies(q);
    }
}
