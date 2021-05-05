package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public AnchorPane view;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewControler.view = view;
        try{
            ViewControler.addView("barchart", FXMLLoader.load(getClass().getResource("../components/barchart/barchart.fxml")));
            ViewControler.addView("piechart", FXMLLoader.load(getClass().getResource("../components/piechart/piechart.fxml")));
            ViewControler.loadView("barchart");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
