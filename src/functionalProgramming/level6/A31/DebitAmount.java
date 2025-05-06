package functionalProgramming.level6.A31;

import java.util.*;

public class DebitAmount {
    public static void main(String[] args) {
        List<Transactions> transactions = Arrays.asList(
                new Transactions(200.0, "DEBIT"),
                new Transactions(150.0, "CREDIT"),
                new Transactions(300.0, "DEBIT"),
                new Transactions(100.0, "CREDIT")
        );

        double totalDebit= transactions.stream()
                .filter(t->t.getType().equalsIgnoreCase("Debit"))
                .mapToDouble(Transactions::getAmount)
                .sum();

        System.out.println("Total Amount : " + totalDebit);

    }
}
