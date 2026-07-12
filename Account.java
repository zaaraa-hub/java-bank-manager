public class Account{
 private String accountHolderName;
 private String accountNumber;
 private double balance;

 public Account(String accountHolderName, String accountNumber, double balance){
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = balance;
 }

    public String getAccountHolderName(){
        return accountHolderName;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

public void updateBalance(double newBalance){
    this.balance = newBalance;
}
}
