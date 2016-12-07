package com.example.java;

import com.sun.javafx.scene.text.TextLayout;
import com.sun.javafx.scene.text.TextLine;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
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
    public Stage stage = new Stage();
    public VBox vbox2;

    int lefthours;

    Label subject;
    Label cred;
    TextField subjectName;
    TextField credits;
    Button addCourseButton;
    Button saveCourseInfomration;
    Label task;
    Label workingh;
    TextField taskName;
    VBox vbox = new VBox();
    TextField hours;
    Button saveCourseButton;
    Button removeTaskButton;
    Button useXButton;
    DatePicker deadline;
    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore


    public CourseWindowSetup() {
        startStage();
        setSaveCourseButton();
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
        saveCourseButton = new Button("Save course");
        hbox1.getChildren().addAll(subject, subjectName, cred, credits, saveCourseButton);

        vbox.getChildren().addAll(title, hbox1);
        //VBox vbox2 = new VBox(); DO WE NEED THIS HERE?


    }

    private void setSaveCourseButton() {


         saveCourseButton.setOnAction(event -> {
           String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab

            int ap = Integer.parseInt(credits.getText());//see string mida numbriks sisestada
            System.out.println(ap);

            new Task(courseName, ap);


        });
    }

}



