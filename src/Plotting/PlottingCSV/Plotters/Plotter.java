package Plotting.PlottingCSV.Plotters;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.io.BufferedWriter;
public class Plotter{

    //constructor
    public Plotter(){

    }

    // Plotting points for the equation y = 4x/5 + 5
    public void plot(int startingX, int endingX, String fileName) throws IOException {
        String csvFile = fileName + ".csv";
        try (BufferedWriter csv = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header of the CSV file
            csv.write("X,Y");
            csv.newLine();

            // Loop through the x-values and calculate corresponding y-values
            for (int i = startingX; i <= endingX; i++) {
                double y =  (4*i) / 5.0 + 5.0;  // Calculate the y value from the equation
                DecimalFormat decimal = new DecimalFormat("#.00");
                String formattedY = decimal.format(y);
                // Write the x and y values as a row in the CSV file
                csv.write(i + "," + formattedY);
                csv.newLine();
            }
        }
    }

    public void plot(int startingX, int endingX, int numPoints, String fileName) throws IOException {
        String csvFile = "data" + fileName + ".csv";
        try (BufferedWriter csv = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header of the CSV file
            csv.write("X,Y");
            csv.newLine();
    
            // Determine the step size based on the range direction
            double step = (double)(Math.abs(endingX) + Math.abs(startingX)) / (numPoints - 1);
    
            // Loop through numPoints to calculate the x and y values
            for (int i = 0; i < numPoints; i++) {
                double x = startingX + i * step;  // Calculate x
                double y = (4.0 * x) / 5.0 + 5.0; // Calculate y
                DecimalFormat decimal = new DecimalFormat("#.00");
                String formattedY = decimal.format(y);
                String formattedX = decimal.format(x);
                csv.write(formattedX + "," + formattedY);
                csv.newLine();
            }
        }
    }
    
}