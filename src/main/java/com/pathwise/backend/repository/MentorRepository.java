package com.pathwise.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pathwise.backend.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}