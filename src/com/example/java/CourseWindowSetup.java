package com.example.java;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class CourseWindowSetup {
    public Stage stage = new Stage();

    int lefthours;
    Label subject;
    Label cred;
    TextField subjectName;
    TextField credits;
    VBox coursesBox;
    Button addCourseButton;
    public VBox vbox = new VBox();
    Button saveButton;


    public CourseWindowSetup() {
        startStage();

    }

    private void startStage() {
        VBox vbox = new VBox(); // loon uue layouti
        vbox.setSpacing(5);
        Scene courseWindow = new Scene(vbox, 1300, 700); //Loon tseeni ja seon selel vboxiga

        stage.setScene(courseWindow);
        stage.show();

        Label title = new Label("Welcome to Time & Task Calculator");
        title.setTranslateX(150);
        title.setTranslateX(50);
        title.setScaleY(1.2);

        coursesBox = new VBox();
        if (!Main.courses.isEmpty()) {
            for (Course c : Main.courses) {
                CourseLine cl = addCourseLine(false);
                // copy all the data form c to cl
                cl.setData(c);

            }

        } else {
            addCourseLine(false);
        }


        saveButton = new Button("Save");
        addCourseButton = new Button("Add course");

        vbox.getChildren().addAll(title, coursesBox, addCourseButton, saveButton);


        addCourseButton.setOnAction(event -> {

            addCourseLine(true);
        });

        saveButton.setOnAction(event -> {

            save();

        });
    }


    private CourseLine addCourseLine(boolean useXButton) {
        CourseLine newCourseLine = new CourseLine(useXButton);

        coursesBox.getChildren().add(newCourseLine);
        if (useXButton) {
            newCourseLine.removeCourseButton.setOnAction(event -> {
                coursesBox.getChildren().remove(newCourseLine);

            });
        }
        return newCourseLine; // tagastan, et saaksin seda hiljem kasutada
    }


    private void save() {

        Main.courses.clear();// teen course listi tühjaks


        for (Node courseNode : coursesBox.getChildren()) {
            CourseLine cl = (CourseLine) courseNode;// "castimine"
            Course course = cl.getCourse();

            System.out.println(course);


            Main.courses.add(course);
        }


        Database.save(Main.courses);

    }

}