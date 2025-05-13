
package exceptionHandling.A1;

import java.io.*;

// Custom Exception
class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

public class MultiLevelExceptionPropagation {

    // Method 1: Simulate reading data from a file
    public static void readData() throws IOException {
        // Simulating an IOException when trying to read a file
        throw new IOException("Failed to read data from file.");
    }

    // Method 2: Process the data, calls readData()
    public static void processData() throws DataProcessingException {
        try {
            // Calling readData, which may throw an IOException
            readData();
        } catch (IOException e) {
            // Catch the IOException and throw a custom exception
            throw new DataProcessingException("Data processing failed: " + e.getMessage());
        }
    }

    // Method 3: Main method that calls processData()
    public static void main(String[] args) {
        try {
            // Calling processData, which may throw DataProcessingException
            processData();
        } catch (DataProcessingException e) {
            // Catch the custom exception and print it to the console
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for more detailed error information
        }
    }
}
