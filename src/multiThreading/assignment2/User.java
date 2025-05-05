package multiThreading.assignment2;

public class User extends Thread {

    private  final BankAccount account;

    public User (BankAccount bankAccount,String name)
    {
        super(name);
        this.account = bankAccount;
    }

    @Override
    public void run() {
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(100);
    }
}
