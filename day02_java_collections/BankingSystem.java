package day02_java_collections;

import java.util.*;

// Class representing the Banking System
public class BankingSystem {
    // HashMap to store customer accounts (AccountNumber -> Balance)
    private Map<String, Double> accounts = new HashMap<>();

    // Queue to process withdrawal requests
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // Method to create a new account
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Method to deposit money into an account
    public void deposit(String accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    // Method to request a withdrawal
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method to process all withdrawal requests
    public void processWithdrawals() {
        System.out.println("--- Processing Withdrawals ---");
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + accountNumber);
            // For simplicity, deducting a fixed amount for each withdrawal
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= 50) {
                accounts.put(accountNumber, currentBalance - 50);
                System.out.println("$50 withdrawn. New Balance: $" + accounts.get(accountNumber));
            } else {
                System.out.println("Insufficient funds for Account: " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance using TreeMap
    public void displayAccountsSortedByBalance() {
        System.out.println("--- Accounts Sorted by Balance (TreeMap) ---");
        TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        sortedAccounts.forEach((balance, accountNumbers) ->
                accountNumbers.forEach(accountNumber ->
                        System.out.println("Account: " + accountNumber + ", Balance: $" + balance)));
    }

    // Main method to run the Banking System
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        // Creating accounts
        bankingSystem.createAccount("A123", 500.0);
        bankingSystem.createAccount("B456", 300.0);
        bankingSystem.createAccount("C789", 700.0);

        // Depositing money
        bankingSystem.deposit("A123", 200.0);
        bankingSystem.deposit("B456", 100.0);

        // Requesting withdrawals
        bankingSystem.requestWithdrawal("A123");
        bankingSystem.requestWithdrawal("B456");
        bankingSystem.requestWithdrawal("C789");

        // Processing withdrawals
        bankingSystem.processWithdrawals();

        // Displaying accounts sorted by balance
        bankingSystem.displayAccountsSortedByBalance();
    }
}
