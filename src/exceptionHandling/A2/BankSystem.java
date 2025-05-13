package exceptionHandling.A2;

// Base custom exception
class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// Subclass 1
class InsufficientFundsException extends BankingException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Subclass 2
class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

public class BankSystem {

    // Simulated transferFunds method
    public static void transferFunds(String fromAccount, String toAccount, double amount) throws BankingException {
        // Simulated conditions
        if (fromAccount == null || toAccount == null) {
            throw new InvalidAccountException("One or both account numbers are invalid.");
        }

        if (amount > 1000) { // Simulate insufficient funds if amount > 1000
            throw new InsufficientFundsException("Insufficient funds for transfer of $" + amount);
        }

        System.out.println("Transfer of $" + amount + " from " + fromAccount + " to " + toAccount + " successful.");
    }

    public static void main(String[] args) {
        // Example 1: Catching exceptions separately
        try {
            transferFunds(null, "ACC123", 500);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (BankingException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        }

        // Example 2: Catching both via the parent class
        try {
            transferFunds("ACC001", "ACC002", 2000);
        } catch (BankingException e) {
            System.out.println("Caught a BankingException: " + e.getMessage());
        }
    }
}





