package fileio.A7;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppendDateToFile {
    public static void main(String[] args) {
        String filename = "src/Files/input.txt";

        // Get the current date and format it
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String message = "Last updated on " + currentDate;

        try (FileWriter fw = new FileWriter(filename, true); // 'true' for append mode
             BufferedWriter writer = new BufferedWriter(fw)) {

            writer.newLine(); // Add a new line before appending the message
            writer.write(message); // Write the message to the file
            System.out.println("Successfully appended: " + message);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
