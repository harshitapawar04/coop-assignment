package multiThreading.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private double balance = 0;
    private final List<String> transactionLog = Collections.synchronizedList(new ArrayList<>());

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        if(amount <= 0){
            System.out.println("Amount should be >= 0, Balance: "+balance+" Thread: "+Thread.currentThread().getName());
        }
        balance+=amount;
        System.out.println("Deposit: "+ amount +" Thread: "+Thread.currentThread().getName());

        transactionLog.add(Thread.currentThread().getName()+" deposited: "+amount+" | Balance: "+balance);
    }

    public synchronized void withdraw(double amount){
        if(amount <= amount){
            balance-=amount;
            System.out.println("Withdrew: "+amount+", Balance: "+balance+" Thread: "+Thread.currentThread().getName());
        }else{
            System.out.println("Insufficient funds! Balance: "+balance+" Thread: "+Thread.currentThread().getName());
        }

        transactionLog.add(Thread.currentThread().getName()+" withdrew: "+amount+" | Balance: "+balance);
    }

    public synchronized double getBalance(){
        return  balance;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }
}
