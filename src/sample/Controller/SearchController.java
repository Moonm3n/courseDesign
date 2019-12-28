package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchController {

    @FXML
    private Button backButton, borrowButton, searchButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label bookName1, bookName2, bookName3, bookName4, author1, author2, author3, author4, publisher1, publisher2, publisher3, publisher4;
    @FXML
    private Label location1, location2, location3, location4, bookNum1, bookNum2, bookNum3, bookNum4;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    private Scene backScene;
    private Stage stage;

    public void search(){
        System.out.println("search");

    }

    public void borrow(){
        System.out.println("borrow");
        AnchorPane root = new AnchorPane();
        Label label = new Label();
        label.setLayoutX(35);
        label.setLayoutY(20);


        Stage stage = new Stage();

        if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()){
            label.setText("借阅申请提交成功");
            root.getChildren().add(label);
            stage.setScene(new Scene(root, 200, 50));

            if(checkBox1.isSelected()){

                checkBox1.setSelected(false);
            }
            if(checkBox2.isSelected()){

                checkBox2.setSelected(false);
            }
            if(checkBox3.isSelected()){

                checkBox3.setSelected(false);
            }
            if(checkBox4.isSelected()){

                checkBox4.setSelected(false);
            }


            stage.showAndWait();

        }else{
            label.setText("请选择至少一本书籍");
            root.getChildren().add(label);
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }

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
