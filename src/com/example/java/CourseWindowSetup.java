package com.example.java;

import com.sun.javafx.scene.text.TextLine;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class CourseWindowSetup {
    private Stage stage = new Stage();

    Label subject;
    Label cred;
    TextField subjectName;
    TextField credits;
    Button addCourseButton;
    Button saveCourseInfomration;
    Label task;
    Label workingh;
    TextField taskName;
    ChoiceBox choiceB;
    VBox vbox = new VBox();
    TextField hours;
    Button addTaskButton;
    Button removeTaskButton;
    Button useXButton;
    DatePicker deadline;
    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore


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

        HBox hbox1 = new HBox();

        hbox1.setSpacing(4);
        subject = new Label("Course name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        subjectName = new TextField();
        cred = new Label("credits");
        credits = new TextField();
        addCourseButton = new Button("Add course");
        hbox1.getChildren().addAll(subject, subjectName, cred, credits, addCourseButton);


        vbox.getChildren().addAll(title, hbox1);

        Label taskLabel = new Label("List your tasks and working hours!");
        taskLabel.setTranslateX(150);
        taskLabel.setTranslateX(50);
        taskLabel.setScaleY(1.2);

        HBox hbox2 = new HBox();
        hbox2.setSpacing(4);
        task = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        deadline = new DatePicker();
        ChoiceBox choiceB = new ChoiceBox(FXCollections.observableArrayList("Esimene", "Teine"));
        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not
        addTaskButton = new Button("Add Task");

        hbox2.getChildren().addAll(task, taskName, workingh, hours, deadline, choiceB, removeTaskButton, addTaskButton);

        addTaskButton.setOnAction(event -> {
            addTaskLine(true);
        });


        saveCourseInfomration = new Button("Save");

        vbox.getChildren().addAll(taskLabel, hbox2, saveCourseInfomration);
        addTaskLine(false);

    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);

        vbox.getChildren().add(vbox.getChildren().size() - 2, newTaskLine);// creats new TaskLine()

        toDoTasks.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                vbox.getChildren().remove(newTaskLine);
                toDoTasks.remove(toDoTasks.size() - 1);
            });

        }
    }
        private void setClickEvent() {


            saveCourseInfomration.setOnAction(event -> {
                String courseName = subjectName.getText();// votan textifildist name teksti sisse!
                System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab

                int ap = Integer.parseInt(credits.getText());//see string mida numbriks sisestada
                System.out.println(ap);


            });
        }
    }