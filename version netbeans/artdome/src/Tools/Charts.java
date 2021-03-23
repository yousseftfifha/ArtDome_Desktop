package Tools;

import Services.OrdersCRUD;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.PieDatasetHandler;
import org.jfree.util.Rotation;

import java.sql.SQLException;
import java.util.Locale;
import javax.swing.*;
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
        OrdersCRUD ordersCRUD=new OrdersCRUD ();

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.addAll(new PieChart.Data("Confirmed", ordersCRUD.getCount ("confirmed")),
                new PieChart.Data("Cancelled", ordersCRUD.getCount ("cancelled")),
                new PieChart.Data("Pending", ordersCRUD.getCount ("pending"))

        );

        return list;
    }
}



