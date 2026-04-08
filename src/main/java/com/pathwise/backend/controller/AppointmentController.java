package com.pathwise.backend.controller;

import com.pathwise.backend.model.Appointment;
import com.pathwise.backend.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentRepository repo;

    public AppointmentController(AppointmentRepository repo) {
        this.repo = repo;
    }

    // ✅ BOOK SESSION
    @PostMapping
    public Appointment book(@RequestBody Appointment appointment) {
        return repo.save(appointment);
    }

    // ✅ GET ALL BOOKINGS
    @GetMapping
    public List<Appointment> getAll() {
        return repo.findAll();
    }
}