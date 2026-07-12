import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Bank {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Account> accounts = new ArrayList<>();
    private int nextAccountNum = 1001;

    public Bank(Scanner sc) {
        this.sc = sc;

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
        System.out.println("  ");
        System.out.println("---------------------------");
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
                System.out.println("---------------------------");
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
                System.out.println("---------------------------");
                found = true;
                break;
            }
        }
        if(!found){
                System.out.println("Account not found.");
            }
    }

    public void withdrawMoney(){
        boolean found = false;
        System.out.print("Enter account number to withdraw money: ");
        String findAccountNumber = sc.nextLine();
        for(int i=0; i<accounts.size(); i++){
            Account account = accounts.get(i);
            if(account.getAccountNumber().equals(findAccountNumber)){
                System.out.print("Enter amount to withdraw: ");
                double amount = sc.nextDouble();
                sc.nextLine(); 
                if(amount <= account.getBalance()){
                    double newBalance = account.getBalance() - amount;
                    account.updateBalance(newBalance);
                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient balance.");
                }
                System.out.println("---------------------------");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Account not found.");
        }
    }

    public void saveAccounts(){
        try{
           FileWriter file = new FileWriter("accounts.txt");
           BufferedWriter writer = new BufferedWriter(file);

           for(Account account : accounts){
            writer.write(account.getAccountNumber() + "," + account.getAccountHolderName() + "," + account.getBalance());
            writer.newLine();
           }

           writer.close();
        }
        catch(IOException e){
            System.out.println("An error occurred while saving accounts.");
        }
    }

    public void loadAccounts(){
      try{
       FileReader file = new FileReader("accounts.txt");
       BufferedReader reader = new BufferedReader(file);
        String line;
        while((line = reader.readLine()) != null){
         String[] data = line.split(",");
         String accountNumber = data[0];
         String accountHolderName = data[1];
         double balance = Double.parseDouble(data[2]);
         Account account = new Account(accountHolderName, accountNumber, balance);
         accounts.add(account);
        }
       reader.close();
    }
      catch(IOException e){
      System.out.println("An error occurred while loading accounts.");
      }
    }
}
