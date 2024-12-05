package Testers;
import java.io.IOException;

import Plotters.Plotter;
public class TestPlotter {
    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        try {
            plotter.plot(-100, 100); // Example: Plot points for x in the range [-10, 10]
            System.out.println("Data plotted successfully in data.csv");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
