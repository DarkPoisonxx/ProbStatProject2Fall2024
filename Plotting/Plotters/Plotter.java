package Plotters;
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
                String formattedy = decimal.format(y);
                // Write the x and y values as a row in the CSV file
                csv.write(i + "," + formattedy);
                csv.newLine();
            }
        }
    }

    public void plot(int startingX, int endingX, int numPoints) throws IOException {
        String csvFile = "data.csv";
        try (BufferedWriter csv = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header of the CSV file
            csv.write("X,Y");
            csv.newLine();

            // Calculate the step size to divide the range into numPoints
            double step = (double)(endingX - startingX) / (numPoints - 1);

            // Loop through the x-values and calculate corresponding y-values
            for (int i = 0; i < numPoints; i++) {
                int x = (int)(startingX + i * step); // Calculate the x value for each point
                double y = (4.0 * x) / 5.0 + 5.0;   // Calculate the y value from the equation
                // Write the x and y values as a row in the CSV file
                csv.write(x + "," + y);
                csv.newLine();
            }
        }
    }


    
} 