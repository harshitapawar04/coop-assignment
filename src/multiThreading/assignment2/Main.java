package multiThreading.assignment2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount(100);
        System.out.println("Starting Balance: " + account.getBalance());

        Thread t1 = new User(account, "thread-1");
        Thread t2 = new User(account, "thread-2");
        Thread t3 = new User(account, "thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Balance: " + account.getBalance());

        System.out.println("\n");
        System.out.println("Account Logs:");
        for (String log : account.getTransactionLog()) {
            System.out.println(log);
        }
    }
}
