package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Model.Book;
import sample.Model.FXMLClass;
import sample.Tool.JDBCDao;
import sample.Tool.JacksonUtil;

import java.io.IOException;
import java.util.List;

public class ManageBookController {

    @FXML
    private Button backButton, searchButton, addButton, changeButton, deleteButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane gridPaneChildren;

    private Scene backScene;
    private Stage stage;

    public void search() { //根据文本框内容查找书籍信息并保存
        gridPaneChildren.getChildren().clear();
        String search = searchTextField.getText();
        String sql = "select * from book_info where CONCAT(book_id,book_name,author,publisher) like '%" + search + "%'";
        List<Book> bookList = JDBCDao.select(sql, Book.class);
        System.out.println(JacksonUtil.toJson(bookList));
        if (bookList != null && bookList.size() > 0) {
            for (int index = 1; index <= bookList.size(); index++) {
                Label label = new Label();
                Book book = bookList.get(index - 1);
                Button delete = new Button("删除");
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        delete(book.getBookId());
                    }
                });
                Button update = new Button("修改");
                update.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            change(book.getBookId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                gridPaneChildren.addRow(index, new Label(book.getBookName()),
                        new Label(String.valueOf(book.getBookNum())), new Label(book.getLocation()),
                        new Label(book.getBookId()), delete, update);
            }
        } else {
            AnchorPane root = new AnchorPane();
            Label label = new Label();
            label.setText("未查询到相关书籍信息");
            label.setLayoutX(25);
            label.setLayoutY(20);
            root.getChildren().add(label);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 200, 50));
            stage.showAndWait();
        }
        System.out.println("search");
    }

    public void change(String bookId) throws IOException {//修改书籍信息

        String sql = "select * from book_info where book_id = '" + bookId + "'";
        Book book = JDBCDao.selectOne(sql, Book.class);

        FXMLClass changeBookView = new FXMLClass("/sample/View/Admin/changeBookView.fxml");
        Stage stage = new Stage();
        ChangeBookController changeBookController = changeBookView.getFxmlLoader().<ChangeBookController>getController();
        changeBookController.getBookNameTextField().setText(book.getBookName());
        changeBookController.getAuthorTextField().setText(book.getAuthor());
        changeBookController.getBookNumTextField().setText(String.valueOf(book.getBookNum()));
        changeBookController.getLocationTextField().setText(book.getLocation());
        changeBookController.getPublisherTextField().setText(book.getPublisher());
        changeBookController.getBookIdTextField().setText(bookId);
        changeBookController.setStage(stage);
        changeBookController.setManageBookController(this);
        stage.setScene(changeBookView.getScene());
        stage.showAndWait();
    }

    public void delete(String bookId) {//删除书籍信息
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
                String sql = "delete from book_info where book_id = '" + bookId + "'";
                JDBCDao.insertOrDeleteOrUpdate(sql);
                stage.close();
                search();
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


    public void add() throws IOException {//录入书籍
        System.out.println("add");
        FXMLClass addBookView = new FXMLClass("/sample/View/Admin/addBookView.fxml");
        Stage stage = new Stage();
        AddBookController addBookController = addBookView.getFxmlLoader().<AddBookController>getController();
        addBookController.setStage(stage);
        addBookController.setManageBookController(this);
        stage.setScene(addBookView.getScene());
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
