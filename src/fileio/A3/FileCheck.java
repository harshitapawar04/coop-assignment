package fileio.A3;

import java.io.File;

public class FileCheck {
    public static void main(String[] args) {
        String fileName = "src/Files/input.txt";
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            System.out.println("File '" + fileName + "' exists.");
            System.out.println("Size: " + file.length() + " bytes");
        } else {
            System.out.println("File '" + fileName + "' does not exist in the current directory.");
        }
    }
}
