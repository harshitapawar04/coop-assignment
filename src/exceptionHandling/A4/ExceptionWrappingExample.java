package exceptionHandling.A4;

public class ExceptionWrappingExample {

    public static void main(String[] args) {
        try {
            processFile("nonexistent.txt");
        } catch (CustomException e) {
            System.err.println("Caught CustomException: " + e.getMessage());
            e.printStackTrace(); // Shows original stack trace too
        }
    }

    public static void processFile(String fileName) throws CustomException {
        try {
            // Simulating a file operation that fails
            throw new java.io.FileNotFoundException("File not found: " + fileName);
        } catch (java.io.IOException e) {
            // Wrapping the original exception with additional context
            throw new CustomException("Failed to process file: " + fileName, e);
        }
    }
}

// Custom exception class
class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
