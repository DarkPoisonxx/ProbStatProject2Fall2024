package Testers;
import java.io.File;
import java.io.IOException;

import Plotters.Salter;

public class TestSalter {
    public static void main(String[] args) throws IOException {
        File csvFile = new File("data1.csv");
        Salter salter = new Salter();
        try{
        salter.Salt(csvFile, 39, "3");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        //salted1.csv is salted with 76 from data1.csv
        //salted2.csv is salted with 27 from data1.csv
        //salted3.csv is salted with 39 from data1.csv
    }
}
