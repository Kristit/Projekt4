package com.example.java;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

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
    ChoiceBox courseSelect;


    TaskLine(boolean useXButton) {


        Label label2 = new Label("List your tasks and working hours!");

        HBox hbox2 = new HBox();

        task = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        ChoiceBox courseSelect = new ChoiceBox();
        deadline = new DatePicker();

        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not

        getChildren().addAll(task, taskName, workingh, hours, courseSelect, deadline, removeTaskButton);

    }


    public Task getTask() {
        String hoursString = hours.getText();
        Integer hours = Integer.valueOf(hoursString);


        return new Task(0, taskName.getText(), hours, courseSelect.getTypeSelector(), deadline.getValue(), 0);


    }
}