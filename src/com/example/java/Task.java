package com.example.java;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by kristitammet on 07/12/2016.
 */
public class Task implements Serializable{ //???


    private int workedhours;
    private String name;
    private int hours;
    private LocalDate deadline;




    public Task(String name, int hours, int workedhours, LocalDate deadline) {
        this.name = name;
        this.hours = hours;
        this.workedhours = workedhours;
        this.deadline = deadline;


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

    public int getWorkedhours() {
        return workedhours;
    }

    @Override
    public String toString() { //????
        return "Task{" +
                "workedhours=" + workedhours +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", deadline=" + deadline +
                '}';
    }
}



