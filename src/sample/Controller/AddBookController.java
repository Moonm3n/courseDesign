package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Model.Book;
import sample.Tool.JDBCDao;

public class AddBookController {
    @FXML
    private TextField bookNameTextField, authorTextField, bookNumTextField, publisherTextField, locationTextField, bookIdTextField;
    @FXML
    private Button yesButton, noButton;

    private Stage stage;

    private ManageBookController manageBookController;

    @FXML
    public void yes() {
        String query = "select * from book_info where book_id = '" + bookIdTextField.getText() + "'";
        Book book = JDBCDao.selectOne(query, Book.class);
        if (book != null) {
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("图书ID重复，请修改");
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
            return;
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `book_info`(`book_id`, `book_name`, `author`, `publisher`, `location`, `book_num`) VALUES ( ");
        sql.append(" '").append(bookIdTextField.getText()).append("',");
        sql.append(" '").append(bookNameTextField.getText()).append("',");
        sql.append(" '").append(authorTextField.getText()).append("',");
        sql.append(" '").append(publisherTextField.getText()).append("',");
        sql.append(" '").append(locationTextField.getText()).append("',");
        sql.append(" ").append(bookNumTextField.getText());
        sql.append(" )");
        JDBCDao.insertOrDeleteOrUpdate(sql.toString());
        System.out.println(bookIdTextField.getText());
        stage.close();
        manageBookController.search();
    }

    @FXML
    public void no() {
        stage.close();
    }

    public TextField getBookNameTextField() {
        return bookNameTextField;
    }

    public TextField getAuthorTextField() {
        return authorTextField;
    }

    public TextField getBookNumTextField() {
        return bookNumTextField;
    }

    public TextField getPublisherTextField() {
        return publisherTextField;
    }

    public TextField getLocationTextField() {
        return locationTextField;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ManageBookController getManageBookController() {
        return manageBookController;
    }

    public void setManageBookController(ManageBookController manageBookController) {
        this.manageBookController = manageBookController;
    }
}
