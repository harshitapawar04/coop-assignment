package fileio.A1;

import java.io.FileWriter;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        String filename = "src/Files/notes.txt";
        String content = "This is my first file in Java.";

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
            System.out.println("File '" + filename + "' has been created and written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
