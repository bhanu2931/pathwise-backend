package com.pathwise.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mentor;
    private String date;
    private String time;
    private String userEmail;

    public Appointment() {}

    public Long getId() { return id; }

    public String getMentor() { return mentor; }
    public void setMentor(String mentor) { this.mentor = mentor; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}