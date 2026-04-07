package com.pathwise.backend.controller;

import com.pathwise.backend.model.Career;
import com.pathwise.backend.repository.CareerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
@CrossOrigin
public class CareerController {

    private CareerRepository repository = new CareerRepository();

    @GetMapping
    public List<Career> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Career create(@RequestBody Career career) {
        return repository.save(career);
    }
}