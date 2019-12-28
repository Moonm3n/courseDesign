package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Tool.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SearchController {

    @FXML
    private Button backButton, borrowButton, searchButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label bookName1, bookName2, bookName3, bookName4, author1, author2, author3, author4, publisher1, publisher2, publisher3, publisher4;
    @FXML
    private Label location1, location2, location3, location4, bookNum1, bookNum2, bookNum3, bookNum4;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    private Scene backScene;
    private Stage stage;
    private String reader_id;

    private String[] book_id;

    public void search() throws SQLException {
        System.out.println("search");

        Label[] bookNames = {bookName1, bookName2, bookName3, bookName4};
        Label[] authors = {author1, author2, author3, author4};
        Label[] publishers = {publisher1, publisher2, publisher3, publisher4};
        Label[] locations = {location1, location2, location3, location4};
        Label[] bookNums = {bookNum1, bookNum2, bookNum3, bookNum4};
        CheckBox[] checkBoxes = {checkBox1, checkBox2, checkBox3, checkBox4};
        book_id = new String[4];
        for (int i=0; i < 4; i++){
            bookNames[i].setText("");
            authors[i].setText("");
            publishers[i].setText("");
            locations[i].setText("");
            bookNums[i].setText("");
            checkBoxes[i].setVisible(false);
        }

        Database database = new Database("book_management");
        ResultSet book_info = database.searchDatabase("select * from book_info");

        int i = 0;
        while(book_info.next()){
            if(searchTextField.getText().equals(book_info.getString("book_name")) ||
                    searchTextField.getText().equals(book_info.getString("author")) ||
                    searchTextField.getText().equals(book_info.getString("book_id"))
            ){
                bookNames[i].setText(book_info.getString("book_name"));
                authors[i].setText(book_info.getString("author"));
                publishers[i].setText(book_info.getString("publisher"));
                locations[i].setText(book_info.getString("location"));
                bookNums[i].setText(book_info.getString("book_num"));
                book_id[i] = book_info.getString("book_id");
                checkBoxes[i].setVisible(true);
                i++;
            }

        }

        database.close();

    }

    public void borrow() throws SQLException {
        System.out.println("borrow");
        AnchorPane root = new AnchorPane();
        Label label = new Label();
        label.setLayoutX(35);
        label.setLayoutY(20);
        Stage stage = new Stage();

        Label[] bookNames = {bookName1, bookName2, bookName3, bookName4};
        Label[] authors = {author1, author2, author3, author4};
        Label[] publishers = {publisher1, publisher2, publisher3, publisher4};
        Label[] locations = {location1, location2, location3, location4};
        Label[] bookNums = {bookNum1, bookNum2, bookNum3, bookNum4};
        CheckBox[] checkBoxes = {checkBox1, checkBox2, checkBox3, checkBox4};

        if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()){
            label.setText("借阅申请提交成功");
            root.getChildren().add(label);
            stage.setScene(new Scene(root, 200, 50));

            Database database = new Database("book_management");

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
            System.out.println(localDateTime.format(formatter));
            String borrowTime = localDateTime.format(formatter);
            localDateTime.plusMonths(1);
            String dueTime = localDateTime.format(formatter);

            if(checkBox1.isSelected()){
                database.changeDatabase("INSERT INTO borrow_info ( book_id, reader_id, borrow_time, due_time ) VALUES ( \""+book_id[0]+"\",\""+reader_id + "\",\"" + borrowTime + "\",\"" + dueTime + "\")" );
                checkBox1.setSelected(false);
            }
            if(checkBox2.isSelected()){
                database.changeDatabase("INSERT INTO borrow_info ( book_id, reader_id, borrow_time, due_time ) VALUES ( \""+book_id[1]+"\",\""+reader_id + "\",\"" + borrowTime + "\",\"" + dueTime + "\")" );
                checkBox2.setSelected(false);
            }
            if(checkBox3.isSelected()){
                database.changeDatabase("INSERT INTO borrow_info ( book_id, reader_id, borrow_time, due_time ) VALUES ( \""+book_id[2]+"\",\""+reader_id + "\",\"" + borrowTime + "\",\"" + dueTime + "\")" );
                checkBox3.setSelected(false);
            }
            if(checkBox4.isSelected()){
                database.changeDatabase("INSERT INTO borrow_info ( book_id, reader_id, borrow_time, due_time ) VALUES ( \""+book_id[3]+"\",\""+reader_id + "\",\"" + borrowTime + "\",\"" + dueTime + "\")" );
                checkBox4.setSelected(false);
            }


            stage.showAndWait();

        }else{
            label.setText("请选择至少一本书籍");
            root.getChildren().add(label);
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }

    }

    public void back(){
        stage.setScene(backScene);
    }

    public Scene getBackScene() {
        return backScene;
    }

    public void setBackScene(Scene backScene) {
        this.backScene = backScene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }
}
