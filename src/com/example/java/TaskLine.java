package com.example.java;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.time.LocalDate;

import java.time.LocalDate;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class TaskLine extends HBox {


    private Label task;
    private TextField taskName;
    private Label workingh;
    private TextField hours;
    private DatePicker deadline;
    Button addTaskButton;
    Button removeTaskButton;

    TaskLine(boolean useXButton) {

        task = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        deadline = new DatePicker();
        addTaskButton = new Button("Add Task");
        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not

        getChildren().addAll(task, taskName, workingh, hours, deadline, removeTaskButton);

    }


    /*public Task getTask() { return new Task(0, getTaskName(), getHours(), getDeadline(), 0);
    }*/

    public String getTaskName() {
        return taskName.getText();
    }

    public Integer getHours() {
        String hoursString = hours.getText();
        Integer hours = Integer.valueOf(hoursString);
        return hours;
    }

    public LocalDate getDeadline() {
        return deadline.getValue();

    }

  }