package com.example.library;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class admin {
    public static ArrayList<String> admin_data = file.reader("src\\main\\resources\\datas\\admin.txt");
    public static String username = admin_data.get(0);
    public static String password = admin_data.get(1);

    public static void admin_page(Stage admin_panel) throws FileNotFoundException {
        try {
            FileWriter save = new FileWriter("src\\main\\resources\\datas\\admin.txt");
            save.write(username + "\n");
            save.write(password);
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image background = new Image(new FileInputStream("src/main/resources/images/admin.png"));
        Rectangle rec = new Rectangle(1280, 720, new ImagePattern(background));

        AtomicReference<String> which_page = new AtomicReference<>("");

        Label name = new Label(username);
        name.setLayoutX(100);
        name.setLayoutY(225);
        name.setStyle("""
                -fx-text-fill: #ffffff;
                -fx-font-size: 40px;
                """);

        Button users = new Button("Users");
        users.setLayoutX(0);
        users.setLayoutY(564);
        users.setMaxSize(330, 112);
        users.setMinSize(330, 112);
        users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 50px;
                """);
        users.setOnMouseEntered(mouseEvent->{
            users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffd000;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        users.setOnMouseExited(mouseEvent->{
            users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 50px;
                """);
        });
        users.setCursor(Cursor.HAND);

        Button Borrowed_books = new Button("Borrowed Books");
        Borrowed_books.setLayoutX(0);
        Borrowed_books.setLayoutY(453);
        Borrowed_books.setMaxSize(330, 112);
        Borrowed_books.setMinSize(330, 112);
        Borrowed_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 35px;
                """);
        Borrowed_books.setOnMouseEntered(mouseEvent->{
            Borrowed_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffd000;
                -fx-font-size: 35px;
                -fx-font-weight: bold;
                """);
        });
        Borrowed_books.setOnMouseExited(mouseEvent->{
            Borrowed_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 35px;
                """);
        });
        Borrowed_books.setCursor(Cursor.HAND);

        Button books = new Button("Books");
        books.setLayoutX(0);
        books.setLayoutY(342);
        books.setMaxSize(330, 112);
        books.setMinSize(330, 112);
        books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 50px;
                """);
        books.setOnMouseEntered(mouseEvent->{
            books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffd000;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        books.setOnMouseExited(mouseEvent->{
            books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 50px;
                """);
        });
        books.setCursor(Cursor.HAND);

        Button add_users = new Button("Add Users");
        add_users.setLayoutX(326);
        add_users.setLayoutY(87);
        add_users.setMaxSize(245, 85);
        add_users.setMinSize(245, 85);
        add_users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        add_users.setOnMouseEntered(mouseEvent->{
            add_users.setText("+");
            add_users.setLayoutY(77);
            add_users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #28313a;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        add_users.setOnMouseExited(mouseEvent->{
            add_users.setText("Add Users");
            add_users.setLayoutY(87);
            add_users.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        });
        add_users.setCursor(Cursor.HAND);

        Button add_books = new Button("Add Books");
        add_books.setLayoutX(567);
        add_books.setLayoutY(87);
        add_books.setMaxSize(236, 85);
        add_books.setMinSize(236, 85);
        add_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        add_books.setOnMouseEntered(mouseEvent->{
            add_books.setText("+");
            add_books.setLayoutY(77);
            add_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #28313a;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        add_books.setOnMouseExited(mouseEvent->{
            add_books.setLayoutY(87);
            add_books.setText("Add Books");
            add_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        });
        add_books.setCursor(Cursor.HAND);

        Button lend_books = new Button("Lend Books");
        lend_books.setLayoutX(804);
        lend_books.setLayoutY(87);
        lend_books.setMaxSize(252, 85);
        lend_books.setMinSize(252, 85);
        lend_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        lend_books.setOnMouseEntered(mouseEvent->{
            lend_books.setText("+");
            lend_books.setLayoutY(77);
            lend_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #28313a;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        lend_books.setOnMouseExited(mouseEvent->{
            lend_books.setText("Lend Books");
            lend_books.setLayoutY(87);
            lend_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        });
        lend_books.setCursor(Cursor.HAND);

        Button return_books = new Button("Return Books");
        return_books.setLayoutX(1055);
        return_books.setLayoutY(87);
        return_books.setMaxSize(224, 85);
        return_books.setMinSize(224, 85);
        return_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        return_books.setOnMouseEntered(mouseEvent->{
            return_books.setText("+");
            return_books.setLayoutY(77);
            return_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #28313a;
                -fx-font-size: 50px;
                -fx-font-weight: bold;
                """);
        });
        return_books.setOnMouseExited(mouseEvent->{
            return_books.setText("Return Books");
            return_books.setLayoutY(87);
            return_books.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 30px;
                """);
        });
        return_books.setCursor(Cursor.HAND);

        Button log_out = new Button("Log out");
        log_out.setLayoutX(110);
        log_out.setLayoutY(275);
        log_out.setMaxSize(100, 50);
        log_out.setMinSize(100, 50);
        log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                """);
        log_out.setOnMouseEntered(mouseEvent->{
            log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #c30000;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                """);
        });
        log_out.setOnMouseExited(mouseEvent->{
            log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                """);
        });
        log_out.setCursor(Cursor.HAND);


        log_out.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Library back = new Library();
                try {
                    back.menu();
                    admin_panel.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Button refresh = new Button("refresh");
        refresh.setLayoutX(881);
        refresh.setLayoutY(656);
        refresh.setMaxSize(100, 40);
        refresh.setMinSize(100, 40);
        refresh.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        refresh.setCursor(Cursor.HAND);
        refresh.setOnMouseEntered(mouseEvent-> {
            refresh.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        refresh.setOnMouseExited(mouseEvent-> {
            refresh.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button remove_all = new Button("remove all");
        remove_all.setLayoutX(753);
        remove_all.setLayoutY(656);
        remove_all.setMaxSize(100, 40);
        remove_all.setMinSize(100, 40);
        remove_all.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 13px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        remove_all.setCursor(Cursor.HAND);
        remove_all.setOnMouseEntered(mouseEvent-> {
            remove_all.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 13px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        remove_all.setOnMouseExited(mouseEvent-> {
            remove_all.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 13px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button remove = new Button("remove");
        remove.setLayoutX(623);
        remove.setLayoutY(656);
        remove.setMaxSize(100, 40);
        remove.setMinSize(100, 40);
        remove.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        remove.setCursor(Cursor.HAND);
        remove.setOnMouseEntered(mouseEvent-> {
            remove.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        remove.setOnMouseExited(mouseEvent-> {
            remove.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        add_users.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ad_users();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        add_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ad_book();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        lend_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    lend_book();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    return_book();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                which_page.set("all books");
                Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out, com.example.library.books.all_books_table(), remove, remove_all, refresh);
                Scene all_book_chart = new Scene(root);
                admin_panel.setScene(all_book_chart);
            }
        });

        Borrowed_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out, borrowed_books.borrowed_books_table());
                Scene borrowed_books_chart = new Scene(root);
                admin_panel.setScene(borrowed_books_chart);
            }
        });

        users.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                which_page.set("users");
                Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out, Users.user_table(), remove, remove_all, refresh);
                Scene users_chart = new Scene(root);
                admin_panel.setScene(users_chart);
            }
        });

        refresh.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (which_page.get().equals("all books")){
                    Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out, com.example.library.books.all_books_table(), remove, remove_all, refresh);
                    Scene all_book_chart = new Scene(root);
                    admin_panel.setScene(all_book_chart);
                } else if (which_page.get().equals("users")) {
                    Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out, Users.user_table(), remove, remove_all, refresh);
                    Scene users_chart = new Scene(root);
                    admin_panel.setScene(users_chart);
                }
            }
        });

        remove_all.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (which_page.get().equals("all books")){
                    com.example.library.books.resetall();
                } else if (which_page.get().equals("users")) {
                    Users.reset_all();
                }
            }
        });

        remove.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                   if (which_page.get().equals("all books")){
                       com.example.library.books.remove_book();
                   }else if (which_page.get().equals("users")){
                       Users.remove_user();
                   }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Group root = new Group(rec, name, books, users, Borrowed_books, add_users, add_books, lend_books, return_books, log_out);
        Scene ad_page = new Scene(root);
        admin_panel.setScene(ad_page);
        admin_panel.setResizable(false);
    }
    public static void ad_users() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("add users");

        Image background = new Image(new FileInputStream("src/main/resources/images/register.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField stdnumber = new TextField();
        stdnumber.setPromptText("stdNumber");
        stdnumber.setLayoutY(50);
        stdnumber.setLayoutX(50);
        stdnumber.setMinSize(220, 60);
        stdnumber.setMaxSize(220, 60);
        stdnumber.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 20px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 2px;
                """);
        stdnumber.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        TextField name = new TextField();
        name.setPromptText("Full Name");
        name.setLayoutY(50);
        name.setLayoutX(330);
        name.setMinSize(220, 60);
        name.setMaxSize(220, 60);
        name.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 20px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 2px;
                """);
        name.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        TextField password = new TextField();
        password.setPromptText("Password");
        password.setLayoutY(140);
        password.setLayoutX(50);
        password.setMinSize(220, 60);
        password.setMaxSize(220, 60);
        password.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 20px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 2px;
                """);
        password.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        TextField confirm = new TextField();
        confirm.setPromptText("Confirm Password");
        confirm.setLayoutY(140);
        confirm.setLayoutX(330);
        confirm.setMinSize(220, 60);
        confirm.setMaxSize(220, 60);
        confirm.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 20px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 2px;
                """);
        confirm.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        Button ok = new Button("Register");
        ok.setLayoutX(285);
        ok.setLayoutY(345);
        ok.setMaxSize(100, 40);
        ok.setMinSize(100, 40);
        ok.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        ok.setCursor(Cursor.HAND);
        ok.setOnMouseEntered(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        ok.setOnMouseExited(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button cancel = new Button("Cancel");
        cancel.setLayoutX(420);
        cancel.setLayoutY(345);
        cancel.setMaxSize(100, 40);
        cancel.setMinSize(100, 40);
        cancel.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        cancel.setCursor(Cursor.HAND);
        cancel.setOnMouseEntered(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        cancel.setOnMouseExited(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        ToggleGroup check1 = new ToggleGroup();

        RadioButton undergraduate = new RadioButton();
        undergraduate.setToggleGroup(check1);
        undergraduate.setSelected(true);
        undergraduate.setLayoutY(231);
        undergraduate.setLayoutX(264);


        RadioButton masters = new RadioButton();
        masters.setToggleGroup(check1);
        masters.setLayoutY(231);
        masters.setLayoutX(377);

        RadioButton phd = new RadioButton();
        phd.setToggleGroup(check1);
        phd.setLayoutY(231);
        phd.setLayoutX(483);

        ToggleGroup check2 = new ToggleGroup();

        RadioButton computer = new RadioButton();
        computer.setToggleGroup(check2);
        computer.setSelected(true);
        computer.setLayoutX(315);
        computer.setLayoutY(286);

        RadioButton electrical = new RadioButton();
        electrical.setToggleGroup(check2);
        electrical.setLayoutX(540);
        electrical.setLayoutY(288);

        RadioButton basic = new RadioButton();
        basic.setToggleGroup(check2);
        basic.setLayoutX(152);
        basic.setLayoutY(323);


        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                form.close();
            }
        });

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String lev;
                String dep;

                if (stdnumber.getText().equals("") || name.getText().equals("") || password.getText().equals("") || confirm.getText().equals("")){
                    Alert Failed = new Alert(Alert.AlertType.ERROR, "Fields can't be empty!");
                    Failed.setTitle("add user");
                    Failed.setHeaderText("Failed!");
                    Failed.showAndWait();
                }else if (!file.check_existance("src\\main\\resources\\datas\\users.txt", stdnumber.getText(), 1)){
                    if (!password.getText().equals(confirm.getText())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Password does not match confirmation");
                        alert.setHeaderText("Failed!");
                        alert.setTitle("add user");
                        alert.showAndWait();
                    } else {
                        if (computer.isSelected()) {
                            dep = "Computer Engineering";
                        } else if (electrical.isSelected()) {
                            dep = "Electrical Engineering";
                        } else {
                            dep = "Basic Sciences";
                        }

                        if (undergraduate.isSelected()) {
                            lev = "Undergraduate";
                        } else if (masters.isSelected()) {
                            lev = "Masters";
                        } else {
                            lev = "P.H.D";
                        }

                        Users.AddUser(stdnumber.getText(), name.getText(), lev, dep, password.getText());
                        form.close();

                        Alert successful = new Alert(Alert.AlertType.INFORMATION, "User added successfully.");
                        successful.setTitle("add user");
                        successful.setHeaderText("Done!");
                        successful.show();
                    }
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Sorry, user with this student number already exists!");
                    alert.setHeaderText("Failed!");
                    alert.setTitle("add user");
                    alert.showAndWait();
                }

            }
        });

        Group root = new Group(r, stdnumber, name, password, confirm, ok, cancel, phd, masters, undergraduate, basic, electrical, computer);
        Scene register = new Scene(root);
        form.setScene(register);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

    public static void ad_book() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("add books");

        Image background = new Image(new FileInputStream("src/main/resources/images/add book.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField book_name = new TextField();
        book_name.setPromptText("book name");
        book_name.setLayoutY(55);
        book_name.setLayoutX(100);
        book_name.setMinSize(400, 100);
        book_name.setMaxSize(400, 100);
        book_name.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 5px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        book_name.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        ToggleGroup cat = new ToggleGroup();

        RadioButton computer = new RadioButton();
        computer.setToggleGroup(cat);
        computer.setSelected(true);
        computer.setLayoutX(174);
        computer.setLayoutY(235);

        RadioButton math = new RadioButton();
        math.setToggleGroup(cat);
        math.setLayoutX(350);
        math.setLayoutY(235);

        RadioButton physic = new RadioButton();
        physic.setToggleGroup(cat);
        physic.setLayoutX(517);
        physic.setLayoutY(235);

        RadioButton chemistry = new RadioButton();
        chemistry.setToggleGroup(cat);
        chemistry.setLayoutX(171);
        chemistry.setLayoutY(280);

        RadioButton electricity = new RadioButton();
        electricity.setToggleGroup(cat);
        electricity.setLayoutX(344);
        electricity.setLayoutY(280);

        RadioButton general = new RadioButton();
        general.setToggleGroup(cat);
        general.setLayoutX(521);
        general.setLayoutY(280);

        Button ok = new Button("ADD");
        ok.setLayoutX(175);
        ok.setLayoutY(340);
        ok.setMaxSize(100, 40);
        ok.setMinSize(100, 40);
        ok.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        ok.setCursor(Cursor.HAND);
        ok.setOnMouseEntered(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        ok.setOnMouseExited(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button cancel = new Button("Cancel");
        cancel.setLayoutX(322);
        cancel.setLayoutY(340);
        cancel.setMaxSize(100, 40);
        cancel.setMinSize(100, 40);
        cancel.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        cancel.setCursor(Cursor.HAND);
        cancel.setOnMouseEntered(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        cancel.setOnMouseExited(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                form.close();
            }
        });

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (book_name.getText().equals("")){
                    Alert Failed = new Alert(Alert.AlertType.ERROR, "Book name can't be empty!");
                    Failed.setTitle("add book");
                    Failed.setHeaderText("Failed!");
                    Failed.showAndWait();
                }else if (!file.check_existance("src\\main\\resources\\datas\\books.txt", book_name.getText(), 1)){
                    String category;

                    if (computer.isSelected()){
                        category = "Computer";
                    } else if (math.isSelected()) {
                        category = "Mathematics";
                    } else if (physic.isSelected()) {
                        category = "Physics";
                    } else if (chemistry.isSelected()) {
                        category = "Chemistry";
                    } else if (electricity.isSelected()) {
                        category = "Electricity";
                    }else {
                        category = "General";
                    }

                    books.AddBook(book_name.getText(), category);

                    form.close();

                    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Book added successfully.");
                    successful.setTitle("add book");
                    successful.setHeaderText("Done!");
                    successful.showAndWait();
                }else {
                    Alert Failed = new Alert(Alert.AlertType.ERROR, "Sorry, Book with this name already exists!");
                    Failed.setTitle("add book");
                    Failed.setHeaderText("Failed!");
                    Failed.showAndWait();
                }
            }
        });


        Group root = new Group(r, computer, math, physic, chemistry, electricity, general, book_name, ok, cancel);
        Scene add = new Scene(root);
        form.setScene(add);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

    public static void lend_book() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("lend book");

        Image background = new Image(new FileInputStream("src/main/resources/images/lend.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField book_name = new TextField();
        book_name.setPromptText("book name");
        book_name.setLayoutY(85);
        book_name.setLayoutX(135);
        book_name.setMinSize(330, 70);
        book_name.setMaxSize(330, 70);
        book_name.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        book_name.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        TextField student_number = new TextField();
        student_number.setPromptText("stdNumber");
        student_number.setLayoutY(230);
        student_number.setLayoutX(135);
        student_number.setMinSize(330, 70);
        student_number.setMaxSize(330, 70);
        student_number.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        student_number.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if (!"1234567890".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        Button ok = new Button("OK");
        ok.setLayoutX(175);
        ok.setLayoutY(340);
        ok.setMaxSize(100, 40);
        ok.setMinSize(100, 40);
        ok.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        ok.setCursor(Cursor.HAND);
        ok.setOnMouseEntered(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        ok.setOnMouseExited(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button cancel = new Button("Cancel");
        cancel.setLayoutX(322);
        cancel.setLayoutY(340);
        cancel.setMaxSize(100, 40);
        cancel.setMinSize(100, 40);
        cancel.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        cancel.setCursor(Cursor.HAND);
        cancel.setOnMouseEntered(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        cancel.setOnMouseExited(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                form.close();
            }
        });

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!file.check_existance("src\\main\\resources\\datas\\borrowed books.txt", book_name.getText(), 0)){
                    boolean check = books.lendbook(book_name.getText(), student_number.getText());
                    if (check) {
                        form.close();
                        Alert error = new Alert(Alert.AlertType.INFORMATION, "Done successfully!");
                        error.setTitle("lend book");
                        error.setHeaderText("Done!");
                        error.showAndWait();
                    }else {
                        Alert error = new Alert(Alert.AlertType.ERROR, "wrong information!\nplease check spell and try again!");
                        error.setTitle("lend book");
                        error.setHeaderText("Failed!");
                        error.showAndWait();
                    }
                }else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Sorry, this book isn't available!");
                    error.setTitle("lend book");
                    error.setHeaderText("Failed!");
                    error.showAndWait();
                }
            }
        });

        Group root = new Group(r, book_name, student_number, ok, cancel);
        Scene lend = new Scene(root);
        form.setScene(lend);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

    public static void return_book() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("return book");

        Image background = new Image(new FileInputStream("src/main/resources/images/return.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField book_name = new TextField();
        book_name.setPromptText("book name");
        book_name.setLayoutY(85);
        book_name.setLayoutX(135);
        book_name.setMinSize(330, 70);
        book_name.setMaxSize(330, 70);
        book_name.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        book_name.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if ("|".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        TextField student_number = new TextField();
        student_number.setPromptText("stdNumber");
        student_number.setLayoutY(230);
        student_number.setLayoutX(135);
        student_number.setMinSize(330, 70);
        student_number.setMaxSize(330, 70);
        student_number.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        student_number.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if (!"1234567890".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        Button ok = new Button("OK");
        ok.setLayoutX(175);
        ok.setLayoutY(340);
        ok.setMaxSize(100, 40);
        ok.setMinSize(100, 40);
        ok.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        ok.setCursor(Cursor.HAND);
        ok.setOnMouseEntered(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        ok.setOnMouseExited(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        Button cancel = new Button("Cancel");
        cancel.setLayoutX(322);
        cancel.setLayoutY(340);
        cancel.setMaxSize(100, 40);
        cancel.setMinSize(100, 40);
        cancel.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        cancel.setCursor(Cursor.HAND);
        cancel.setOnMouseEntered(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        cancel.setOnMouseExited(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                form.close();
            }
        });

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String name = book_name.getText();
                String stdnum = student_number.getText();
                boolean match = false;
                ArrayList<String> data = file.reader("src\\main\\resources\\datas\\borrowed books.txt");
                for (int i = 0; i < data.size(); i++) {
                    if (stdnum.equals(data.get(i).split("\\|")[1]) && name.equals(data.get(i).split("\\|")[0])){
                        match = true;
                        break;
                    }
                }
                if (match){
                    books.retbook(name);
                    form.close();
                    Alert successful = new Alert(Alert.AlertType.INFORMATION, "book returned successfully!");
                    successful.setTitle("return book");
                    successful.setHeaderText("Done!");
                    successful.showAndWait();
                }else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Wrong information!\nplease check and try again.");
                    error.setTitle("return book");
                    error.setHeaderText("Failed!");
                    error.showAndWait();
                }
            }
        });

        Group root = new Group(r, book_name, student_number, ok, cancel);
        Scene lend = new Scene(root);
        form.setScene(lend);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

}