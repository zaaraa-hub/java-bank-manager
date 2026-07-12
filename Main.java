import java.util.Scanner;
import java.util.InputMismatchException;
public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(sc);
        

        int choice = 0;

        do{
            System.out.println("------Welcome to the Bank Management System------");
            System.out.println("1. Create Account");
            System.out.println("2. Display Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); 
                continue; 
            }
            sc.nextLine(); 
            switch(choice){
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.displayAccounts();
                    break;
                case 3:
                    bank.searchAccount();
                    break;
                case 4:
                    bank.depositMoney();
                    break;
                case 5:
                    bank.withdrawMoney();
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        while(choice != 6);
    }
}