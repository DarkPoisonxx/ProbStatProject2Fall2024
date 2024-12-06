package Testers;

import java.io.File;
import java.io.IOException;

import Plotters.Smoother;

public class TestSmoother {
    public static void main(String[] args) throws IOException {
        // Files to test with
        File csvFile1 = new File("salted5.csv");
        // Create a Smoother object
        Smoother smoother = new Smoother();

        try {
            // Smooth the first CSV file
            smoother.smooth(csvFile1, "5");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Expected output files:
        // smoothed1.csv - smoothed version of data1.csv
        // smoothed2.csv - smoothed version of data2.csv
    }
}
