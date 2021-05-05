package sample;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

public class ViewControler {
    public static HashMap<String, Parent> views = new HashMap<String, Parent>();
    public static AnchorPane view;


    public static void addView(String name, Parent parent){
        views.put(name, parent);
    }

    public static void loadView(String name){
        view.getChildren().clear();
        view.getChildren().add(views.get(name));
    }

}
