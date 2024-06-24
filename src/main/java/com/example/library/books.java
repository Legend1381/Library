package com.example.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class books {
    private String id;
    private String name;
    private String category;
    private String status;

    public books(String Id, String Name, String Category, String Status){
        this.category = Category;
        this.name = Name;
        this.id = Id;
        this.status = Status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }


    public static void AddBook(String book_name, String book_category){
        try {
            FileWriter save = new FileWriter("library\\src\\main\\resources\\datas\\books.txt", true);
            save.write(Id_generator() + "|" + book_name + "|" + book_category + "\n");
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int Id_generator(){
        Random ran = new Random();
        return ran.nextInt(899999) + 100000;
    }

    public static String start_date(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String end_date(String level){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        switch (level){
            case "Undergraduate": return dtf.format(now.plusDays(14));
            case "Masters":return dtf.format(now.plusDays(21));
        }
        return dtf.format(now.plusDays(28));
    }

    public static boolean lendbook(String name, String sNum){
        boolean check_1 = false;
        boolean check_2 = false;
        int index_1;
        int index_2 = 0;
        ArrayList<String> available_books = file.reader("library\\src/main/resources/datas/books.txt");
        ArrayList<String> students = file.reader("library\\src/main/resources/datas/users.txt");

        for (int i = 0; i < available_books.size(); i++) {
            String[] temp = available_books.get(i).split("\\|");
            if (temp[1].equals(name)){
                check_1 = true;
                index_1= i;
                break;
            }
        }
        for (int i = 0; i < students.size(); i++) {
            String[] temp = students.get(i).split("\\|");
            if (temp[1].equals(sNum)){
                check_2 = true;
                index_2 = i;
                break;
            }
        }
        if (check_1 && check_2){
            String start = books.start_date();
            String end = books.end_date(students.get(index_2).split("\\|")[2]);
            try {
                FileWriter save = new FileWriter("library\\src\\main\\resources\\datas\\borrowed books.txt", true);
                save.write(name + "|" + sNum + "|" + start + "|" + end + "\n");
                save.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }else {
            return false;
        }
    }

    public static void retbook(String bookName){
        ArrayList<String> new_list = file.reader_del_line("src\\main\\resources\\datas\\borrowed books.txt", bookName, 0);
        try {
            FileWriter save = new FileWriter("src\\main\\resources\\datas\\borrowed books.txt");
            for (int i = 0; i < new_list.size(); i++) {
                save.write(new_list.get(i) + "\n");
            }
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static TableView all_books_table(){
        TableView all = new TableView<>();

        TableColumn Id = new TableColumn<>("Id");
        Id.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn name = new TableColumn<>("Name");
        name.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn category = new TableColumn<>("Category");
        category.setStyle("""
                -fx-alignment: CENTER;
                """);
        TableColumn status = new TableColumn<>("Status");
        status.setStyle("""
                -fx-alignment: CENTER;
                """);

        Id.setCellValueFactory(new PropertyValueFactory<books, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<books, String>("name"));
        category.setCellValueFactory(new PropertyValueFactory<books, String>("category"));
        status.setCellValueFactory(new PropertyValueFactory<books, String>("status"));

        Id.prefWidthProperty().bind(all.widthProperty().multiply(0.2));
        name.prefWidthProperty().bind(all.widthProperty().multiply(0.4));
        category.prefWidthProperty().bind(all.widthProperty().multiply(0.2));
        status.prefWidthProperty().bind(all.widthProperty().multiply(0.2));

        Id.setResizable(false);
        name.setResizable(false);
        category.setResizable(false);
        status.setResizable(false);

        all.getColumns().addAll(Id, name, category, status);

        all.setLayoutX(375);
        all.setLayoutY(210);
        all.setMaxSize(880, 430);
        all.setMinSize(880, 430);
        all.setStyle("""
                -fx-background-color: unset;
                """);

        ArrayList<String> data = file.reader("src\\main\\resources\\datas\\books.txt");
        ObservableList<books> list = FXCollections.observableArrayList();
        for (int i = 0; i < data.size(); i++) {
            String stat;
            String[] n = data.get(i).split("\\|");
            if (file.check_existance("src\\main\\resources\\datas\\borrowed books.txt",n[1], 0)){
                stat = "unavailable";
            }else stat = "available";
            list.add(new books(n[0], n[1], n[2], stat));
        }
        all.setItems(list);
        return all;
    }

    public static void remove_book() throws FileNotFoundException {
        Stage form = new Stage();
        form.setTitle("Remove book");

        Image background = new Image(new FileInputStream("src/main/resources/images/remove.png"));
        Rectangle r = new Rectangle(600, 400);
        r.setFill(new ImagePattern(background));

        TextField book_id = new TextField();
        book_id.setPromptText("Book Id");
        book_id.setLayoutY(164);
        book_id.setLayoutX(135);
        book_id.setMinSize(330, 70);
        book_id.setMaxSize(330, 70);
        book_id.setStyle("""
            -fx-background-color: #ffffff;
            -fx-background-radius: 10px;
            -fx-text-fill: #000000;
            -fx-font-size: 30px;
            -fx-font-weight: bold;
            -fx-border-color: #000000;
            -fx-border-width: 5px;
            -fx-border-radius: 5px;
                """);
        book_id.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
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
            -fx-text-fill: #ffffff;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #ffffff;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
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
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
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
            -fx-text-fill: #ffffff;
            -fx-font-size: 15px;
            -fx-font-weight: bold;
            -fx-border-color: #ffffff;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
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
                -fx-text-fill: #ffffff;
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
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
                if (file.check_existance("src\\main\\resources\\datas\\books.txt", book_id.getText(), 0)){
                    ArrayList<String> new_list = file.reader_del_line("src\\main\\resources\\datas\\books.txt", book_id.getText(), 0);
                    FileWriter save = null;
                    try {
                        save = new FileWriter("src\\main\\resources\\datas\\books.txt");
                        for (String s : new_list) {
                            save.write(s + "\n");
                        }
                        save.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    form.close();
                    Alert error = new Alert(Alert.AlertType.INFORMATION, "Book removed successfully!");
                    error.setTitle("remove book");
                    error.setHeaderText("Done!");
                    error.showAndWait();
                }else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Sorry, this book doesn't exist!");
                    error.setTitle("remove book");
                    error.setHeaderText("Failed!");
                    error.showAndWait();
                }
            }
        });

        Group root = new Group(r, book_id, ok, cancel);
        Scene lend = new Scene(root);
        form.setScene(lend);
        form.initModality(Modality.APPLICATION_MODAL);
        form.setResizable(false);
        form.show();
    }

    public static void resetall(){
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "This will delet all books and borrowed books\ndo you want to continue?", ButtonType.YES, ButtonType.CANCEL);
        confirm.setHeaderText("Are you sure?");
        confirm.setTitle("Remove books");
        confirm.showAndWait();

        if (confirm.getResult().equals(ButtonType.YES)){
            FileWriter save = null;
            FileWriter save2 = null;
            try {
                save = new FileWriter("src\\main\\resources\\datas\\books.txt");
                save.write("");
                save.close();
                save2 = new FileWriter("src\\main\\resources\\datas\\borrowed books.txt");
                save2.write("");
                save2.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "list cleared successfully!");
                alert.setTitle("Remove all");
                alert.setHeaderText("Done!");
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
