package com.example.java;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

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



    public CourseWindowSetup() { //???
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

       coursesBox = new VBox(); //????
        if (! Main.courses.isEmpty()){
            for (Course c: Main.courses){
                CourseLine cl = addCourseLine(false);
                // copy all the data form c to cl
               cl.setData(c);

            }

        }else{
            addCourseLine(false);
        }



        saveButton= new Button("Save X");
        addCourseButton = new Button ("Add course");

        vbox.getChildren().addAll(title, coursesBox, addCourseButton, saveButton);



        addCourseButton.setOnAction(event -> {

            addCourseLine(true);
        });

        saveButton.setOnAction(event -> {

            saveButton();

        });
    }

    /*rivate void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);


        tasksBox.getChildren().add(newTaskLine);// creats new TaskLine()
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                tasksBox.getChildren().remove(newTaskLine);

            });
        }
    }*/

    private CourseLine addCourseLine(boolean useXButton) { //???
        CourseLine newCourseLine = new CourseLine(useXButton);


        coursesBox.getChildren().add(newCourseLine);// creats new TaskLine()
        if (useXButton) {
            newCourseLine.removeCourseButton.setOnAction(event -> {
                coursesBox.getChildren().remove(newCourseLine);

            });
        }
        return newCourseLine; //??
    }


    private void saveButton() {

        Main.courses.clear();// makes it empty


        for (Node courseNode : coursesBox.getChildren()) { //????
            CourseLine cl = (CourseLine) courseNode;
            Course course = cl.getCourse();

            System.out.println(course);

         /*for (Task t: course.getTasks()){
             System.out.println("Task name: " + t.getName() + " task working hours: " + t.getHours() +" worked hours: " + t.getWorkedhours() + " deadline: " + t.getDeadline());
         }*/

            Main.courses.add(course);
        }



        Database.save(Main.courses);

    }

}