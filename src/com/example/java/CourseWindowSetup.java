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

    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore
    ArrayList<CourseLine> courses = new ArrayList<>();

    public CourseWindowSetup() {
        startStage();
        //setSaveCourseButton();
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
        vbox.getChildren().addAll(title, coursesBox, label2, tasksBox, saveButton, addTaskButton);

        addTaskButton.setOnAction(event -> {
            addTaskLine(true);
        });

        addCourseButton.setOnAction(event -> {
            addCourseLine(true);
        });

        saveButton.setOnAction(event -> {
            String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab

            int ap = Integer.parseInt(credits.getText());//see string mida numbriks sisestada
            System.out.println(ap);
        });
    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);


        tasksBox.getChildren().add(newTaskLine);// creats new TaskLine()
        toDoTasks.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                tasksBox.getChildren().remove(newTaskLine);
                toDoTasks.remove(toDoTasks.size() - 1);
            });
        }
    }

    private void addCourseLine(boolean useXButton) {
        CourseLine newCourseLine = new CourseLine(useXButton);


        coursesBox.getChildren().add(newCourseLine);// creats new TaskLine()
        courses.add(newCourseLine);
        if (useXButton) {
            newCourseLine.removeCourseButton.setOnAction(event -> {
                coursesBox.getChildren().remove(newCourseLine);
                courses.remove(courses.size() - 1);
            });
        }
    }


    private void saveButton() {

        for (Node toDoTask : tasksBox.getChildren()) {
            TaskLine tl = (TaskLine)toDoTask;
            Task task = tl.getTask();

            System.out.println(tl.getTask()); // Trukib iga uksiku TextFieldi sisu systemouti
            System.out.println(toDoTask.getTaskName() + ": " + toDoTask.getHours() + " and deadline is: " + toDoTask.getDeadline());
            Main.database.addTask(toDoTask.getTaskName());
        }


        for (CourseLine course : courses) {

            System.out.println(course.courseName.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
            System.out.println(course.getTaskName() + ": " + course.getcred());
            Main.database.addTask(toDoTask.getTaskName());
        }

    }

}



