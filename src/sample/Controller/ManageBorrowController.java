package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Model.FXMLClass;

import java.io.IOException;

public class ManageBorrowController {
    @FXML
    private Button backButton, addBorrowButton, addReturnButton;

    private Scene backScene;
    private Stage stage;

    public void addBorrow() throws IOException {
        FXMLClass addBorrowView = new FXMLClass("/sample/View/Admin/addBorrowView.fxml");
        Stage stage = new Stage();
        stage.setScene(addBorrowView.getScene());
        addBorrowView.getFxmlLoader().<AddBorrowController>getController().setStage(stage);
        stage.showAndWait();
    }

    public void addReturn() throws IOException {
        FXMLClass addReturnView = new FXMLClass("/sample/View/Admin/addReturnView.fxml");
        Stage stage = new Stage();
        stage.setScene(addReturnView.getScene());
        addReturnView.getFxmlLoader().<AddReturnController>getController().setStage(stage);
        stage.showAndWait();

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
}
