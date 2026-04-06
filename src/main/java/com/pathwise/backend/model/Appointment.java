package com.pathwise.backend.model;

import jakarta.persistence.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String mentor;
    private String date;

    // getters & setters

    public Long getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMentor() { return mentor; }
    public void setMentor(String mentor) { this.mentor = mentor; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}