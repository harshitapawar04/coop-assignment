package fileio.A5;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "src/Files/data.txt";
        String backupFile = "src/Files/backup.txt";

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(backupFile);
        ) {
            byte[] buffer = new byte[1024];  // buffer to hold file data
            int bytesRead;

            // Read from source file and write to backup file
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + backupFile);
        } catch (IOException e) {
            System.out.println("An error occurred during file copy.");
            e.printStackTrace();
        }
    }
}
