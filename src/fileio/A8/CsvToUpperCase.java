package fileio.A8;

import java.io.*;

public class CsvToUpperCase {
    public static void main(String[] args) {
        String filename = "src/Files/employee.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
