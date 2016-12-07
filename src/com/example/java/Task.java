package com.example.java;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by kristitammet on 07/12/2016.
 */
public class Task {
    Button saveButton;
    Button addButton;
    VBox vBox = new VBox();
    private String courseName;
    private int ap;
    Label label2;
    Label task;
    Label workingh;
    TextField taskName;
    TextField hours;
    Button removeTaskButton;
    Button addTaskButton;
    Button useXButton;
    DatePicker deadline;
    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when I have a TextLine



    /*public Tasks(String courseName, int ap) {
        this.courseName = courseName;
        this.ap = ap;
    }*/

    private void addTask() {


        label2 = new Label("List your tasks and working hours!");

        VBox vbox2 = new VBox();
        HBox hbox2 = new HBox();

        task = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        deadline = new DatePicker();
        addTaskButton = new Button("Add Task");
        removeTaskButton = new Button("X");

        hbox2.getChildren().addAll(label2, task,taskName, workingh, hours, deadline, addTaskButton, removeTaskButton);


        saveButton = new Button("Save");
        vbox2.getChildren().addAll(hbox2, saveButton);

        addTaskButton.setOnAction(event -> {
            TaskLine(true);
        });

        //vbox2.getChildren().add(saveButton);
        //TaskLine(false);
    }


    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);

        vBox.getChildren().add(vBox.getChildren().size() - 2, newTaskLine);// creats new TaskLine()
        toDoTasks.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                vBox.getChildren().remove(newTaskLine);
                toDoTasks.remove(toDoTasks.size() - 1);
            });
        }
    }


      /*saveButton.setOnAction(event -> {
        Database.save(Main.courses);
        //for (TaskLine toDoTask : toDoTasks) {// toDoTasks ArrayList iterable- saad koikide elementide poole poorduda
        //System.out.println(toDoTask.nameField.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
        //System.out.println(toDoTask.getName() + ": " + toDoTask.getHours()+ " and deadline is: "+ toDoTask.getDeadline());
        //Main.database.addTask(toDoTask.getTask());
        //}
    });*/

 }



