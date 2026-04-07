package com.pathwise.backend.repository;

import com.pathwise.backend.model.Career;
import java.util.*;

public class CareerRepository {

    private List<Career> careers = new ArrayList<>();

    public List<Career> findAll() {
        return careers;
    }

    public Career save(Career career) {

        if (career.getId() == null) {
            career.setId((long) (careers.size() + 1));
        }

        careers.add(career);
        return career;
    }
}