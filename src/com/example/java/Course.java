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

    ArrayList <Task> tasks = new ArrayList<>();


    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
