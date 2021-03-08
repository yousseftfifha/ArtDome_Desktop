package Tools;

import Services.OrdersCRUD;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import java.sql.SQLException;
import java.util.Locale;
import javax.swing.*;
import java.sql.SQLException;

/**
 * @author tfifha youssef
 */
public class Charts extends JFrame {
    public Charts(String appTitle,String chartTitle) throws Exception
    {
        PieDataset dataset= createDataset();
        JFreeChart chart=createChart(dataset,chartTitle);
        ChartPanel chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
    }


    private PieDataset createDataset() throws SQLException
    {
        OrdersCRUD of=new OrdersCRUD ();
        DefaultPieDataset rslt=new DefaultPieDataset();
        rslt.setValue("Confirmed",of.getCount("confirmed"));
        rslt.setValue("Pending",of.getCount("pending"));
        rslt.setValue("Cancelled",of.getCount("cancelled"));
        return rslt;
    }
    private JFreeChart createChart(PieDataset dataset, String title)
    {
        JFreeChart chart= ChartFactory.createPieChart3D(title, dataset,true,true,false);
        PiePlot3D plot=(PiePlot3D)chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }


}

