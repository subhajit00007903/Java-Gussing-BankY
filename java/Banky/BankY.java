import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Bank {
    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public Account createAccount(String accountNumber) {
        Account account = new Account(accountNumber);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

public class BankY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    bank.createAccount(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    bank.getAccount(accountNumber).deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    bank.getAccount(accountNumber).withdraw(amount);
                    break;
                case 4:
                    System.out.print("Enter from account number: ");
                    String fromAccountNumber = scanner.next();
                    System.out.print("Enter to account number: ");
                    String toAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    amount = scanner.nextDouble();
                    bank.getAccount(fromAccountNumber).transfer(bank.getAccount(toAccountNumber), amount);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.println("Balance: " + bank.getAccount(accountNumber).getBalance());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
