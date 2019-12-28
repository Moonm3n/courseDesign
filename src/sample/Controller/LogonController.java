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

import sample.Tool.Database;

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
    private Stage stage;



    @FXML
    public void logon() throws SQLException { //在数据库中检索是否存在符合的账户，是则切换页面，否则弹出提示信息

        Database readerDatebase = new Database("book_management");
        ResultSet reader = readerDatebase.searchDatabase("select * from reader");
        while(reader.next()){
            System.out.println(reader.getString("reader_id"));
            System.out.println(reader.getString("password"));
            if(reader.getString("reader_id").equals(usernameTextField.getText()) && reader.getString("password").equals(passwdTextField.getText()) ){
                System.out.println("sss");
                stage.setScene(readerScene);
                readerDatebase.close();
                return;
            }
        }


        Database adminDatabase = new Database("book_management");
        ResultSet admin = adminDatabase.searchDatabase("select * from administor");
        while(admin.next()){
            System.out.println(admin.getString("administor_id"));
            System.out.println(admin.getString("password"));
            if(admin.getString("administor_id").equals(usernameTextField.getText()) && admin.getString("password").equals(passwdTextField.getText()) ){
                System.out.println("sss");
                stage.setScene(adminScene);
                adminDatabase.close();
                return;
            }
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
}
