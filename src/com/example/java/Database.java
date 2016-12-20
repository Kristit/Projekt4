package com.example.java;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by kristitammet on 06/12/2016.
 */
public class Database {

        private static final String FILENAME = "courses.db";

        public static void save(ArrayList<Course> courses) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                out.writeObject(courses);
                out.flush();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static ArrayList<Course> load() {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME));
                ArrayList<Course> courses = (ArrayList<Course>) in.readObject();
                in.close();
                return courses;
            } catch (Exception e) {
                return new ArrayList<>();// nothing in database

            }
        }

    }

