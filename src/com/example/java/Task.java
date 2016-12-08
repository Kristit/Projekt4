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
    
    private String courseName;
    private int ap;

    

    public Task(String courseName, int ap) {
        this.courseName = courseName;
        this.ap = ap;

    }

    public Task(int i, String text, Integer hours, String typeSelector, LocalDate value, int i1) {
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



