package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // <------ #1
public class MoviesService {

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private final RestTemplate restTemplate = new RestTemplate(); // <------ #2

    public String getMovies(String query) {
        return this.restTemplate.getForObject( // <------ #3
                String.format("http://www.omdbapi.com/?s=%s&apikey=14aaa1f5", query),
                String.class
        );
    }

}