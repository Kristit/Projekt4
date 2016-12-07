package com.example.java;

import javafx.scene.control.TextField;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class Math {

  /* String courseName;
    int ap;
    int leftHours;


    public int getLeftHours() {
        leftHours= ap*20;
        return leftHours;
        }

           ArrayList<Task???> taskList = readTaskList(hours);


        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\nTask " + (i + 1) + " is " + taskList.get(i).name + " and has " + taskList.get(i).hours + " hours");
        }



    private static ArrayList<Task> readTaskList(Scanner input, int askedTaskNumber, int leftHours) {
        ArrayList<Task> taskList = new ArrayList<Task>();

        for (int i = 1; i <= askedTaskNumber; i++) {
            Task task = new Task();
            System.out.println("Please add your task: " + i + ":");
            task.name = input.next();// as it is string, you don't need a next String!! (Intiga is nessery)

            if (i < askedTaskNumber) {
                if (i>1) System.out.println("\nLefthours: " + leftHours);
                System.out.println( "Please add your task: " );
                task.hours = input.nextInt(); // luhendad rida
                if (task.hours > leftHours) {
                    System.out.println("Check your hours! Error!");
                    i--; // make i same as it was the current task
                    continue; // contnniu for loop
                }
                leftHours = leftHours - task.hours; //  if there no error, only then save it ..Refector->rename variables all
            } else {
                task.hours = leftHours; // that we get last hours form system caluclation
                System.out.println("Workinghours: "+ leftHours);
            }
            taskList.add(task); // we collected all datas and now puting in the taskList
        }

        return taskList;
        */
    }

