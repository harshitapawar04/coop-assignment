package fileio.A14;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class NIOFileReadWrite {
    public static void main(String[] args) {
        Path sourceFilePath = Paths.get("src/Files/source.txt");
        Path destinationFilePath = Paths.get("src/Files/destination.txt");

        try {
            // Read all lines from the source file into a List
            List<String> lines = Files.readAllLines(sourceFilePath);

            // Write all lines to the destination file
            Files.write(destinationFilePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("File copied successfully from source.txt to destination.txt.");

        } catch (IOException e) {
            System.out.println("An error occurred during file read/write operation.");
            e.printStackTrace();
        }
    }
}
