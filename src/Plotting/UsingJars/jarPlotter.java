package UsingJars;

import org.apache.commons.math3.analysis.function.Sine;
import org.apache.commons.math3.analysis.function.Cosine;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class jarPlotter {
    
    public static void main(String[] args) {
        // Create mathematical function objects (e.g., sine and cosine)
        Sine sine = new Sine();
        Cosine cosine = new Cosine();
        
        // Create a dataset (XYSeries) for the chart
        XYSeries seriesSine = new XYSeries("Sine Wave");
        XYSeries seriesCosine = new XYSeries("Cosine Wave");

        // Generate data points for the sine wave and cosine wave
        for (double x = 0; x <= 2 * Math.PI; x += 0.1) {
            seriesSine.add(x, sine.value(x));
            seriesCosine.add(x, cosine.value(x));
        }

        // Create a dataset for the chart
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesSine);
        dataset.addSeries(seriesCosine);

        // Create a chart using the dataset
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Sine and Cosine Waves",  // Title
            "X",                      // X-axis label
            "Y",                      // Y-axis label
            dataset                  // Dataset
        );

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        
        // Set up the JFrame
        JFrame frame = new JFrame("Mathematical Plotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
