package Tools;

import Services.OrdersService;
import javax.swing.JFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * @author tfifha youssef
 */
public class Charts extends JFrame {
    Stage dialogStage = new Stage ();
    Scene scene;
    public Charts(String appTitle,String chartTitle) throws Exception
    {

        PieChart piechart = new PieChart();
        piechart.setData(getChartData());
        piechart.setLegendSide(Side.LEFT);
        piechart.setTitle("Status of Orders");
        piechart.setClockwise(false);
        StackPane root = new StackPane();
        root.getChildren().add(piechart);
        Scene scene = new Scene(root,800,600);
        dialogStage.setScene(scene);
        dialogStage.setTitle("PieChart :Status of Orders");
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    e -> {
                        double total = 0;
                        for (PieChart.Data d : piechart.getData()) {
                            total += d.getPieValue();
                        }
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        String text = String.format("%.1f%%", 100*data.getPieValue()/total) ;
                        caption.setText(text);
                    }
            );
        }
        dialogStage.show();


    }
    //The method sets the data to the pie-chart.
    private ObservableList<PieChart.Data> getChartData() throws SQLException {
        OrdersService ordersService =new OrdersService ();

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.addAll(new PieChart.Data("Confirmed", ordersService.getCount ("confirmed")),
                new PieChart.Data("Cancelled", ordersService.getCount ("cancelled")),
                new PieChart.Data("Pending", ordersService.getCount ("pending"))

        );

        return list;
    }
}



