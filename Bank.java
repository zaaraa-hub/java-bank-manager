import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Account> accounts = new ArrayList<>();
    private int nextAccountNum = 1001;

    public Bank() {

    }

    public void createAccount() {

      String accountNumber = "ACC" + nextAccountNum;
      System.out.println("Account Number: " + accountNumber);
      System.out.print("Enter account holder name: ");
      String accountHolderName = sc.nextLine();
      System.out.print("Enter account balance: ");
      double accountBalance = sc.nextDouble();
      sc.nextLine(); 
      accounts.add(new Account(accountHolderName, accountNumber, accountBalance));
      System.out.println("Account created successfully!");
      System.out.println("---------------------------");
      nextAccountNum++;
    }
  
    public void displayAccounts(){
        System.out.println("List of Accounts: ");
        for(int i=0; i<accounts.size(); i++){
            Account account = accounts.get(i);
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());
            System.out.println("Account Balance: " + account.getBalance());
            System.out.println("---------------------------");
        }
    }

    public void searchAccount(){
         boolean found = false;
        System.out.print("Enter account number to search: ");
        String findAccountNumber = sc.nextLine();
        for(int i=0; i<accounts.size(); i++){
            Account account = accounts.get(i);
            if(account.getAccountNumber().equals(findAccountNumber)){
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Holder Name: " + account.getAccountHolderName());
                System.out.println("Account Balance: " + account.getBalance());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Account not found.");
        }
    }

    public void depositMoney(){
        boolean found = false;
        System.out.print("Enter account number to deposit money: ");
        String findAccountNumber = sc.nextLine();
        for(int i=0; i<accounts.size(); i++){
            Account account = accounts.get(i);
            if(account.getAccountNumber().equals(findAccountNumber)){
                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();
                sc.nextLine(); 
                double newBalance = account.getBalance() + amount;
                account.updateBalance(newBalance);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
                found = true;
                break;
            }
        }
        if(!found){
                System.out.println("Account not found.");
            }
        
    }
}
