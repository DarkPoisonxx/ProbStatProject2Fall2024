package Plotters;

import java.io.*;
import java.text.DecimalFormat;

public class Smoother {
    public void smooth(File csvFile, String fileName) throws IOException {
        File tmp = new File(csvFile.getParent(), "smoothed" + fileName + ".csv"); // Create a temp file for the smoothed CSV

        try (
            BufferedReader reader = new BufferedReader(new FileReader(csvFile)); // Reader for the original CSV file
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp)) // Writer for the temp file
        ) {
            String input;
            writer.write("X,Y");
            writer.newLine();

            // Get the number of rows in the CSV (to know the size of the arrays)
            int rowCount = -1;
            while ((input = reader.readLine()) != null) {
                rowCount++;
            }

            // Create a new BufferedReader to read the file from the start
            try (BufferedReader reader2 = new BufferedReader(new FileReader(csvFile))) {
                // Skip the header
                reader2.readLine();

                // Initialize arrays for X and Y values
                String[] xValues = new String[rowCount];
                double[] yValues = new double[rowCount];

                // Read the data into the arrays
                int index = 0;
                while ((input = reader2.readLine()) != null) {
                    String[] values = input.split(",");
                    xValues[index] = values[0]; // Store X values
                    yValues[index] = Double.parseDouble(values[1]); // Store Y values
                    index++;
                }

                // Perform smoothing, including the first and last elements
                for (int i = 1; i < yValues.length - 1; i++) {
                    double sum = 0;
                    int rowsUsed = 0;
                    // Sliding window: go from half the row count before to half the row count after
                    for (int j = Math.max(0, i - rowCount / 2); j <= Math.min(yValues.length - 1, i + rowCount / 2); j++) {
                        sum += yValues[j];  // Sum the values within the window
                        rowsUsed++;
                    }
                    // Assign the average of the windowed values to the current yValue
                    yValues[i] = sum / rowsUsed - 1;
                }

                // Smooth the first element by averaging with the next element
                yValues[0] = (yValues[0] + yValues[1]) / 2;

                // Smooth the last element by averaging with the previous element
                yValues[rowCount - 1] = (yValues[rowCount - 2] + yValues[rowCount - 1]) / 2;

                // Write the smoothed values back to the new file
                DecimalFormat df = new DecimalFormat("#.00");
                for (int i = 0; i < rowCount; i++) {
                    String formattedY = df.format(yValues[i]);
                    writer.write(xValues[i] + "," + formattedY);
                    writer.newLine();
                }

                System.out.println("The CSV file has been successfully smoothed!");
            }
        }
    }
}
