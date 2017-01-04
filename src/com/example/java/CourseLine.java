package com.example.java;

        import javafx.scene.Node;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;

        import java.util.ArrayList;

/**
 * Created by kristitammet on 07/12/2016.
 */
public class CourseLine extends VBox{


    TextField subjectName;
    TextField credits;
    Button removeCourseButton;
    Button  addTaskButton;
    VBox tasksBox;
    ArrayList <TaskLine> taskLines = new ArrayList<>();

    public CourseLine(boolean useXButton) { //??? boolean xbutton

        HBox courseDetails = new HBox(4);

        Label subject = new Label("Course name"); //lisad teksti valja (Miks TextFiled peab ara votma?)
        subjectName = new TextField();
        Label cred = new Label("credits");
        credits = new TextField();
        addTaskButton = new Button ("Add task");
        removeCourseButton = new Button("X");
        removeCourseButton.setDisable(!useXButton);
        courseDetails.getChildren().addAll(subject, subjectName, cred, credits, removeCourseButton);

        addTaskButton.setOnAction(event -> {
            addTaskLine(true);
        });

        tasksBox = new VBox(); // loon uue layouti
        tasksBox.setSpacing(5);
        getChildren().addAll(courseDetails, tasksBox, addTaskButton);

        addTaskLine(false); //???

    }

    //
    public  void setData(Course c){ //????
        subjectName.setText(c.getName());
        credits.setText(String.valueOf(c.getCredits()));
        ArrayList<Task> tasks = c.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (i != 0) {
                addTaskLine(false);
            }
            taskLines.get(i).setData(task);
        }

    }

    private void addTaskLine(boolean useXButton) {
        TaskLine newTaskLine = new TaskLine(useXButton);


        tasksBox.getChildren().add(newTaskLine);// creats new TaskLine()
        taskLines.add(newTaskLine);
        if (useXButton) {
            newTaskLine.removeTaskButton.setOnAction(event -> {
                tasksBox.getChildren().remove(newTaskLine);
                taskLines.remove(newTaskLine);
            });
        }
    }




    public Course getCourse() { //???

        String cred = credits.getText();

        int ap = Integer.parseInt(cred);

        ArrayList <Task> tasks = new ArrayList<> ();
        for (Node taskNode : tasksBox.getChildren()) {
            TaskLine tl = (TaskLine) taskNode;
            Task task = tl.getTask();
            tasks.add(task);
        }



            return new Course(subjectName.getText(), ap, tasks);
    }
}