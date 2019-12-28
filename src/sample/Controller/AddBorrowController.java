package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBorrowController {

    @FXML
    private TextField readerNameTextField, bookNameTextField;
    @FXML
    private Button yesButton, noButton;

    private Stage stage;

    @FXML
    public void yes(){

        stage.close();
    }

    @FXML
    public void no(){
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
