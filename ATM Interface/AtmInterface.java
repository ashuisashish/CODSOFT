import java.util.Scanner;

class UserBankAccount{
    private double balance;
    public UserBankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double myBalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposite successful. Your current balance is: " + balance);
        } else{
            System.out.println("Invalid amount for deposit.");
        }
    }
    public void withdraw(double amount){
        if (amount >0 && amount <=balance) {
            balance -= amount;
            System.out.println("Withdraw successful. Your current balance is: "+ balance);
        }else{
            System.out.println("Sorry Insufficient balance or you entered invalid amount for withdraw!.");
        }
    }
}
class ATM{
    UserBankAccount account;
    Scanner sc;
    public ATM(UserBankAccount account){
        this.account = account;
        this.sc = new Scanner(System.in);
    }
    public void showOptions(){
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void startTransaction(){
        int myChoice;
        do {
            showOptions();
            System.out.print("Press the button: ");
            myChoice = sc.nextInt();
            switch (myChoice) {
                case 1: checkBalance();
                    break;
                case 2: deposit();
                    break;
                case 3: withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
            
                default:
                    System.out.println("Invalid choice. Please select a valid option. ");
                    break;
            }
        }while (myChoice !=4);
    }
    public void checkBalance(){
        System.out.println("Your current balance is: "+account.myBalance());
    }
    public void deposit(){
        System.out.println("Enter the amount to deposit!");
        double amount = sc.nextInt();
        account.deposit(amount);
    }
    public void withdraw(){
        System.out.println("Enter the amount to withdraw!");
        double amount = sc.nextInt();
        account.withdraw(amount);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");
        System.out.print("Please Enter your four digit pin: ");
        int pin = sc.nextInt();
        UserBankAccount userAccount = new UserBankAccount(3000);
        ATM atm = new ATM(userAccount);
        atm.startTransaction();
    }
}
