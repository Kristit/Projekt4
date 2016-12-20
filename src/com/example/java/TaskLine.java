package com.example.java;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class TaskLine extends HBox {


    private Label task;
    private TextField taskName;
    private Label workingh;
    private TextField hours;
    private DatePicker deadline;

    Button removeTaskButton;



    TaskLine(boolean useXButton) {


        Label label2 = new Label("List your tasks and working hours!");


        HBox hbox2 = new HBox();

        task = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        deadline = new DatePicker();

        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not

        getChildren().addAll(task, taskName, workingh, hours, deadline, removeTaskButton);

    }


    public Task getTask() {
        String hoursString = hours.getText();
        int hours = Integer.parseInt(hoursString);


        return new Task(taskName.getText(), hours, deadline.getValue());


    }
}