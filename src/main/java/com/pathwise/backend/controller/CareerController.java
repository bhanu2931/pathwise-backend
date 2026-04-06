package com.pathwise.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.pathwise.backend.model.Career;
import com.pathwise.backend.repository.CareerRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/careers")
public class CareerController {

    @Autowired
    private CareerRepository repo;

    @GetMapping
    public List<Career> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Career add(@RequestBody Career c) {
        return repo.save(c);
    }
}