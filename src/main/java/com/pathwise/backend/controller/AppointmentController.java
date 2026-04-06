package com.pathwise.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pathwise.backend.model.Appointment;
import com.pathwise.backend.repository.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repo;

    // ✅ SAVE BOOKING
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