package fileio.A6;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "src/Files/notes.txt";
        String targetWord = "Java";
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase to make the search case-insensitive
                String[] words = line.split("\\s+"); // Split by whitespace

                // Count occurrences of the word "Java"
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in " + filename + ".");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
