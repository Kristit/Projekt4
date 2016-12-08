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

    int lefthours;
    Label subject;
    Label cred;
    TextField subjectName;
    TextField credits;
    VBox tasksBox;
    Button addCourseButton;
    Button saveCourseInfomration;
    Label task;
    Label workingh;
    TextField taskName;
    public VBox vbox = new VBox();
    TextField hours;
    Button saveButton;
    Button removeTaskButton;
    Button useXButton;
    DatePicker deadline;

    ArrayList<TaskLine> toDoTasks = new ArrayList<>();//when you have a Text Line not a TextField anymore


    public CourseWindowSetup() {
        startStage();
        //setSaveCourseButton();
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
        saveButton = new Button("Save");
        hbox1.getChildren().addAll(subject, subjectName, cred, credits);

        tasksBox = new VBox(); // loon uue layouti
        tasksBox.setSpacing(5);
        Label label2 = new Label("List your tasks and working hours!");


        addTaskLine(false);
        Button addTaskButton = new Button("Add Task");
        vbox.getChildren().addAll(title, hbox1, label2, tasksBox, saveButton, addTaskButton);

        addTaskButton.setOnAction(event -> {
            addTaskLine(true);
        });

        saveButton.setOnAction(event -> {
            String courseName = subjectName.getText();// votan textifildist name teksti sisse!
            System.out.println(courseName); //kasutan seda ekranail kontrollimiseks, et ka snupp tootab

            int ap = Integer.parseInt(credits.getText());//see string mida numbriks sisestada
            System.out.println(ap);
        });
    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);


        tasksBox.getChildren().add(newTaskLine);// creats new TaskLine()
        toDoTasks.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                tasksBox.getChildren().remove(newTaskLine);
                toDoTasks.remove(toDoTasks.size() - 1);
            });
        }
    }

        private void saveButton() {




        /*Database.save(Main.courses);
             // toDoTasks ArrayList iterable- saad koikide elementide poole poorduda

        for (TaskLine toDoTask : toDoTasks) {

            System.out.println(toDoTask.taskName.getText()); // Trukib iga uksiku TextFieldi sisu systemouti
        System.out.println(toDoTask.getTaskName() + ": " + toDoTask.getHours()+ " and deadline is: "+ toDoTask.getDeadline());
        Main.database.addTask(toDoTask.getTaskName());}*/



        }


}



