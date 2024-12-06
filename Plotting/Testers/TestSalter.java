package Testers;
import java.io.File;
import java.io.IOException;

import Plotters.Salter;

public class TestSalter {
    public static void main(String[] args) throws IOException {
        File csvFile = new File("data2.csv");
        Salter salter = new Salter();
        try{
        salter.Salt(csvFile, 45, "6");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        //salted1.csv is with a value of 20 data1.csv
        //salted2.csv is with a value of 60 data1.csv
        //salted3.csv is with a value of 45 data1.csv
        //salted4.csv is with a value of 20 data2.csv
        //salted5.csv is with a value of 60 data2.csv
        //salted6.csv is with a value of 45 data2.csv

    }
}
