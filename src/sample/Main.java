package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sample.fxml"));
        primaryStage.getIcons().add(new Image(getResource("../resources/icon.png").toExternalForm()));
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 370, 380));
        primaryStage.show();
    }

    private URL getResource(String name) {
        return getClass().getResource(name);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
