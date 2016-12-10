package com.example.java;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by kristitammet on 07/12/2016.
 */
public class CourseLine extends HBox{


    TextField subjectName;
    TextField credits;
    Button removeCourseButton;



    public CourseLine(boolean useXButton) {


        HBox hbox1 = new HBox();

        hbox1.setSpacing(4);
        Label subject = new Label("Course name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        subjectName = new TextField();
        Label cred = new Label("credits");
        credits = new TextField();
        removeCourseButton = new Button("X");
        removeCourseButton.setDisable(!useXButton);
        hbox1.getChildren().addAll(subject, subjectName, cred, credits, removeCourseButton);


    }




    public Course getCourse() {

        String cred = credits.getText();

        int ap = Integer.parseInt(cred);

        return new Course(subjectName.getText(), ap);
    }
}