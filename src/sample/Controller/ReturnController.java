package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReturnController {

    @FXML
    private Button backButton, returnButton;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;
    @FXML
    private Label bookName1, bookName2, bookName3, borrowTime1, borrowTime2, borrowTime3, dueTime1, dueTime2, dueTime3;

    private Scene backScene;
    private Stage stage;


    public void returnBook(){
        System.out.println("borrow");
        AnchorPane root = new AnchorPane();
        Label label = new Label();
        label.setLayoutX(35);
        label.setLayoutY(20);
        Stage stage = new Stage();

        if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected()){
            label.setText("归还申请提交成功");
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
