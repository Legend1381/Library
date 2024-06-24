package com.example.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class borrowed_books {
    private String name;
    private String person;
    private String s_date;
    private String e_date;

    public borrowed_books(String Name, String Person, String S_date, String E_date) {
        this.name = Name;
        this.person = Person;
        this.s_date = S_date;
        this.e_date = E_date;
    }

    public String getE_date() {
        return e_date;
    }

    public String getS_date() {
        return s_date;
    }

    public String getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public static TableView borrowed_books_table(){
        TableView b_books_table = new TableView<>();

        TableColumn name = new TableColumn<>("Name");
        name.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn user = new TableColumn<>("User");
        user.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn stardate = new TableColumn<>("Start Date");
        stardate.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn enddate = new TableColumn<>("End Date");
        enddate.setStyle("""
                -fx-alignment: CENTER;
                """);
        name.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("name"));
        user.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("person"));
        stardate.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("s_date"));
        enddate.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("e_date"));

        name.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.4));
        user.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));
        stardate.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));
        enddate.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));

        name.setResizable(false);
        user.setResizable(false);
        stardate.setResizable(false);
        enddate.setResizable(false);

        b_books_table.getColumns().addAll(name, user, stardate, enddate);

        b_books_table.setLayoutX(375);
        b_books_table.setLayoutY(210);
        b_books_table.setMaxSize(880, 490);
        b_books_table.setMinSize(880, 490);
        b_books_table.setStyle("""
                -fx-background-color: unset;
                """);

        ArrayList<String> data = file.reader("src\\main\\resources\\datas\\borrowed books.txt");
        ObservableList<borrowed_books> temp = FXCollections.observableArrayList();
        for (String datum : data) {
            String[] n = datum.split("\\|");
            temp.add(new borrowed_books(n[0], n[1], n[2], n[3]));
        }
        b_books_table.setItems(temp);
        return b_books_table;
    }

    public static TableView user_borrowed_books_table(String username){
        TableView b_books_table = new TableView<>();

        TableColumn name = new TableColumn<>("Name");
        name.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn user = new TableColumn<>("User");
        user.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn stardate = new TableColumn<>("Start Date");
        stardate.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn enddate = new TableColumn<>("End Date");
        enddate.setStyle("""
                -fx-alignment: CENTER;
                """);
        name.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("name"));
        user.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("person"));
        stardate.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("s_date"));
        enddate.setCellValueFactory(new PropertyValueFactory<borrowed_books, String>("e_date"));

        name.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.4));
        user.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));
        stardate.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));
        enddate.prefWidthProperty().bind(b_books_table.widthProperty().multiply(0.2));

        name.setResizable(false);
        user.setResizable(false);
        stardate.setResizable(false);
        enddate.setResizable(false);

        b_books_table.getColumns().addAll(name, user, stardate, enddate);

        b_books_table.setLayoutX(375);
        b_books_table.setLayoutY(210);
        b_books_table.setMaxSize(880, 430);
        b_books_table.setMinSize(880, 430);
        b_books_table.setStyle("""
                -fx-background-color: unset;
                """);

        ArrayList<String> data = file.reader("src\\main\\resources\\datas\\borrowed books.txt");
        ObservableList<borrowed_books> temp = FXCollections.observableArrayList();
        for (String datum : data) {
            String[] n = datum.split("\\|");
            if (n[1].equals(username)){
                temp.add(new borrowed_books(n[0], n[1], n[2], n[3]));
            }
        }
        b_books_table.setItems(temp);
        return b_books_table;
    }

}
