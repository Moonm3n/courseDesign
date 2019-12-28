package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private Button bookInfoButton, borrowInfoButton, readerInfoButton;

    private Stage stage;
    private Scene manageBookInfoScene, manageBorrowInfoScene, manageReaderInfoScene;


    @FXML
    public void bookInfo(){
        stage.setScene(manageBookInfoScene);
    }

    @FXML
    public void borrowInfo(){
        stage.setScene(manageBorrowInfoScene);
    }


    @FXML
    public void readerInfo(){
        stage.setScene(manageReaderInfoScene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getManageBookInfoScene() {
        return manageBookInfoScene;
    }

    public void setManageBookInfoScene(Scene manageBookInfoScene) {
        this.manageBookInfoScene = manageBookInfoScene;
    }

    public Scene getManageBorrowInfoScene() {
        return manageBorrowInfoScene;
    }

    public void setManageBorrowInfoScene(Scene manageBorrowInfoScene) {
        this.manageBorrowInfoScene = manageBorrowInfoScene;
    }

    public Scene getManageReaderInfoScene() {
        return manageReaderInfoScene;
    }

    public void setManageReaderInfoScene(Scene manageReaderInfoScene) {
        this.manageReaderInfoScene = manageReaderInfoScene;
    }
}
