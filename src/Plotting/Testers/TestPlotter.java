package Testers;
import java.io.IOException;

import Plotters.Plotter;
public class TestPlotter {
    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        try {
            plotter.plot(20, 176,10, "4"); // Example: Plot points for x in the range [-10, 10]
            System.out.println("Data plotted successfully in csv");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        //data1.csv -100,140
        //data2.csv 406,575
        //data3.csv -100,150 using 30 points
        //data4.csv 20, 176 using 10 points
    }
}
