package com.example.java;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class Database {

    /*https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html*/
    private static final String FILENAME = "courses.db"; //alati nii deklareeritud konstant*

    public static void save(ArrayList<Course> courses) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(courses);//sulgeb faili uhenduse
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Course> load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (ArrayList<Course>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();// tühi database, teeb tühja objekti.

        }
    }




        /*
        https://www.mkyong.com/java/try-with-resources-example-in-jdk-7/


        public static void save(ArrayList<Course> courses) {

            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                out.writeObject(courses);//serializing..ehk kirjutatakse maha streemi (faili)
                out.flush(); // writes it immediatly to file
                out.close(); //closes the file
            } catch (IOException e) {
                throw new RuntimeException(e);// rethrow exception
            }
        }

        public static ArrayList<Course> load() {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME));//info failist
                ArrayList<Course> courses = (ArrayList<Course>) in.readObject();//gives next object from the fail
                in.close();
                return courses;
            } catch (Exception e) {
                return new ArrayList<>();// nothing in database, give it back "embty" object

            }
        }*/

}

