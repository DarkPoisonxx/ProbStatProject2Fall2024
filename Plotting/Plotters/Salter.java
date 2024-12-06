package Plotters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class Salter{
    //rnd generator initialized
    Random rnd = new Random();

    public void Salt(File csvFile, int saltValue, String fileName) throws IOException{
        File tmp = new File(csvFile.getParent(), "salted" + fileName + ".csv");   //creates a temp file to be able to change the csv

        try (
            BufferedReader reader = new BufferedReader(new FileReader(csvFile)); //reader  to read the original csvFile
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp)) //creates a writer to write to the temp file
        ){
            String input;
            String header = reader.readLine();
            writer.write(header);
            writer.newLine();
            //sets inputs equal to the line  if it is not null this will continue the while
            while ((input = reader.readLine()) != null){ 
                //creates split array with each value
                    String[] values = input.split(",");
                //grabs the y value and turns it into a
                    double y = Double.parseDouble(values[1]);
                //adding or subtracting -1 or 1
                    int rndNum = rnd.nextBoolean() ? 1 : -1;
                    y += rndNum * rnd.nextInt(saltValue + 1);
                //inputs the new y value
                DecimalFormat decimal = new DecimalFormat("#.00");
                String formattedy = decimal.format(y);
                    values[1] = formattedy;

                writer.write(String.join(",",values));
                writer.newLine();
            }
            csvFile.delete();
            tmp.renameTo(csvFile);
            System.out.println("The csv File has been successfully salted!");
        }

    }
}