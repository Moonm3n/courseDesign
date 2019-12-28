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

public class ManageReaderController {

    @FXML
    private Button backButton, searchButton, addButton, changeButton, deleteButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;
    @FXML
    private Label name1, name2, name3, grade1, grade2, grade3, borrow1, borrow2, borrow3;

    private Scene backScene;
    private Stage stage;
    public void search(){ //根据文本框内容查找用户信息并保存
        searchTextField.getText();
        System.out.println("search");
    }

    public void change(){//修改用户信息
        System.out.println("change");
        int i = 0;
        if(checkBox1.isSelected())
            i++;
        if(checkBox2.isSelected())
            i++;
        if(checkBox3.isSelected())
            i++;
        if(i == 1){

        }
        else{
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("请选择一条信息进行修改");
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }
    }

    public void delete(){//删除用户信息
        System.out.println("delete");

        if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected()){
            System.out.println("delete");
            Stage stage = new Stage();
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("确定要删除该条信息？");
            label.setLayoutX(35);
            label.setLayoutY(20);
            Button yesButton = new Button();
            yesButton.setText("确认");
            yesButton.setLayoutX(50);
            yesButton.setLayoutY(50);
            Button noButton = new Button();
            noButton.setText("取消");
            noButton.setLayoutX(100);
            noButton.setLayoutY(50);
            yesButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(checkBox1.isSelected()){

                        checkBox1.setSelected(false);
                    }
                    if(checkBox2.isSelected()){

                        checkBox2.setSelected(false);
                    }
                    if(checkBox3.isSelected()){

                        checkBox3.setSelected(false);
                    }

                    stage.close();
                }
            });
            noButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {


                    stage.close();
                }
            });
            root.getChildren().addAll(label, yesButton, noButton);
            stage.setScene(new Scene(root, 200, 100));
            stage.showAndWait();
        }
        else{
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("请选择至少一条信息");
            label.setLayoutX(35);
            label.setLayoutY(20);
            root.getChildren().add(label);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }
    }

    public void add(){//录入用户信息
        System.out.println("add");
    }
    public void back(){//返回按钮
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
