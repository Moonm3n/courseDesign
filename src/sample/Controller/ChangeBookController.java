package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeBookController {
    @FXML
    private TextField bookNameTextField, authorTextField, bookNumTextField, publisherTextField, locationTextField;
    @FXML
    private Button yesButton, noButton;

    @FXML
    public void yes(){

    }

    @FXML
    public void no(){

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
}
