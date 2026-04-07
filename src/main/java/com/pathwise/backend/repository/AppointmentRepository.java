package com.pathwise.backend.repository;

import com.pathwise.backend.model.Appointment;
import java.util.*;

public class AppointmentRepository {

    private List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> findAll() {
        return appointments;
    }

    public Appointment save(Appointment appointment) {

        // ✅ only set ID if null (safe)
        if (appointment.getId() == null) {
            appointment.setId((long) (appointments.size() + 1));
        }

        appointments.add(appointment);
        return appointment;
    }
}