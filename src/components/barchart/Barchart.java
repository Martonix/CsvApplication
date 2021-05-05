package components.barchart;

import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Barchart implements Initializable {

    public StackedBarChart chart;
    public NumberAxis yAxis;
    private File file;
    private Scanner scanner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yAxis.setLabel("IQ");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(20);
        yAxis.setUpperBound(180);
        yAxis.setTickUnit(1);
        loadData();
    }

    private void loadData(){
        file = new File("../src/res/csv/data.csv");

        try{
            scanner = new Scanner(new FileInputStream(file), "utf-8");
            scanner.useDelimiter(",");
            ArrayList<String[]> arrayList = new ArrayList<>();

            while (scanner.hasNext()){
                String user = scanner.next();
                String[] userData = user.split(" ");
                arrayList.add(userData);
            }

            for (int i = 0; i < arrayList.size() -1; i++) {
                String[] a = arrayList.get(i);

                XYChart.Series data = new XYChart.Series();
                data.setName(a[0]);
                int iq = Integer.parseInt(a[1]);
                data.getData().add(new XYChart.Data(a[0], iq));

                chart.getData().add(data);

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}
