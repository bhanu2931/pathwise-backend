package com.pathwise.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pathwise.backend.model.Mentor;
import com.pathwise.backend.repository.MentorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/mentors")
@CrossOrigin(origins = "*")
public class MentorController {

    @Autowired
    private MentorRepository repo;

    // GET ALL
    @GetMapping
    public List<Mentor> getAll() {
        return repo.findAll();
    }

    // ADD (ADMIN)
    @PostMapping
    public Mentor addMentor(@RequestBody Mentor m) {
        return repo.save(m);
    }
}