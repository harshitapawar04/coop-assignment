package fileio.A12;

import java.io.*;

public class MergeTextFiles {
    public static void main(String[] args) {
        String folderPath = "src/Files"; // folder containing the .txt files
        String mergedFilePath = "src/Files/merged.txt"; // merged file path

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No .txt files found in the folder.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFilePath))) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                        writer.newLine(); // Add a blank line between files
                    }
                    System.out.println("Merged: " + file.getName());
                }
            }
            System.out.println("All files merged successfully into " + mergedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
