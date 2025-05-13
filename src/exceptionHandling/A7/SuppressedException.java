package exceptionHandling.A7;

public class SuppressedException {
    public static void main(String[] args) {
        try (ResourceA a = new ResourceA(); ResourceB b = new ResourceB()) {
            System.out.println("Using resources...");

        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());


            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}