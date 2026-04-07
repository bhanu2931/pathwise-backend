package com.pathwise.backend.repository;

import com.pathwise.backend.model.Mentor;
import java.util.*;

public class MentorRepository {

    private List<Mentor> mentors = new ArrayList<>();

    public List<Mentor> findAll() {
        return mentors;
    }

    public Mentor save(Mentor mentor) {

        if (mentor.getId() == null) {
            mentor.setId((long) (mentors.size() + 1));
        }

        mentors.add(mentor);
        return mentor;
    }
}