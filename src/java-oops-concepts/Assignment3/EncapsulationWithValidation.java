package Assignment3;
import java.util.Scanner;

class BankAccount{
    private String accountHolder;
    private long balance;
    private String accountNumber;

    public  String getName(){
        return accountHolder;
    }
    public void setName(String accountHolder){
        this.accountHolder= accountHolder;
    }
    public  String getAccNum(){
        return accountNumber;
    }
    public void setAccNum(String accountNumber){
        this.accountNumber= accountNumber;
    }
    public long getBalance(){
        return balance;
    }
    public void setBalance(long balance){
        if(balance<0){
            System.out.println("Negative balance is not allowed");
        }
        else{
            this.balance=balance;
        }
    }
    public void displayDetail(){
        System.out.println("Account Holder: "+ accountHolder);
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Balance:"+ balance);
    }

}

public class EncapsulationWithValidation{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        BankAccount customer = new BankAccount();
        System.out.print("Enter account holder's name:");
        customer.setName(scanner.nextLine());
        System.out.print("Enter account number of the holder:");
        customer.setAccNum(scanner.nextLine());
        long balance=-1;
        while(balance<0){
            System.out.print("enter balance:");
            balance=scanner.nextLong();
            customer.setBalance(balance);
        }
        customer.displayDetail();
        scanner.close();
    }
}


