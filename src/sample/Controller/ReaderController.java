package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Model.FXMLClass;
import sample.Tool.Database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ReaderController {

    @FXML
    private Button searchBookButton, returnBookButton;
    @FXML
    private ImageView background;

    private Stage stage;
    private Scene searchBookScene, returnBookScene;
    private FXMLClass returnView, searchView;
    private String reader_id;

    @FXML
    public void searchBook(){
        searchView.getFxmlLoader().<SearchController>getController().clear();

        stage.setScene(searchBookScene);
    }
    @FXML
    public void returnBook() throws SQLException {
        Database database = new Database("book_management");
        ResultSet borrow_info = database.searchDatabase("select * from borrow_info where reader_id=" + reader_id+" and status='1'");
        ReturnController returnController = returnView.getFxmlLoader().<ReturnController>getController();

        Label[] bookNames = {returnController.getBookName1(), returnController.getBookName2(), returnController.getBookName3(), returnController.getBookName4(), returnController.getBookName5()};
        Label[] borrowTimes = {returnController.getBorrowTime1(), returnController.getBorrowTime2(), returnController.getBorrowTime3(), returnController.getBorrowTime4(), returnController.getBorrowTime5()};
        Label[] dueTimes = {returnController.getDueTime1(), returnController.getDueTime2(), returnController.getDueTime3(), returnController.getDueTime4(), returnController.getDueTime5()};
        CheckBox[] checkBoxs = {returnController.getCheckBox1(), returnController.getCheckBox2(), returnController.getCheckBox3(), returnController.getCheckBox4(), returnController.getCheckBox5()};
        String[] bookIDs = {new String(), new String(), new String(), new String(), new String()};

        for (CheckBox chechbox:
             checkBoxs) {
            chechbox.setVisible(false);
        }
        for (Label label:
             bookNames) {
            label.setText("");
        }
        for (Label label:
                borrowTimes) {
            label.setText("");
        }
        for (Label label:
                dueTimes) {
            label.setText("");
        }

        int i = 0;

        while (borrow_info.next()){
            borrowTimes[i].setText(borrow_info.getString("borrow_time"));
            dueTimes[i].setText(borrow_info.getString("due_time"));
            bookIDs[i] = borrow_info.getString("book_id");
            checkBoxs[i++].setVisible(true);
        }
        i--;
        for (i=i; i >= 0; i--){
            ResultSet book_info = database.searchDatabase("select * from book_info where book_id='"+ bookIDs[i] + "'");
            if(book_info.next()){
                bookNames[i].setText(book_info.getString("book_name"));
                System.out.println("asdf");
            }

        }

        returnController.setBook_id(bookIDs);

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

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }

    public FXMLClass getReturnView() {
        return returnView;
    }

    public void setReturnView(FXMLClass returnView) {
        this.returnView = returnView;
    }

    public FXMLClass getSearchView() {
        return searchView;
    }

    public void setSearchView(FXMLClass searchView) {
        this.searchView = searchView;
    }
}
