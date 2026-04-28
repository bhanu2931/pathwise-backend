package com.pathwise.backend.controller;

import com.pathwise.backend.model.Appointment;
import com.pathwise.backend.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentRepository repo;

    public AppointmentController(AppointmentRepository repo) {
        this.repo = repo;
    }

    // ✅ BOOK SESSION
    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody Appointment appointment) {

        Map<String, Object> res = new HashMap<>();

        try {
            repo.save(appointment);

            res.put("message", "Session booked successfully");
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(res);
        }
    }

    // ✅ GET ALL BOOKINGS (for demo)
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }
}