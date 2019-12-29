package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Model.Book;
import sample.Model.BorrowInfo;
import sample.Model.Reader;
import sample.Tool.JDBCDao;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class AddBorrowController {

    @FXML
    private TextField readerIdTextField, bookIdTextField;
    @FXML
    private Button yesButton, noButton;

    private Stage stage;


    @FXML
    public void yes() {
        String text = null;
        String query = "select * from reader where reader_id = '" + readerIdTextField.getText() + "'";
        Reader reader = JDBCDao.selectOne(query, Reader.class);
        query = "select * from book_info where book_id = '" + bookIdTextField.getText() + "'";
        Book book = JDBCDao.selectOne(query, Book.class);
        query = "select * from borrow_info where book_id = '" + bookIdTextField.getText()
                + "' AND reader_id = '" + readerIdTextField.getText() + "' AND `status` = '1' ";
        BorrowInfo borrowInfo = JDBCDao.selectOne(query, BorrowInfo.class);

        if (book == null) {
            text = "图书ID错误，请检查";
        } else if (reader == null) {
            text = "读者ID错误，请检查";
        } else if (book.getBookNum() <= 0) {
            text = "图书已无库存，请检查";
        } else if (borrowInfo != null) {
            text = "不可重复借阅同一本书，请先归还";
        }
        if (text != null) {
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText(text);
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 220, 50));
            stage.showAndWait();
            return;
        }

        String updateSql = "UPDATE `reader` SET  `borrowed_book` = " + (reader.getBorrowedBook() + 1)
                + ", `id_due_time` = '" + LocalDateTime.now(ZoneId.of("UTC")).toString() + "' WHERE `reader_id` = '" + readerIdTextField.getText() + "'";
        JDBCDao.insertOrDeleteOrUpdate(updateSql);

        updateSql = "UPDATE `book_info` SET  `book_num` = " + (book.getBookNum() - 1) + " WHERE `book_id` = '" + bookIdTextField.getText() + "'";
        JDBCDao.insertOrDeleteOrUpdate(updateSql);

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `borrow_info`(`book_id`, `reader_id`, `status`, `borrow_time`, `due_time` ) VALUES ( ");
        sql.append(" '").append(bookIdTextField.getText()).append("',");
        sql.append(" '").append(readerIdTextField.getText()).append("',");
        sql.append(" '").append("1").append("',");
        sql.append(" '").append(LocalDateTime.now(ZoneId.of("UTC")).toString()).append("',");
        sql.append(" '").append(LocalDateTime.now(ZoneId.of("UTC")).toString()).append("'");
        sql.append(" )");
        JDBCDao.insertOrDeleteOrUpdate(sql.toString());
        stage.close();
    }

    @FXML
    public void no() {
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
