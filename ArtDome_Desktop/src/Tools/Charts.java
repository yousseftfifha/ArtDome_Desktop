package Tools;

import Services.OrdersCRUD;
import javax.swing.JFrame;
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
        JFreeChart chart1=ChartFactory.createPieChart(title,dataset);
        PiePlot plot1=(PiePlot) chart1.getPlot ();
        plot1.setStartAngle (0);
        plot1.setDirection (Rotation.CLOCKWISE);
        plot1.setForegroundAlpha (0.5f);
        return chart1;

    }


}

