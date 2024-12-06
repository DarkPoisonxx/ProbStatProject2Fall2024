package Testers;
import java.io.IOException;

import Plotters.Plotter;
public class TestPlotter {
    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        try {
            plotter.plot(406, 575, "data2"); // Example: Plot points for x in the range [-10, 10]
            System.out.println("Data plotted successfully in csv");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        //data1.csv -100,100
        //data2.csv 406,575
    }
}
