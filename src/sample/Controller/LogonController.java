package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import sample.Model.Admin;
import sample.Model.FXMLClass;
import sample.Model.Reader;
import sample.Tool.Database;
import sample.Tool.JDBCDao;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LogonController {

    @FXML
    private TextField usernameTextField, passwdTextField;
    @FXML
    private Button logonButton;
    @FXML
    private ImageView background, words;

    private Scene adminScene, readerScene;
    private FXMLClass searchView, returnView, readerView;
    private Stage stage;



    @FXML
    public void logon() throws SQLException { //在数据库中检索是否存在符合的账户，是则切换页面，否则弹出提示信息

        Reader reader = JDBCDao.selectOne("select * from reader where reader_id = '" + usernameTextField.getText() + "'", Reader.class);
        if (reader != null) {
            System.out.println(reader.getReaderId());
            System.out.println(reader.getPassword());
            if (reader.getPassword().equals(passwdTextField.getText())) {
                System.out.println("sss");
                stage.setScene(readerScene);
                return;
            }
        }


        Admin admin1 = JDBCDao.selectOne("select * from administor where administor_id = '" + usernameTextField.getText() + "'", Admin.class);
        if (admin1 != null && admin1.getPassword().equals(passwdTextField.getText())) {
            System.out.println("admin login success");
            stage.setScene(adminScene);
            return;
        }

        AnchorPane root = new AnchorPane();
        Label label = new Label();
        label.setText("账号或密码错误");
        label.setLayoutX(25);
        label.setLayoutY(20);
        root.getChildren().add(label);

        Stage stage = new Stage();
        stage.setScene(new Scene(root, 200, 50));
        stage.showAndWait();


    }

    public Scene getAdminScene() {
        return adminScene;
    }

    public void setAdminScene(Scene adminScene) {
        this.adminScene = adminScene;
    }

    public Scene getReaderScene() {
        return readerScene;
    }

    public void setReaderScene(Scene readerScene) {
        this.readerScene = readerScene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public FXMLClass getSearchView() {
        return searchView;
    }

    public void setSearchView(FXMLClass searchView) {
        this.searchView = searchView;
    }

    public FXMLClass getReturnView() {
        return returnView;
    }

    public void setReturnView(FXMLClass returnView) {
        this.returnView = returnView;
    }

    public FXMLClass getReaderView() {
        return readerView;
    }

    public void setReaderView(FXMLClass readerView) {
        this.readerView = readerView;
    }
}
