package components.piechart;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Piechart implements Initializable {
    public PieChart chart;
    private File file;
    private Scanner scanner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){
        file = new File("../src/res/csv/data.csv");

        try {
            scanner = new Scanner(new FileInputStream(file), "utf-8");
            scanner.useDelimiter(",");
            ArrayList<String[]> arrayList = new ArrayList<>();

            while (scanner.hasNext()){
                String user = scanner.next();
                String[] userData = user.split(" ");
                arrayList.add(userData);
            }
            //very important but i don't now why...just remember this :D
            ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
            for (int i = 0; i < arrayList.size() -1; i++) {
                String[] a = arrayList.get(i);
                // index a[0] = meno
                // index a[1] = iq
                int iq = Integer.parseInt(a[1]);
                data.add(new PieChart.Data(a[0], iq));
            }
            chart.setData(data);
            for (PieChart.Data a : chart.getData()) {
                a.nameProperty().bind(Bindings.concat(a.getName(), "IQ: ", a.pieValueProperty()));
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
