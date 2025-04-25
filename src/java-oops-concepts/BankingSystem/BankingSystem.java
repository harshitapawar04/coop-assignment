package BankingSystem;
import java.util.Scanner;

interface AccountOperations{
    void deposit(double amount);
    void withdrawal(double amount);
    void checkBalance();
    void displayInfo();
}
abstract class Account implements AccountOperations{
    protected String accHolder;
    protected double balance;

    public Account(String accHolder, double initialBalance){
        this.accHolder=accHolder;
        this.balance=initialBalance;
    }
    @Override
    public void displayInfo(){
        System.out.println("Accout holder: "+ accHolder);
        checkBalance();
    }
    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
class SavingAcc extends Account{
    private final double interest = 3.5;
    public SavingAcc(String accHolder, double initialBalance ) {
        super(accHolder, initialBalance);
    }

    @Override
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("enter valid balance ");
        }
        else{
            balance+=amount;
            System.out.println(amount +"deposited sucessfully");
        }
    }

    @Override
    public void withdrawal(double amount){
        if(balance<=amount){
            System.out.println("Insufficient Balance");
        }
        else{
            balance-=amount;
            System.out.println(amount +"withdrew succesfully" );
        }

    }
}

class CurrentAcc extends Account{
    public CurrentAcc(String accHolder, double initialBalance ){
        super(accHolder,initialBalance);
    }
    @Override
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("enter valid balance ");
        }
        else{
            balance+=amount;
            System.out.println(amount +"deposited sucessfully");
        }
    }

    @Override
    public void withdrawal(double amount){
        if(balance<=amount){
            System.out.println("Insufficient Balance");
        }
        else{
            balance-=amount;
            System.out.println(amount +"withdrew succesfully" );
        }

    }
    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}


public class BankingSystem{
    public static AccountOperations account=null;

    public static void createAcc(){
        Scanner sc= new Scanner(System.in);

        System.out.println("Choose Account type");
        System.out.println("Enter 1 for Saving Account or 2 for Current Account");
        int accountType= sc.nextInt();
        System.out.println("enter account holders name");
        sc.nextLine();
        String accHolder= sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = sc.nextDouble();

        if (accountType == 1) {
            account = new SavingAcc(accHolder, initialDeposit);
            System.out.println("Savings Account created successfully.");
        } else if (accountType == 2) {
            account = new CurrentAcc(accHolder, initialDeposit);
            System.out.println("Checking Account created successfully.");
        } else {
            System.out.println("Invalid account type!");
        }
    }

    public static void displayMenu() {
        System.out.println("MENU");
        System.out.println("\nMenu:");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Display Account Information");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while(true){
            displayMenu();
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    createAcc();
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = sc.nextDouble();
                        account.withdrawal(withdrawalAmount);
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;
                case 4:
                    account.displayInfo();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Bank System.");
                    sc.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

    }

}
