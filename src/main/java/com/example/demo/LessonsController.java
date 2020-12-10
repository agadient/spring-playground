package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonsRepository repository;

    public LessonsController(LessonsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @GetMapping("/5")
    public Optional<Lesson> get5() {
        return this.repository.findById((long) 5);
    }

    @DeleteMapping("/5")
    public void delete5() {
        this.repository.deleteById((long) 5);
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}