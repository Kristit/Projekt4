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
    VBox tasksBox;
    VBox coursesBox;
    Button addCourseButton;
    Button  addTaskButton;
    Button saveCourseInfomration;
    Label task;
    Label workingh;
    TextField taskName;
    public VBox vbox = new VBox();
    TextField hours;
    Button saveButton;
    Button removeTaskButton;
    Button useXButton;
    DatePicker deadline;


    public CourseWindowSetup() {
        startStage();

    }

    private void startStage() {
        VBox vbox = new VBox(); // loon uue layouti
        vbox.setSpacing(5);
        Scene courseWindow = new Scene(vbox, 600, 500); //Loon tseeni ja seon selel vboxiga

        stage.setScene(courseWindow);
        stage.show();

        Label title = new Label("Welcome to Time & Task Calculator");
        title.setTranslateX(150);
        title.setTranslateX(50);
        title.setScaleY(1.2);

        coursesBox = new VBox();

        tasksBox = new VBox(); // loon uue layouti
        tasksBox.setSpacing(5);
        Label label2 = new Label("List your tasks and working hours!");

        addCourseLine(false);

        addTaskLine(false);
        Button addTaskButton = new Button("Add Task");
        saveButton= new Button("Save");
        addCourseButton = new Button ("Add course");
        addTaskButton = new Button ("Add task");

        vbox.getChildren().addAll(title, coursesBox, label2, tasksBox, saveButton, addTaskButton, addCourseButton);

        addTaskButton.setOnAction(event -> {
            addTaskLine(true);
        });

        addCourseButton.setOnAction(event -> {

            addCourseLine(true);
        });

        saveButton.setOnAction(event -> {

            saveButton();
            /*String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab

            int ap = Integer.parseInt(credits.getText());//see string mida numbriks sisestada
            System.out.println(ap);*/
        });
    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);


        tasksBox.getChildren().add(newTaskLine);// creats new TaskLine()
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                tasksBox.getChildren().remove(newTaskLine);

            });
        }
    }

    private void addCourseLine(boolean useXButton) {
        CourseLine newCourseLine = new CourseLine(useXButton);


        coursesBox.getChildren().add(newCourseLine);// creats new TaskLine()
        if (useXButton) {
            newCourseLine.removeCourseButton.setOnAction(event -> {
                coursesBox.getChildren().remove(newCourseLine);

            });
        }
    }


    private void saveButton() {

        Main.courses.clear();// makes it emepty


        for (Node courseNode : coursesBox.getChildren()) {
            CourseLine cl = (CourseLine) courseNode;
            Course course = cl.getCourse();

            System.out.println("Course name is : " + course.getName() + " and credits are: " + course.getCredits());

            Main.courses.add(course);
        }

        for (Node toDoTask : tasksBox.getChildren()) {
            TaskLine tl = (TaskLine) toDoTask;
            Task task = tl.getTask();
            for (Course course : Main.courses) {
                if (course.getName().equals(task.getCourseName())) {
                    course.tasks.add(task);
                }

            }


            System.out.println(task.getName() + task.getHours() + task.getCourseName() + task.getDeadline());

        }
        Database.save(Main.courses);

    }

}



