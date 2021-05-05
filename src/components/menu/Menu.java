package components.menu;

import javafx.event.ActionEvent;
import sample.ViewControler;

public class Menu {
    public void barCharButton(ActionEvent actionEvent) {
        ViewControler.loadView("barchart");
    }

    public void pieChartButton(ActionEvent actionEvent) {
        ViewControler.loadView("piechart");
    }
}
