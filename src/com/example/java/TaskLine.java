package com.example.java;

import javafx.beans.Observable;
import javafx.scene.control.*;
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
        deadlLineLabel= new Label (" deadline");
        deadline = new DatePicker();
        messageLabel = new Label();

        removeTaskButton = new Button("X");
        removeTaskButton.setDisable(!useXButton);// Boolena not

        getChildren().addAll(taskLabel, taskName, workingh, hours, workedh, updateHours, deadlLineLabel, deadline, removeTaskButton, messageLabel);
        activateUpdaters();
    }


    public Task getTask() { //???
        String hoursString = hours.getText();
        int hours = Integer.parseInt(hoursString);
        int updateh = Integer.parseInt(updateHours.getText());

        return new Task(taskName.getText(), hours,updateh, deadline.getValue());


    }
    public void setData(Task task){ //???
        taskName.setText(task.getName());
        hours.setText(String.valueOf(task.getHours()));
        deadline.setValue(task.getDeadline());
        updateHours.setText(String.valueOf(task.getWorkedhours()));
        // calkuleerima ajavahemikud ja tundidevahemikud ja uus label teha
       mata();

    }
    // calkuleerima ajavahemikud ja tundidevahemikud ja uus label teha

    public void mata (){ //????
        try {
            Task task= getTask();
         int hoursLeft= task.getHours()-task.getWorkedhours();
            if (hoursLeft<= 0){
                throw new UserInputException(" Hours left must be positive!");// tekst muuda!!!!
            }
        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());
            if (daysLeft<= 0){
                throw new UserInputException(" Days left must be positive!");
            }
            String message = " You neet to work "+ hoursLeft+ "\n hours within " +daysLeft+ " days";
            if (hoursLeft/daysLeft >= 8){
                message= message+ "\n YOU NEED TO HURRY!";
            }
            messageLabel.setText(message);

        } catch (UserInputException e){
            messageLabel.setText(e.getMessage());
        }

        catch (Exception e){
            messageLabel.setText(" Fix errors!");
        }

    }

    public void activateUpdaters(){ //???
        hours.textProperty().addListener(this::mata); // meetodi viide (public void mata)
        updateHours.textProperty().addListener(this::mata);
        deadline.valueProperty().addListener(this::mata);
    }
    public void mata(Observable observable){ ///???
        mata();

    }
}