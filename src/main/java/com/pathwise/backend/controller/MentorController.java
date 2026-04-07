package com.pathwise.backend.controller;

import com.pathwise.backend.model.Mentor;
import com.pathwise.backend.repository.MentorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentors")
@CrossOrigin
public class MentorController {

    private MentorRepository mentorRepository = new MentorRepository();

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    @PostMapping
    public Mentor addMentor(@RequestBody Mentor mentor) {
        return mentorRepository.save(mentor);
    }
}