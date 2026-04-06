package com.pathwise.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pathwise.backend.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}