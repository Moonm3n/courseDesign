package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.*;
import sample.Model.FXMLClass;

import java.net.URL;

public class Main extends Application {
    private FXMLClass logonView;
    private FXMLClass adminView;
    private FXMLClass manageBookInfoView;
    private FXMLClass manageBorrowInfoView;
    private FXMLClass manageReaderInfoView;
    private FXMLClass readerView;
    private FXMLClass borrowView;
    private FXMLClass retrunView;
    private FXMLClass searchView;

    @Override
    public void init() throws Exception { //初始化时执行，只执行一次，加载各个FXML文件
        logonView = new FXMLClass("/sample/view/LogonView.fxml");

        adminView = new FXMLClass("/sample/view/admin/AdminView.fxml");
        manageBookInfoView = new FXMLClass("/sample/view/admin/ManageBookInfoView.fxml");
        manageBorrowInfoView = new FXMLClass("/sample/view/admin/ManageBorrowInfoView.fxml");
        manageReaderInfoView = new FXMLClass("/sample/view/admin/ManageReaderInfoView.fxml");

        readerView = new FXMLClass("/sample/view/reader/ReaderView.fxml");
        borrowView = new FXMLClass("/sample/view/reader/BorrowView.fxml");
        searchView = new FXMLClass("/sample/view/reader/SearchView.fxml");
        retrunView = new FXMLClass("/sample/view/reader/ReturnView.fxml");

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("电子科技大学图书管理系统");

        LogonController logonController = logonView.getFxmlLoader().<LogonController>getController();
        logonController.setStage(primaryStage);
        logonController.setAdminScene(adminView.getScene());
        logonController.setReaderScene(readerView.getScene());

        ReaderController readerController = readerView.getFxmlLoader().<ReaderController>getController();
        readerController.setStage(primaryStage);
        readerController.setSearchBookScene(searchView.getScene());
        readerController.setReturnBookScene(retrunView.getScene());

        searchView.getFxmlLoader().<SearchController>getController().setStage(primaryStage);
        searchView.getFxmlLoader().<SearchController>getController().setBackScene(readerView.getScene());
        retrunView.getFxmlLoader().<ReturnController>getController().setStage(primaryStage);
        retrunView.getFxmlLoader().<ReturnController>getController().setBackScene(readerView.getScene());

        AdminController adminController = adminView.getFxmlLoader().<AdminController>getController();
        adminController.setStage(primaryStage);
        adminController.setManageBookInfoScene(manageBookInfoView.getScene());
        adminController.setManageBorrowInfoScene(manageBorrowInfoView.getScene());
        adminController.setManageReaderInfoScene(manageReaderInfoView.getScene());

        manageBookInfoView.getFxmlLoader().<ManageBookController>getController().setStage(primaryStage);
        manageBookInfoView.getFxmlLoader().<ManageBookController>getController().setBackScene(adminView.getScene());
        manageBorrowInfoView.getFxmlLoader().<ManageBorrowController>getController().setStage(primaryStage);
        manageBorrowInfoView.getFxmlLoader().<ManageBorrowController>getController().setBackScene(adminView.getScene());
        manageReaderInfoView.getFxmlLoader().<ManageReaderController>getController().setStage(primaryStage);
        manageReaderInfoView.getFxmlLoader().<ManageReaderController>getController().setBackScene(adminView.getScene());




        primaryStage.setScene(logonView.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
