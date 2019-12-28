package sample.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class FXMLClass<T> {
    private URL location;
    private FXMLLoader fxmlLoader;
    private Parent root;
    private Scene scene;
    public T controller;

    /*
    URL location = getClass().getResource("/sample/view/logonView.fxml");
    FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.getResources();
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    */

    public FXMLClass(String path) throws IOException {
        location = getClass().getResource(path);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.getResources();
        root = fxmlLoader.load();
        scene = new Scene(root);
        controller = fxmlLoader.<T>getController();
    }

    public void setLocation(String path) {
        location = getClass().getResource(path);
    }

    public URL getLocation() {
        return location;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public Parent getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

}
