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
    //Random generator initialized
    Random rnd = new Random();
    //This method is to accept csv files under csvFile and salt them or give them random values between 0 and the given number or saltValue
    //The fileName allows the user to rename the new file
    public void Salt(File csvFile, int saltValue, String fileName) throws IOException{
        File tmp = new File(csvFile.getParent(), "salted" + fileName + ".csv");   //creates a temp file to be able to change the csv

        try (
            BufferedReader reader = new BufferedReader(new FileReader(csvFile)); //reader to read the original csvFile
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp)) //creates a writer to write to the temp file
        ){
            String input; // initialize input
            reader.readLine();      //skip the first line of the file you are reading 
            writer.write("X,Y");        //write the headers for the new salt
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
                String formattedY = decimal.format(y);
                    values[1] = formattedY;

                writer.write(String.join(",",values));
                writer.newLine();
            }
        
            csvFile.delete();
            tmp.renameTo(csvFile);
            System.out.println("The csv File has been successfully salted!");
        }

    }
}