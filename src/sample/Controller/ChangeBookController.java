package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Tool.JDBCDao;

public class ChangeBookController {
    @FXML
    private TextField bookNameTextField, authorTextField, bookNumTextField, publisherTextField, locationTextField, bookIdTextField;
    @FXML
    private Button yesButton, noButton;

    public TextField getBookIdTextField() {
        return bookIdTextField;
    }

    public void setBookIdTextField(TextField bookIdTextField) {
        this.bookIdTextField = bookIdTextField;
    }

    private Stage stage;

    private ManageBookController manageBookController;

    @FXML
    public void yes() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE book_info SET ");
        sql.append(" `book_name` = '").append(bookNameTextField.getText()).append("',");
        sql.append(" `author` = '").append(authorTextField.getText()).append("',");
        sql.append(" `publisher` = '").append(publisherTextField.getText()).append("',");
        sql.append(" `location` = '").append(locationTextField.getText()).append("',");
        sql.append(" `book_num` = ").append(bookNumTextField.getText());
        sql.append(" where `book_id` = '").append(bookIdTextField.getText()).append("'");
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
