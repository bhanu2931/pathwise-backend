package com.pathwise.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pathwise.backend.model.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {
}