package exceptionHandling.A5;
import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        // Setup accounts
        accounts.put("A1", new Account("A1", 1000));
        accounts.put("A2", new Account("A2", 500));

        System.out.println("Before Transfer:");
        printBalances();

        try {
            transferFunds("A1", "A3", 200); // A3 does not exist, should trigger rollback
        } catch (Exception e) {
            System.err.println("Transfer failed: " + e.getMessage());
        }

        System.out.println("\nAfter Transfer Attempt:");
        printBalances();
    }

    public static void transferFunds(String fromId, String toId, double amount) {
        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);

        if (fromAccount == null)
            throw new IllegalArgumentException("Source account does not exist");

        double originalFromBalance = fromAccount.getBalance();

        try {
            // Step 1: Debit from source
            fromAccount.debit(amount);

            // Step 2: Validate destination account
            if (toAccount == null) {
                throw new IllegalArgumentException("Target account does not exist");
            }

            // Step 3: Credit to destination
            toAccount.credit(amount);

            System.out.println("Transfer successful!");

        } catch (Exception e) {
            // Rollback to original balance
            fromAccount.credit(amount);
            throw e;  // Re-throw to caller
        }
    }

    public static void printBalances() {
        for (Account acc : accounts.values()) {
            System.out.println(acc.getAccountId() + " Balance: " + acc.getBalance());
        }
    }
}