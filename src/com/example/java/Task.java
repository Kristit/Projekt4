package com.example.java;

import java.time.LocalDate;

/**
 * Created by kristitammet on 07/12/2016.
 */
public class Task {


    private String courseName;
    private String name;
    private int hours;
    private LocalDate deadline;




    public Task(String name, int hours, String courseName, LocalDate deadline) {
        this.name = name;
        this.hours = hours;
        this.courseName= courseName;
        this.deadline = deadline;


    }

    public String getCourseName() {
        return courseName;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}



