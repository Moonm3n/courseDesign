package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ReaderController {

    @FXML
    private Button searchBookButton, returnBookButton;
    @FXML
    private ImageView background;

    private Stage stage;
    private Scene searchBookScene, returnBookScene;

    @FXML
    public void searchBook(){
        stage.setScene(searchBookScene);
    }
    @FXML
    public void returnBook(){
        stage.setScene(returnBookScene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getSearchBookScene(Scene scene) {
        return searchBookScene;
    }

    public void setSearchBookScene(Scene searchBookScene) {
        this.searchBookScene = searchBookScene;
    }

    public Scene getReturnBookScene() {
        return returnBookScene;
    }

    public void setReturnBookScene(Scene returnBookScene) {
        this.returnBookScene = returnBookScene;
    }

}
