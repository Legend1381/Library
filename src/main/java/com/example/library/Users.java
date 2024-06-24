package com.example.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Users {
    private String stdNumber;
    private String name;
    private String level;
    private String department;
    private String password;

    public Users(String Name, String Stdnumber, String Level, String Department, String Password){
        this.stdNumber = Stdnumber;
        this.name = Name;
        this.level = Level;
        this.department = Department;
        this.password = Password;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getStdNumber() {
        return stdNumber;
    }

    public static void AddUser(String stdNum, String name, String level, String department, String password){
        try {
            FileWriter save = new FileWriter("src\\main\\resources\\datas\\users.txt", true);
            save.write(name + "|" + stdNum + "|" + level + "|" + department + "|" + password + "\n");
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TableView user_table(){
        TableView user_table = new TableView<>();

        TableColumn name = new TableColumn<>("Name");
        name.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn Std_num = new TableColumn<>("Student Number");
        Std_num.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn Lev = new TableColumn<>("Level");
        Lev.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn depart = new TableColumn<>("Department");
        depart.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn pass = new TableColumn<>("Password");
        pass.setStyle("""
                -fx-alignment: CENTER;
                """);

        name.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));
        Std_num.setCellValueFactory(new PropertyValueFactory<Users, String>("stdNumber"));
        Lev.setCellValueFactory(new PropertyValueFactory<Users, String>("level"));
        depart.setCellValueFactory(new PropertyValueFactory<Users, String>("department"));
        pass.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));

        name.prefWidthProperty().bind(user_table.widthProperty().multiply(0.2));
        Std_num.prefWidthProperty().bind(user_table.widthProperty().multiply(0.2));
        Lev.prefWidthProperty().bind(user_table.widthProperty().multiply(0.2));
        depart.prefWidthProperty().bind(user_table.widthProperty().multiply(0.2));
        pass.prefWidthProperty().bind(user_table.widthProperty().multiply(0.2));

        name.setResizable(false);
        Std_num.setResizable(false);
        Lev.setResizable(false);
        depart.setResizable(false);
        pass.setResizable(false);

        user_table.getColumns().addAll(name, Std_num, Lev, depart, pass);

        user_table.setLayoutX(375);
        user_table.setLayoutY(210);
        user_table.setMaxSize(885, 430);
        user_table.setMinSize(885, 430);
        user_table.setStyle("""
                -fx-background-color: unset;
                """);

        ArrayList<String> data = file.reader("src\\main\\resources\\datas\\users.txt");
        ObservableList<Users> list = FXCollections.observableArrayList();
        for (String datum : data) {
            String[] n = datum.split("\\|");
            list.add(new Users(n[0], n[1], n[2], n[3], n[4]));
        }
        user_table.setItems(list);
        return user_table;
    }

    public static void user_page(Stage user_panel, String NAME, String code) throws FileNotFoundException {
        Image background = new Image(new FileInputStream("src/main/resources/images/user.png"));
        Rectangle rec = new Rectangle(1280, 720, new ImagePattern(background));
//        Label name = new Label(NAME.split(" ")[0]);
//        name.setLayoutX(5);
//        name.setLayoutY(225);
//        name.setStyle("""
//                -fx-text-fill: #ffffff;
//                -fx-font-size: 40px;
//                """);

        Button info = new Button(NAME.split(" ")[0]);
        info.setLayoutX(0);
        info.setLayoutY(221);
        info.setMaxSize(330, 65);
        info.setMinSize(330, 65);
        info.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffd000;
                -fx-font-size: 35px;
                """);
        info.setOnMouseEntered(mouseEvent->{
            info.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #19d140;
                -fx-font-size: 35px;
                -fx-font-weight: bold;
                """);
        });
        info.setOnMouseExited(mouseEvent->{
            info.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffd000;
                -fx-font-size: 35px;
                """);
        });
        info.setCursor(Cursor.HAND);

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

        Button log_out = new Button("Log out");
        log_out.setLayoutX(102);
        log_out.setLayoutY(595);
        log_out.setMaxSize(130, 50);
        log_out.setMinSize(130, 50);
        log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 25px;
                """);
        log_out.setOnMouseEntered(mouseEvent->{
            log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #c30000;
                -fx-font-size: 25px;
                -fx-font-weight: bold;
                """);
        });
        log_out.setOnMouseExited(mouseEvent->{
            log_out.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #ffffff;
                -fx-font-size: 25px;
                """);
        });
        log_out.setCursor(Cursor.HAND);

        log_out.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Library back = new Library();
                try {
                    back.menu();
                    user_panel.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Image new_background = null;
                try {
                    new_background = new Image(new FileInputStream("src/main/resources/images/user_all_books.png"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Rectangle r = new Rectangle(1280, 720, new ImagePattern(new_background));
                Group root = new Group(r, info, books, Borrowed_books, log_out, com.example.library.books.all_books_table());
                Scene us_page = new Scene(root);
                user_panel.setScene(us_page);

            }
        });

        Borrowed_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Image new_background = null;
                try {
                    new_background = new Image(new FileInputStream("src/main/resources/images/your_borrowed_books.png"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Rectangle r = new Rectangle(1280, 720, new ImagePattern(new_background));
                Group root = new Group(r, info, books, Borrowed_books, log_out, borrowed_books.user_borrowed_books_table(code));
                Scene us_page = new Scene(root);
                user_panel.setScene(us_page);
            }
        });

        info.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    user_id_card(code);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Group root = new Group(rec, info, books, Borrowed_books, log_out);
        Scene us_page = new Scene(root);
        user_panel.setScene(us_page);

    }

    public static void remove_user() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("Remove user");

        Image background = new Image(new FileInputStream("src/main/resources/images/remove user.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField user_id = new TextField();
        user_id.setPromptText("Book Id");
        user_id.setLayoutY(164);
        user_id.setLayoutX(135);
        user_id.setMinSize(330, 70);
        user_id.setMaxSize(330, 70);
        user_id.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        user_id.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent keyEvent) {
                if (!"0123456789".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                }
            }
        });

        Button ok = new Button("OK");
        ok.setLayoutX(175);
        ok.setLayoutY(340);
        ok.setMaxSize(100, 40);
        ok.setMinSize(100, 40);
        ok.setCursor(Cursor.HAND);
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
        ok.setOnMouseEntered(mouseEvent-> {
            ok.setStyle("""
                -fx-background-color: #19d140;
                -fx-background-radius: 20px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
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
        cancel.setCursor(Cursor.HAND);
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
        cancel.setOnMouseEntered(mouseEvent-> {
            cancel.setStyle("""
                -fx-background-color: #c30000;
                -fx-background-radius: 20px;
                -fx-text-fill: #000000;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #000000;
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
                if (file.check_existance("src\\main\\resources\\datas\\users.txt", user_id.getText(), 1)){
                    ArrayList<String> new_list = file.reader_del_line("src\\main\\resources\\datas\\users.txt", user_id.getText(), 1);
                    FileWriter save = null;
                    try {
                        save = new FileWriter("src\\main\\resources\\datas\\users.txt");
                        for (String s : new_list) {
                            save.write(s + "\n");
                        }
                        save.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    form.close();
                    Alert error = new Alert(Alert.AlertType.INFORMATION, "User removed successfully!");
                    error.setTitle("remove user");
                    error.setHeaderText("Done!");
                    error.showAndWait();
                }else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Sorry, this user doesn't exist!");
                    error.setTitle("remove user");
                    error.setHeaderText("Failed!");
                    error.showAndWait();
                }
            }
        });

        Group root = new Group(r, user_id, ok, cancel);
        Scene lend = new Scene(root);
        form.setScene(lend);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

    public static void reset_all(){
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "This will delet all users\ndo you want to continue?", ButtonType.YES, ButtonType.CANCEL);
        confirm.setHeaderText("Are you sure?");
        confirm.setTitle("Remove users");
        confirm.showAndWait();

        if (confirm.getResult().equals(ButtonType.YES)){
            FileWriter save = null;
            try {
                save = new FileWriter("src\\main\\resources\\datas\\users.txt");
                save.write("");
                save.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "list cleared successfully!");
                alert.setTitle("Remove all");
                alert.setHeaderText("Done!");
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void user_id_card(String code) throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("your ID");

        Image background = new Image(new FileInputStream("src/main/resources/images/id card.png"));
        Rectangle r = new Rectangle(393, 600);
        r.setFill(new ImagePattern(background));

        ArrayList<String> list = file.reader("src\\main\\resources\\datas\\users.txt");
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).split("\\|")[1].equals(code)){
                index = i;
            }
        }
        String current_user = list.get(index);

        Label name = new Label(current_user.split("\\|")[0]);
        name.setLayoutX(0);
        name.setLayoutY(257);
        name.setMaxSize(393, 50);
        name.setMinSize(393, 50);
        name.setAlignment(Pos.CENTER);
        name.setStyle("""
                -fx-text-fill: #0498a8;
                -fx-font-size: 30px;
                -fx-font-weight: bold;
                """);

        Label Id = new Label(current_user.split("\\|")[1]);
        Id.setLayoutX(0);
        Id.setLayoutY(341);
        Id.setMaxSize(393, 40);
        Id.setMinSize(393, 40);
        Id.setAlignment(Pos.CENTER);
        Id.setStyle("""
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);

        Label level = new Label(current_user.split("\\|")[2]);
        level.setLayoutX(0);
        level.setLayoutY(412);
        level.setMaxSize(393, 40);
        level.setMinSize(393, 40);
        level.setAlignment(Pos.CENTER);
        level.setStyle("""
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);

        Label department = new Label(current_user.split("\\|")[3]);
        department.setLayoutX(0);
        department.setLayoutY(477);
        department.setMaxSize(393, 40);
        department.setMinSize(393, 40);
        department.setAlignment(Pos.CENTER);
        department.setStyle("""
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);

        Label password = new Label(current_user.split("\\|")[4]);
        password.setLayoutX(0);
        password.setLayoutY(542);
        password.setMaxSize(393, 40);
        password.setMinSize(393, 40);
        password.setAlignment(Pos.CENTER);
        password.setStyle("""
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);

        Label hide = new Label("click here!");
        hide.setLayoutX(0);
        hide.setLayoutY(542);
        hide.setMaxSize(393, 40);
        hide.setMinSize(393, 40);
        hide.setAlignment(Pos.CENTER);
        hide.setStyle("""
                -fx-background-color: #323232;
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);
        hide.setCursor(Cursor.HAND);
        hide.setOnMouseClicked(MouseEvent->{
            hide.setText("");
            hide.setStyle("""
                -fx-background-color: unset;
                -fx-text-fill: #000000;
                -fx-font-size: 20px;
                """);
        });

        Group root = new Group(r, name, Id, level, department, password, hide);
        Scene card = new Scene(root);
        form.setScene(card);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }
}
