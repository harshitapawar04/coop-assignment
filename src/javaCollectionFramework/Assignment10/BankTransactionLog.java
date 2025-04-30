package javaCollectionFramework.Assignment10;

import java.time.LocalDateTime;
import java.util.*;

class Transaction {
    private LocalDateTime time;
    private double amount;
    private String type;

    public Transaction(LocalDateTime time, double amount, String type) {
        this.time = time;
        this.amount = amount;
        this.type = type;
    }

    // Getters
    public LocalDateTime getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return time + " | " + type + " | $" + amount;
    }
}

public class BankTransactionLog {
    private final Map<String, List<Transaction>> transactionsByAccount = new HashMap<>();

    public void addTransaction(String accountNumber, double amount, String type, LocalDateTime time) {
        Transaction t = new Transaction(time, amount, type);
        transactionsByAccount
                .computeIfAbsent(accountNumber, k -> new ArrayList<>())
                .add(t);
    }

    public void printStatement(String accountNumber) {
        List<Transaction> txList = transactionsByAccount.get(accountNumber);
        if (txList == null || txList.isEmpty()) {
            System.out.println("No transactions for account " + accountNumber);
            return;
        }

        // Sort by time ascending using getter
        txList.sort(Comparator.comparing(Transaction::getTime));

        System.out.println("Statement for account: " + accountNumber);
        for (Transaction t : txList) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        BankTransactionLog bank = new BankTransactionLog();

        LocalDateTime now = LocalDateTime.now();
        bank.addTransaction("ACC123", 500.0, "DEPOSIT", now);
        bank.addTransaction("ACC123", 200.0, "WITHDRAWAL", now.plusMinutes(1));
        bank.addTransaction("ACC456", 1000.0, "DEPOSIT", now.minusMinutes(5));

        bank.printStatement("ACC123");
    }
}
