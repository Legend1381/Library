package com.example.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class file {
    public static ArrayList<String> reader (String path){
        ArrayList<String> data = new ArrayList<>();
        File admin_data = new File(path);
        try {
            Scanner reader = new Scanner(admin_data);
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                data.add(text);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
        return data;
    }

    public static ArrayList<String> reader_del_line (String path, String del_unit, int index){
        ArrayList<String> data = new ArrayList<>();
        File admin_data = new File(path);
        try {
            Scanner reader = new Scanner(admin_data);
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                if (!text.split("\\|")[index].equals(del_unit)){
                    data.add(text);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
        return data;
    }

    public static boolean check_existance(String path, String search_unit, int index){
        ArrayList<String> data = reader(path);
        for (String datum : data) {
            if (datum.split("\\|")[index].equals(search_unit)) {
                return true;
            }
        }
        return false;
    }
}
