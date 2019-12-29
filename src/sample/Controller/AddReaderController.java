package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Model.Reader;
import sample.Tool.JDBCDao;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class AddReaderController {
    @FXML
    private TextField readerIdTextField, readerNameTextField, passwordTextField;
    @FXML
    private Button yesButton, noButton;

    private Stage stage;

    private ManageReaderController manageReaderController;

    @FXML
    public void yes() {

        String query = "select * from reader where reader_id = '" + readerIdTextField.getText() + "'";
        Reader reader = JDBCDao.selectOne(query, Reader.class);
        if (reader != null) {
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("用户ID重复，请修改");
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
            return;
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `reader`(`reader_id`, `reader_name`, `borrowed_book`, `password`, `id_registration_time`, `id_due_time`) VALUES ( ");
        sql.append(" '").append(readerIdTextField.getText()).append("',");
        sql.append(" '").append(readerNameTextField.getText()).append("',");
        sql.append(" ").append(0).append(",");
        sql.append(" '").append(passwordTextField.getText()).append("',");
        sql.append(" '").append(LocalDateTime.now(ZoneId.of("UTC")).toString()).append("',");
        sql.append(" '").append(LocalDateTime.now(ZoneId.of("UTC")).toString()).append("'");
        sql.append(" )");
        JDBCDao.insertOrDeleteOrUpdate(sql.toString());
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
