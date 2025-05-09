package fileio.A9;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String filename = "src/File/oldfile.txt";
        File file = new File(filename);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File '" + filename + "' deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File '" + filename + "' does not exist.");
        }
    }
}
