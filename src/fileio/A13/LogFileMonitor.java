package fileio.A13;

import java.io.*;

public class LogFileMonitor {
    public static void main(String[] args) {
        String logFilePath = "src/Files/server.log";

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ERROR")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
