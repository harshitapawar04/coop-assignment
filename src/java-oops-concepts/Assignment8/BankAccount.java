package Assignment8;
import java.util.Scanner;

class BankAccInfo {
    private String name;
    private double balance;
    private String type;

    public BankAccInfo(String name, double balance, String type) {
        this.name = name;
        this.balance = balance;
        this.type = type;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + ". Updated Balance: ₹" + this.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void showAccountDetails() {
        System.out.println("Account Details");
        System.out.println("Name: " + this.name);
        System.out.println("Account Type: " + this.type);
        System.out.println("Balance: " + this.balance);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter opening balance: ");
        double balance = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter account type (e.g., Savings, Current): ");
        String type = sc.nextLine();
        BankAccInfo account = new BankAccInfo(name, balance, type);

        account.showAccountDetails();

        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
        account.showAccountDetails();
        sc.close();
    }
}
