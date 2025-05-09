package fileio.A10;

import java.io.File;

public class ListFilesInFolders {
    public static void main(String[] args) {

        String folderName = "fileio";
        File folder = new File(folderName);

        if (folder.exists() && folder.isDirectory()) {

            String[] files = folder.list();

            if (files != null && files.length > 0) {
                System.out.println("Files and directories in the '" + folderName + "' folder:");
                for (String fileName : files) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The folder is empty.");
            }
        } else {
            System.out.println("The folder '" + folderName + "' does not exist or is not a directory.");
        }
    }
}
