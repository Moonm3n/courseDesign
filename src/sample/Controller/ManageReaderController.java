package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Model.Book;
import sample.Model.FXMLClass;
import sample.Model.Reader;
import sample.Tool.JDBCDao;
import sample.Tool.JacksonUtil;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ManageReaderController {

    @FXML
    private Button backButton, searchButton, addButton, changeButton, deleteButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private GridPane gridPaneChildren;
    private Scene backScene;
    private Stage stage;

    public void search() { //根据文本框内容查找用户信息并保存
        gridPaneChildren.getChildren().clear();
        String search = searchTextField.getText();
        String sql = "select * from reader where CONCAT(reader_name,reader_id) like '%" + search + "%'";
        List<Reader> readerList = JDBCDao.select(sql, Reader.class);
        System.out.println(JacksonUtil.toJson(readerList));
        if (readerList != null && readerList.size() > 0) {
            for (int index = 1; index <= readerList.size(); index++) {
                Label label = new Label();
                Reader reader = readerList.get(index - 1);
                Button delete = new Button("删除");
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        delete(reader.getReaderId());
                    }
                });
                Button update = new Button("修改");
                update.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        change(reader.getReaderId());
                    }
                });

                gridPaneChildren.addRow(index, new Label(reader.getReaderName()),
                        new Label(String.valueOf(reader.getBorrowedBook())),
                        new Label(reader.getIdRegistrationTime().toString()), delete, update);
            }
        } else {
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("未查询到相关读者信息");
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }
        System.out.println("search");
    }

    public void change(String readerId) {//修改用户信息
        System.out.println("change");
        String sql = "select * from reader where reader_id = '" + readerId + "'";
        Reader reader = JDBCDao.selectOne(sql, Reader.class);
        FXMLClass changeReaderView = null;
        try {
            changeReaderView = new FXMLClass("/sample/View/Admin/changeReaderView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        ChangeReaderController changeReaderController = changeReaderView.getFxmlLoader().<ChangeReaderController>getController();
        changeReaderController.getReaderIdTextField().setText(reader.getReaderId());
        changeReaderController.getReaderNameTextField().setText(reader.getReaderName());
        changeReaderController.getPasswordTextField().setText(reader.getPassword());

        changeReaderController.setStage(stage);
        changeReaderController.setManageReaderController(this);
        stage.setScene(changeReaderView.getScene());
        stage.showAndWait();
    }

    public void delete(String readerId) {//删除用户信息
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
        yesButton.setOnAction(event -> {
            String sql = "delete from reader where reader_id = '" + readerId + "'";
            JDBCDao.insertOrDeleteOrUpdate(sql);
            search();
            stage.close();
        });
        noButton.setOnAction(event -> stage.close());
        root.getChildren().addAll(label, yesButton, noButton);
        stage.setScene(new Scene(root, 200, 100));
        stage.showAndWait();

    }

    public void add() {
        FXMLClass addReaderView = null;
        try {
            addReaderView = new FXMLClass("/sample/View/Admin/addReaderView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        AddReaderController addReaderController = addReaderView.getFxmlLoader().<AddReaderController>getController();
        addReaderController.setStage(stage);
        addReaderController.setManageReaderController(this);
        stage.setScene(addReaderView.getScene());
        stage.showAndWait();
    }

    public void back() {//返回按钮
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
