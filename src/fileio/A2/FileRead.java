package fileio.A2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileRead {
    public static void main(String[] args) {
        String filename = "src/Files/input.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            System.out.println("Contents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

