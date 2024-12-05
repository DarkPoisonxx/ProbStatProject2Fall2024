package Testers;
import java.io.File;
import java.io.IOException;

import Plotters.Salter;

public class TestSalter {
    public static void main(String[] args) throws IOException {
        File csvFile = new File("data.csv");
        Salter salter = new Salter();
        salter.Salt(csvFile, 20);
    }
}
