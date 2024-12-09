package Plotting.PlottingCSV.Testers;

import java.io.File;
import java.io.IOException;

import Plotting.PlottingCSV.Plotters.Smoother;

public class TestSmoother {
    public static void main(String[] args) throws IOException {
        // Files to test with
        File csvFile1 = new File("smoothed5.csv");
        // Create a Smoother object
        Smoother smoother = new Smoother();

        try {
            // Smooth the first CSV file
            smoother.smooth(csvFile1, "6");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Expected output files:
        // smoothed1.csv - smoothed version of data1.csv or salted1 with 76 salt value
        // smoothed2.csv - smoothed version of data1.csv or salted2 with 27 salt value
        // smoothed3.csv - smoothed version of data1.csv or salted3 with 39 salt value
        // smoothed4.csv - smoothed version is smoothed3.csv smoothed again
        //smoothed5.csv - smoothed version of smoothed4.csv smoothed again
        //smoothed6.csv - smoothed version of smoothed5.csv smoothed again

    }
}
