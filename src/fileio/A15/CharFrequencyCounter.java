package fileio.A15;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharFrequencyCounter {
    public static void main(String[] args) {
        String inputFilePath = "src/Files/input.txt";
        String outputFilePath = "src/Files/charcount.txt";

        // Map to store character frequencies
        Map<Character, Integer> charCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                charCountMap.put(character, charCountMap.getOrDefault(character, 0) + 1);
            }

            // Write result to output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                    writer.write("'" + entry.getKey() + "' : " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Character count written to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

