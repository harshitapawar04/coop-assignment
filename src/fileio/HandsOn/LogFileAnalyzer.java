import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LogFileAnalyzer {

    public static void main(String[] args) {
        // Check if input and output file names are passed as arguments
        if (args.length != 2) {
            System.out.println("Usage: java LogFileAnalyzer <input_file> <output_file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        int totalEntries = 0;
        int errorEntries = 0;
        int warningEntries = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                totalEntries++;

                if (line.contains("ERROR")) {
                    errorEntries++;
                }

                if (line.contains("WARNING")) {
                    warningEntries++;
                }
            }

            double errorPercentage = (totalEntries == 0) ? 0 : (double) errorEntries / totalEntries * 100;
            double warningPercentage = (totalEntries == 0) ? 0 : (double) warningEntries / totalEntries * 100;

            StringBuilder report = new StringBuilder();
            report.append("Log Summary Report\n");
            report.append("------------------\n");
            report.append("Total log entries: ").append(totalEntries).append("\n");
            report.append("ERROR entries: ").append(errorEntries).append("\n");
            report.append("WARNING entries: ").append(warningEntries).append("\n");
            report.append(String.format("Percentage of ERROR entries: %.2f%%\n", errorPercentage));
            report.append(String.format("Percentage of WARNING entries: %.2f%%\n", warningPercentage));

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
                writer.write(report.toString());
                System.out.println("Report written to " + outputFile);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: The input file " + inputFile + " was not found.");
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while processing the file.");
            e.printStackTrace();
        }
    }
}
