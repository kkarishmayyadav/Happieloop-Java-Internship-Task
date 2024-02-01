import java.util.HashMap;
import java.util.Scanner;

public class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    Scanner sc = new Scanner(System.in);
    HashMap<String, BankAccount> map = new HashMap<>();

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    void createAccount() {

        System.out.println("Enter account Number");
        String accountNumber = sc.nextLine();

        System.out.println("Enter Your Name");
        String holderName = sc.nextLine();

        double balance;

        do {
            System.out.println("Deposit Minimum 1000 atleast to open account");
            balance = sc.nextDouble();
            if (balance < 1000) {
                System.out.println(" Insufficient Amount ");
            } else {
                break;
            }
        } while (balance < 1000);

        map.put(accountNumber, new BankAccount(accountNumber, holderName, balance));
        System.out.println(" Account Created Successfully!");

        System.out.println("\nEnter ~ to Open Transaction Menu Again");
        sc.skip("\\R");
        sc.nextLine();
    }

    void depositeMoney(String accountNumber) {

        if (map.containsKey(accountNumber)) {
            System.out.println("Enter Amount to Deposit");
            double amount = sc.nextDouble();

            BankAccount accountDetail = map.get(accountNumber);

            String name=accountDetail.getHolderName();
            double balance = amount + accountDetail.getBalance();

            map.put(accountNumber, new BankAccount(accountNumber, name, balance));
            System.out.println(" Amount credited Successfully!");
        } else {
            System.out.println("No Such Account Exist");
            System.out.println("'Please Enter Valid Account Number!'");
        }

        System.out.println("\nEnter ~ to Open Transaction Menu Again");
        sc.skip("\\R");
        sc.nextLine();
    }

    void withdrawl(String accountNumber) {

        if (map.containsKey(accountNumber)) {
            System.out.println("Enter Amount to Withdraw");
            double amount = sc.nextDouble();

            BankAccount accountDetail = map.get(accountNumber);
            if (accountDetail.getBalance() < amount) {
                System.out.println("Insufficient Account Balance ");
            } else {
                double balance = accountDetail.getBalance() - amount;
                map.put(accountNumber, new BankAccount(accountNumber, holderName, balance));
                System.out.println("Amount Withdrawal Successfully!");
            }
        } else {
            System.out.println("No Such Account Exist");
            System.out.println("'Please Enter Valid Account Number!'");
        }

        System.out.println("\nEnter ~ to Open Transaction Menu Again");
        sc.skip("\\R");
        sc.nextLine();

    }

    void checkBalance(String accountNumber) {

        if (map.containsKey(accountNumber)) {
            BankAccount bankDetail = map.get(accountNumber);
            System.out.println("Account Holder Name = " + bankDetail.getHolderName());
            System.out.println("Account Balance = " + bankDetail.getBalance());
        } else {
            System.out.println("No Such Account Exist");
            System.out.println("'Please Enter Valid Account Number!'");
        }

        System.out.println("\nEnter ~ to Open Transaction Menu Again");
        sc.nextLine();
    }

    public static void main(String[] args) {

        String task;
        Scanner input = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();

        do {
            System.out.println(" Transact Option :");
            System.out.println("1. Create account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdrawl");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.println("Choose any : ");
            task = input.nextLine();

            switch (task) {
                case "1":
                    // Create Account
                    bankAccount.createAccount();
                    break;

                case "2":
                    // Deposit Money
                    System.out.println("Enter Account Number");
                    bankAccount.depositeMoney(input.nextLine());
                    break;

                case "3":
                    // Withdrawl
                    System.out.println("Enter Account Number");
                    bankAccount.withdrawl(input.nextLine());
                    break;

                case "4":
                    // Check Balance
                    System.out.println("Enter Account Number");
                    bankAccount.checkBalance(input.nextLine());
                    break;

                case "5":
                    // Exit
                    break;

                default:
                    System.out.println("Please Enter valid option ");
                    System.out.println("\nEnter ~ to Open Transaction Menu Again");
                    input.nextLine();
                    break;
            }
        } while (task != "5");

        input.close();
    }
}
