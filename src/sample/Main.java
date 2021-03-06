package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("CSV_Application");
        stage.setScene(new Scene(root));
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
