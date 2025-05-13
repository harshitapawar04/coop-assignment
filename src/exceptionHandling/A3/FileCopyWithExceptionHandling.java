package exceptionHandling.A3;

import java.io.*;

public class FileCopyWithExceptionHandling {

    public static void main(String[] args) {
        // Input and output file paths
        String inputFilePath = "src/exceptionHandling/A3/input.txt";
        String outputFilePath = "src/exceptionHandling/A3/output.txt";

        // Try-with-resources to ensure both files are closed safely
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            // Read each line from the input file and write it to the output file
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();  // Ensure each line is written on a new line
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            // Handle any IOExceptions that may occur during reading/writing
            System.err.println("An error occurred during file processing: " + e.getMessage());
        }
    }
}
