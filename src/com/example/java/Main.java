package com.example.java;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new CourseWindowSetup();

    }

    public static void main(String[] args) {
        launch(args);
    }


    static ArrayList <Course> courses = new ArrayList<Course>();

}
