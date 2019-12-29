package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Tool.JDBCDao;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ChangeReaderController {
    @FXML
    private TextField readerIdTextField, readerNameTextField, passwordTextField;
    @FXML
    private Button yesButton, noButton;

    private Stage stage;

    private ManageReaderController manageReaderController;

    @FXML
    public void yes() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE reader SET ");
        sql.append(" `reader_name` = '").append(readerNameTextField.getText()).append("',");
        sql.append(" `password` = '").append(passwordTextField.getText()).append("',");
        sql.append(" `id_due_time` = '").append(LocalDateTime.now(ZoneId.of("UTC")).toString()).append("'");
        sql.append(" where `reader_id` = '").append(readerIdTextField.getText()).append("'");
        JDBCDao.insertOrDeleteOrUpdate(sql.toString());
        System.out.println(readerIdTextField.getText());
        stage.close();
        manageReaderController.search();
    }

    @FXML
    public void no() {
        stage.close();
    }

    public TextField getReaderIdTextField() {
        return readerIdTextField;
    }

    public void setReaderIdTextField(TextField readerIdTextField) {
        this.readerIdTextField = readerIdTextField;
    }

    public TextField getReaderNameTextField() {
        return readerNameTextField;
    }

    public void setReaderNameTextField(TextField readerNameTextField) {
        this.readerNameTextField = readerNameTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public Button getYesButton() {
        return yesButton;
    }

    public void setYesButton(Button yesButton) {
        this.yesButton = yesButton;
    }

    public Button getNoButton() {
        return noButton;
    }

    public void setNoButton(Button noButton) {
        this.noButton = noButton;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ManageReaderController getManageReaderController() {
        return manageReaderController;
    }

    public void setManageReaderController(ManageReaderController manageReaderController) {
        this.manageReaderController = manageReaderController;
    }
}
