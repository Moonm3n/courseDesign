package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Tool.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReturnController {

    @FXML
    private Button backButton, returnButton;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    @FXML
    private Label bookName1, bookName2, bookName3, bookName4, bookName5, borrowTime1, borrowTime2, borrowTime3, borrowTime4, borrowTime5, dueTime1, dueTime2, dueTime3, dueTime4, dueTime5;


    private Scene backScene;
    private Stage stage;
    private String reader_id;
    private String[] book_id;


    public void returnBook() throws SQLException {
        System.out.println("borrow");
        AnchorPane root = new AnchorPane();
        Label label = new Label();
        label.setLayoutX(35);
        label.setLayoutY(20);
        Stage stage = new Stage();

        if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected() || checkBox5.isSelected()){
            label.setText("归还申请提交成功");
            root.getChildren().add(label);
            stage.setScene(new Scene(root, 200, 50));

            Database database = new Database("book_management");

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
            System.out.println(localDateTime.format(formatter));
            String returnTime = localDateTime.format(formatter);

            if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected() || checkBox5.isSelected()){
                if(checkBox1.isSelected()){
                    database.changeDatabase("INSERT INTO return_info ( book_id, reader_id, return_time ) VALUES ( \""+book_id[0]+"\",\""+reader_id + "\",\"" + returnTime + "\")" );
                    database.connect();
                    database.changeDatabase("UPDATE borrow_info SET status=2 WHERE borrow_time='"+borrowTime1.getText()+"'");
                    database.connect();
                    database.changeDatabase("UPDATE book_info SET book_num=book_num+1 WHERE book_id='"+book_id[0]+"'");
                    checkBox1.setSelected(false);
                }
                if(checkBox2.isSelected()){
                    database.changeDatabase("INSERT INTO return_info ( book_id, reader_id, return_time ) VALUES ( \""+book_id[1]+"\",\""+reader_id + "\",\"" + returnTime + "\")" );
                    database.connect();
                    database.changeDatabase("UPDATE borrow_info SET status=2 WHERE borrow_time='"+borrowTime2.getText()+"'");
                    database.connect();
                    database.changeDatabase("UPDATE book_info SET book_num=book_num+1 WHERE book_id='"+book_id[1]+"'");
                    checkBox2.setSelected(false);
                }
                if(checkBox3.isSelected()){
                    database.changeDatabase("INSERT INTO return_info ( book_id, reader_id, return_time ) VALUES ( \""+book_id[2]+"\",\""+reader_id + "\",\"" + returnTime + "\")" );
                    database.connect();
                    database.changeDatabase("UPDATE borrow_info SET status=2 WHERE borrow_time='"+borrowTime3.getText()+"'");
                    database.connect();
                    database.changeDatabase("UPDATE book_info SET book_num=book_num+1 WHERE book_id='"+book_id[2]+"'");
                    checkBox3.setSelected(false);
                }
                if(checkBox4.isSelected()){
                    database.changeDatabase("INSERT INTO return_info ( book_id, reader_id, return_time ) VALUES ( \""+book_id[3]+"\",\""+reader_id + "\",\"" + returnTime + "\")" );
                    database.connect();
                    database.changeDatabase("UPDATE borrow_info SET status=2 WHERE borrow_time='"+borrowTime4.getText()+"'");
                    database.connect();
                    database.changeDatabase("UPDATE book_info SET book_num=book_num+1 WHERE book_id='"+book_id[3]+"'");
                    checkBox4.setSelected(false);
                }
                if(checkBox5.isSelected()){
                    database.changeDatabase("INSERT INTO return_info ( book_id, reader_id, return_time ) VALUES ( \""+book_id[4]+"\",\""+reader_id + "\",\"" + returnTime + "\")" );
                    database.connect();
                    database.changeDatabase("UPDATE borrow_info SET status=2 WHERE borrow_time='"+borrowTime5.getText()+"'");
                    database.connect();
                    database.changeDatabase("UPDATE book_info SET book_num=book_num+1 WHERE book_id='"+book_id[4]+"'");
                    checkBox5.setSelected(false);
                }
                this.refresh();
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

    public Label getBookName1() {
        return bookName1;
    }

    public void setBookName1(Label bookName1) {
        this.bookName1 = bookName1;
    }

    public Label getBookName2() {
        return bookName2;
    }

    public void setBookName2(Label bookName2) {
        this.bookName2 = bookName2;
    }

    public Label getBookName3() {
        return bookName3;
    }

    public void setBookName3(Label bookName3) {
        this.bookName3 = bookName3;
    }

    public Label getBorrowTime1() {
        return borrowTime1;
    }

    public void setBorrowTime1(Label borrowTime1) {
        this.borrowTime1 = borrowTime1;
    }

    public Label getBorrowTime2() {
        return borrowTime2;
    }

    public void setBorrowTime2(Label borrowTime2) {
        this.borrowTime2 = borrowTime2;
    }

    public Label getBorrowTime3() {
        return borrowTime3;
    }

    public void setBorrowTime3(Label borrowTime3) {
        this.borrowTime3 = borrowTime3;
    }

    public Label getDueTime1() {
        return dueTime1;
    }

    public void setDueTime1(Label dueTime1) {
        this.dueTime1 = dueTime1;
    }

    public Label getDueTime2() {
        return dueTime2;
    }

    public void setDueTime2(Label dueTime2) {
        this.dueTime2 = dueTime2;
    }

    public Label getDueTime3() {
        return dueTime3;
    }

    public void setDueTime3(Label dueTime3) {
        this.dueTime3 = dueTime3;
    }

    public Label getBookName4() {
        return bookName4;
    }

    public void setBookName4(Label bookName4) {
        this.bookName4 = bookName4;
    }

    public Label getBookName5() {
        return bookName5;
    }

    public void setBookName5(Label bookName5) {
        this.bookName5 = bookName5;
    }

    public Label getBorrowTime4() {
        return borrowTime4;
    }

    public void setBorrowTime4(Label borrowTime4) {
        this.borrowTime4 = borrowTime4;
    }

    public Label getBorrowTime5() {
        return borrowTime5;
    }

    public void setBorrowTime5(Label borrowTime5) {
        this.borrowTime5 = borrowTime5;
    }

    public Label getDueTime4() {
        return dueTime4;
    }

    public void setDueTime4(Label dueTime4) {
        this.dueTime4 = dueTime4;
    }

    public Label getDueTime5() {
        return dueTime5;
    }

    public void setDueTime5(Label dueTime5) {
        this.dueTime5 = dueTime5;
    }

    public CheckBox getCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(CheckBox checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public CheckBox getCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(CheckBox checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public CheckBox getCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(CheckBox checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public CheckBox getCheckBox4() {
        return checkBox4;
    }

    public void setCheckBox4(CheckBox checkBox4) {
        this.checkBox4 = checkBox4;
    }

    public CheckBox getCheckBox5() {
        return checkBox5;
    }

    public void setCheckBox5(CheckBox checkBox5) {
        this.checkBox5 = checkBox5;
    }

    public String[] getBook_id() {
        return book_id;
    }

    public void setBook_id(String[] book_id) {
        this.book_id = book_id;
    }

    public void refresh() throws SQLException {
        Database database = new Database("book_management");
        ResultSet borrow_info = database.searchDatabase("select * from borrow_info where reader_id=" + reader_id+" and status='1'");
        ReturnController returnController = this;

        Label[] bookNames = {returnController.getBookName1(), returnController.getBookName2(), returnController.getBookName3(), returnController.getBookName4(), returnController.getBookName5()};
        Label[] borrowTimes = {returnController.getBorrowTime1(), returnController.getBorrowTime2(), returnController.getBorrowTime3(), returnController.getBorrowTime4(), returnController.getBorrowTime5()};
        Label[] dueTimes = {returnController.getDueTime1(), returnController.getDueTime2(), returnController.getDueTime3(), returnController.getDueTime4(), returnController.getDueTime5()};
        CheckBox[] checkBoxs = {returnController.getCheckBox1(), returnController.getCheckBox2(), returnController.getCheckBox3(), returnController.getCheckBox4(), returnController.getCheckBox5()};
        String[] bookIDs = {new String(), new String(), new String(), new String(), new String()};

        for (CheckBox chechbox:
                checkBoxs) {
            chechbox.setVisible(false);
        }
        for (Label label:
                bookNames) {
            label.setText("");
        }
        for (Label label:
                borrowTimes) {
            label.setText("");
        }
        for (Label label:
                dueTimes) {
            label.setText("");
        }

        int i = 0;

        while (borrow_info.next()){
            borrowTimes[i].setText(borrow_info.getString("borrow_time"));
            dueTimes[i].setText(borrow_info.getString("due_time"));
            bookIDs[i] = borrow_info.getString("book_id");
            checkBoxs[i++].setVisible(true);
        }
        i--;
        for (i=i; i >= 0; i--){
            ResultSet book_info = database.searchDatabase("select * from book_info where book_id='"+ bookIDs[i] + "'");
            if(book_info.next()){
                bookNames[i].setText(book_info.getString("book_name"));
                System.out.println("asdf");
            }

        }
    }


}
