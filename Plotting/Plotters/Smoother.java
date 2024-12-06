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
            String header = reader.readLine(); // Read and write the header
            writer.write(header);
            writer.newLine();

            // Get the number of rows in the CSV (to know the size of the arrays)
            int rowCount = 0;
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

                // Perform iterative smoothing directly in this method
                boolean converged;
                do {
                    converged = true;
                    // Iterate over the array (except the first and last elements)
                    for (int i = 1; i < yValues.length - 1; i++) {
                        double average = (yValues[i - 1] + yValues[i + 1]) / 2;
                        if (Math.abs(yValues[i] - average) > 0.01) { // Convergence threshold
                            yValues[i] = average; // Update the value
                            converged = false; // Not yet converged
                        }
                    }
                } while (!converged); // Repeat until all values converge

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
