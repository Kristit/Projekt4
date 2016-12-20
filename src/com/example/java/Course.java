package com.example.java;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by kristitammet on 10/12/2016.
 */
public class Course {


    String name;
    int credits;



    ArrayList <Task> tasks;


    public Course(String name, int credits, ArrayList<Task> tasks) {
        this.name = name;
        this.credits = credits;
        this.tasks= tasks;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

