package Plotting.UsingJars;

import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.analysis.function.Cos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.util.Random;

public class jarPlotter {

    private double leftValue, rightValue;
    private int numPoints;
    private double[] yValuesSine, yValuesCosine;  // To store the Y-values of sine and cosine

    // Non-static method to plot a graph and store values for salting
    public XYSeriesCollection plotBase(double leftValue, double rightValue, int numPoints) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.numPoints = numPoints;

        // Create mathematical function objects (e.g., sine and cosine)
        Sin sin = new Sin();
        Cos cos = new Cos();

        // Create a dataset (XYSeries) for the chart
        XYSeries seriesSine = new XYSeries("Sine Wave");
        XYSeries seriesCosine = new XYSeries("Cosine Wave");

        // Initialize arrays to store Y-values of the sine and cosine
        yValuesSine = new double[numPoints];
        yValuesCosine = new double[numPoints];

        // Generate data points for the sine wave and cosine wave
        double stepSize = (rightValue - leftValue) / (numPoints - 1);  // Calculate step size
        for (int i = 0; i < numPoints; i++) {
            double x = leftValue + i * stepSize;
            yValuesSine[i] = sin.value(x);
            yValuesCosine[i] = cos.value(x);

            seriesSine.add(x, yValuesSine[i]);
            seriesCosine.add(x, yValuesCosine[i]);
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

        return dataset; // Return the dataset for salting
    }

    
    // Method to apply salt to the sine and cosine data
    public void salt(int saltValue) {
        // Create datasets for the salted sine and cosine waves
        XYSeries seriesSineSalted = new XYSeries("Salted Sine Wave");
        XYSeries seriesCosineSalted = new XYSeries("Salted Cosine Wave");

        Random rnd = new Random(); // Random generator for salt

        // Apply salt to the sine and cosine values
        for (int i = 0; i < numPoints; i++) {
            double x = leftValue + i * (rightValue - leftValue) / (numPoints - 1);  // Calculate x

            // Apply random salt to Y values
            int rndNum = rnd.nextBoolean() ? 1 : -1;  // Randomly choose whether to add or subtract salt
            yValuesSine[i] += rndNum * rnd.nextInt(saltValue + 1);  // Apply salt to sine Y-value
            yValuesCosine[i] += rndNum * rnd.nextInt(saltValue + 1); // Apply salt to cosine Y-value

            // Add the salted data points to the series
            seriesSineSalted.add(x, yValuesSine[i]);
            seriesCosineSalted.add(x, yValuesCosine[i]);
        }

        // Create a dataset for the salted data
        XYSeriesCollection saltedDataset = new XYSeriesCollection();
        saltedDataset.addSeries(seriesSineSalted);
        saltedDataset.addSeries(seriesCosineSalted);

        // Create a chart using the salted dataset
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Salted Sine and Cosine Waves",  // Title
            "X",                             // X-axis label
            "Y",                             // Y-axis label
            saltedDataset                   // Salted Dataset
        );

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        // Set up the JFrame
        JFrame frame = new JFrame("Salted Plotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Smoothing method without parameters, modifying the class-level yValues arrays
    public void smooth() {
        // Apply smoothing to the sine wave
        for (int i = 1; i < yValuesSine.length - 1; i++) {
            double sum = 0;
            int rowsUsed = 0;
            // Sliding window: go from half the row count before to half the row count after
            for (int j = Math.max(0, i - 1); j <= Math.min(yValuesSine.length - 1, i + 1); j++) {
                sum += yValuesSine[j];  // Sum the values within the window
                rowsUsed++;
            }
            // Assign the average of the windowed values to the current yValue
            yValuesSine[i] = sum / rowsUsed;
        }

        // Apply smoothing to the cosine wave
        for (int i = 1; i < yValuesCosine.length - 1; i++) {
            double sum = 0;
            int rowsUsed = 0;
            // Sliding window: go from half the row count before to half the row count after
            for (int j = Math.max(0, i - 1); j <= Math.min(yValuesCosine.length - 1, i + 1); j++) {
                sum += yValuesCosine[j];  // Sum the values within the window
                rowsUsed++;
            }
            // Assign the average of the windowed values to the current yValue
            yValuesCosine[i] = sum / rowsUsed;
        }

        // After smoothing, create a new dataset and display the chart with the smoothed data
        XYSeries smoothedSine = new XYSeries("Smoothed Sine Wave");
        XYSeries smoothedCosine = new XYSeries("Smoothed Cosine Wave");

        // Rebuild the series for smoothed sine and cosine waves
        for (int i = 0; i < numPoints; i++) {
            double x = leftValue + i * (rightValue - leftValue) / (numPoints - 1);  // Calculate x
            smoothedSine.add(x, yValuesSine[i]);
            smoothedCosine.add(x, yValuesCosine[i]);
        }

        // Create a dataset for the smoothed data
        XYSeriesCollection smoothedDataset = new XYSeriesCollection();
        smoothedDataset.addSeries(smoothedSine);
        smoothedDataset.addSeries(smoothedCosine);

        // Create a chart using the smoothed dataset
        JFreeChart smoothedChart = ChartFactory.createXYLineChart(
            "Smoothed Sine and Cosine Waves",  // Title
            "X",                              // X-axis label
            "Y",                              // Y-axis label
            smoothedDataset                   // Smoothed Dataset
        );

        // Create a panel to display the chart
        ChartPanel smoothedChartPanel = new ChartPanel(smoothedChart);
        smoothedChartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        // Set up the JFrame
        JFrame smoothedFrame = new JFrame("Smoothed Plotter");
        smoothedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        smoothedFrame.getContentPane().add(smoothedChartPanel);
        smoothedFrame.pack();
        smoothedFrame.setVisible(true);
    }
}
