package day04_java_exceptions;

import java.util.Scanner;
//Creating Custom exception named InsufficientBalanceException
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

//Main class
public class BankTransactionSystem {

    //Method to witdraw any amount
    public static void withdraw(double amount, double balance) throws InsufficientBalanceException {
        if (amount > balance) {
            //Handled Insufficient Balance Exception
            throw new InsufficientBalanceException(" Insufficient Balance");
        } else if (amount < 0) {
            //Handled Illegal Argument Exception
            throw new IllegalArgumentException("Invalid amount");
        } else {
            balance = balance - amount; //Withdrawing the amount
            System.out.println("Withdrawal successful, new balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your account balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter the ammount you want to withdraw: ");
        double amount = sc.nextDouble();

        try{
            withdraw(amount, balance);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }
    }
}
