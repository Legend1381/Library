package com.example.library;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Library extends Application {

    public void start(Stage Log_in) throws FileNotFoundException {
        menu();
    }

    public void menu() throws FileNotFoundException {
        Stage Log_in = new Stage();
        Log_in.setTitle("Library");
        Rectangle rect = new Rectangle(1280, 720);
        Image background = new Image(new FileInputStream("src/main/resources/images/log.png"));
        rect.setFill(new ImagePattern(background));

        TextField username = new TextField();
        username.setPromptText("Enter Username");
        username.setLayoutX(510);
        username.setLayoutY(285);
        username.setMaxSize(260, 75);
        username.setMinSize(260, 75);
        username.setStyle("""
            -fx-background-color: unset;
            -fx-text-fill: #000000;
            -fx-font-size: 24px;
            -fx-font-weight: bold;
                """);
        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");
        password.setLayoutX(510);
        password.setLayoutY(376);
        password.setMaxSize(260, 75);
        password.setMinSize(260, 75);
        password.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 24px;
            -fx-font-weight: bold;
            -fx-background-radius: 30px;
                """);

        TextField textField = new TextField();
        textField.setPromptText("Enter password");
        textField.setLayoutX(510);
        textField.setLayoutY(376);
        textField.setMaxSize(260, 75);
        textField.setMinSize(260, 75);
        textField.setStyle("""
            -fx-background-color: #ffffff;
            -fx-text-fill: #000000;
            -fx-font-size: 24px;
            -fx-font-weight: bold;
            -fx-background-radius: 20px;
                """);
        password.textProperty().bindBidirectional(textField.textProperty());
        CheckBox checkBox = new CheckBox();
        checkBox.setLayoutY(465);
        checkBox.setLayoutX(675);
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                textField.toFront();
            }
            else {
                password.toFront();
            }
        });


        Button log = new Button("Log In");
        log.setLayoutX(574);
        log.setLayoutY(505);
        log.setMaxSize(130, 50);
        log.setMinSize(130, 50);
        log.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #000000;
            -fx-font-size: 17px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        log.setCursor(Cursor.HAND);
        log.setOnMouseEntered(mouseEvent-> {
            log.setStyle("""
                -fx-background-color: #000000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        log.setOnMouseExited(mouseEvent-> {
            log.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #000000;
                -fx-font-size: 17px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        log.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String name = username.getText();
                String pass = password.getText();
                if (name.equals(admin.username)){

                    if (pass.equals(admin.password)){
                        try {
                            admin.admin_page(Log_in);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Password does not match username");
                        alert.setHeaderText("Wrong Password!");
                        alert.setTitle("Library Error!");
                        alert.showAndWait();
                    }
                }else {
                    boolean check = false;
                    int index = 0;
                    ArrayList<String> users_list = file.reader("src\\main\\resources\\datas\\users.txt");
                    for (int i = 0; i < users_list.size(); i++) {
                        if (users_list.get(i).split("\\|")[1].equals(name)){
                            check = true;
                            index = i;
                            break;
                        }
                    }
                    if (check){
                        if (users_list.get(index).split("\\|")[4].equals(pass)){
                            try {
                                Users.user_page(Log_in, users_list.get(index).split("\\|")[0], users_list.get(index).split("\\|")[1]);
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Password does not match username");
                            alert.setHeaderText("Wrong Password!");
                            alert.setTitle("Library Error!");
                            alert.showAndWait();
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "pleas check username and try again!");
                        alert.setHeaderText("Wrong Username!");
                        alert.setTitle("Library Error");
                        alert.showAndWait();
                    }
                }
            }
        });

        Group root = new Group(rect, textField, username, password, log, checkBox);

        Scene scene_1 = new Scene(root);

        Log_in.setScene(scene_1);
        Log_in.setResizable(false);
        Log_in.show();
    }



    public static void main(String[] args) {
        launch();
    }
}