
public class Main{
    public static void main(String[] args){
        Bank bank = new Bank();

        bank.createAccount();
        bank.createAccount();
        
        bank.displayAccounts();

        bank.searchAccount();

        bank.depositMoney();
    }
}