package exceptionHandling.A8;

import java.util.Random;

public class RetryMechanism {

    public static String readFromService() throws Exception {
        if (new Random().nextInt(3) != 0) {
            throw new Exception("Service read failed.");
        }
        return "Service data received.";
    }

    public static String retryRead(int maxAttempts) throws ServiceUnavailableException {
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                return readFromService();  // Attempt to read
            } catch (Exception e) {
                attempts++;
                System.out.println("Attempt " + attempts + " failed: " + e.getMessage());

                if (attempts == maxAttempts) {
                    throw new ServiceUnavailableException("Service failed after " + maxAttempts + " attempts.");
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            String result = retryRead(3);
            System.out.println("Success: " + result);
        } catch (ServiceUnavailableException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}