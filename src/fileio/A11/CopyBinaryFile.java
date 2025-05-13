package fileio.A11;

import java.nio.file.*;

public class CopyBinaryFile {
    public static void main(String[] args) {
        // Define source and destination paths
        Path sourceFile = Paths.get("src/Files/img.jpg");
        Path destinationFile = Paths.get("src/Files/image_copy.jpg");

        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
