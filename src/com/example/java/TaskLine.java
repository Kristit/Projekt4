package com.example.java;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class TaskLine extends HBox {


    private Label messageLabel;
    private Label deadlLineLabel;
    private Label workedh;
    private TextField updateHours;
    private Label taskLabel;
    private TextField taskName;
    private Label workingh;
    private TextField hours;
    private DatePicker deadline;

    Button removeTaskButton;


    TaskLine(boolean useXButton) {


        Label label2 = new Label("List your tasks and working hours!");


        HBox hbox2 = new HBox();

        taskLabel = new Label("Task name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        taskName = new TextField();
        workingh = new Label("hours");
        hours = new TextField();
        workedh = new Label(" worked hours");
        updateHours = new TextField("0");
        deadlLineLabel = new Label(" deadline");
        deadline = new DatePicker();
        messageLabel = new Label();

        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not

        getChildren().addAll(taskLabel, taskName, workingh, hours, workedh, updateHours, deadlLineLabel, deadline, removeTaskButton, messageLabel);
        activateUpdaters();
    }


    public Task getTask() {
        String hoursString = hours.getText();
        int hours = Integer.parseInt(hoursString);
        int updateh = Integer.parseInt(updateHours.getText());

        return new Task(taskName.getText(), hours, updateh, deadline.getValue());


    }

    public void setData(Task task) {
        taskName.setText(task.getName());
        hours.setText(String.valueOf(task.getHours()));
        deadline.setValue(task.getDeadline());
        updateHours.setText(String.valueOf(task.getWorkedhours()));
        // kalkuleerib ajavahemikud ja tundidevahemikud, et saaksin uue labeli sisu kirjutada
        mata();

    }


    public void mata() {
        try {
            Task task = getTask();
            int hoursLeft = task.getHours() - task.getWorkedhours();
            if (hoursLeft <= 0) {
                throw new UserInputException(" Hours left must be positive!");
            }
            long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());
            if (daysLeft <= 0) {
                throw new UserInputException(" Days left must be positive!");
            }
            String message = " You need to work " + hoursLeft + "\n hours within " + daysLeft + " days";
            if (hoursLeft / daysLeft >= 8) {
                message = message + "\n YOU NEED TO HURRY!";
            }
            messageLabel.setText(message);

        } catch (UserInputException e) {
            messageLabel.setText(e.getMessage());
        } catch (Exception e) {
            messageLabel.setText(" Fix errors!");
        }

    }

    /*Allolev osa pole minu kooditud, vaid küsisin abi! */

    public void activateUpdaters() { // meetod mis annab addlistenile ulesande vaatata kas mones elemendis on muudatusi
        hours.textProperty().addListener(observable -> mata()); // addlistner meteood mille abil saan hoursi muudatusi jalgida
        updateHours.textProperty().addListener(observable -> mata());
        deadline.valueProperty().addListener(observable -> mata());
    }
}