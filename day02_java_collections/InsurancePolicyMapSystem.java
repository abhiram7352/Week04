package day02_java_collections;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

// Class representing an Insurance Policy
class Policy implements Comparable<Policy> {
    private String policyNumber;       // Unique identifier for the policy
    private String policyholderName;   // Name of the policyholder
    private LocalDate expiryDate;      // Expiry date of the policy
    private String coverageType;       // Type of coverage (Health, Auto, Home, etc.)
    private double premiumAmount;      // Premium amount for the policy

    // Constructor to initialize policy attributes
    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getter methods
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    // Overriding toString() for readable policy information
    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Name: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: $" + premiumAmount;
    }

    // Implementing compareTo() to sort policies by expiry date
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

// Class to manage insurance policies using Maps
public class InsurancePolicyMapSystem {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();              // For quick lookups
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();  // Maintains insertion order
    private Map<LocalDate, Policy> treeMapPolicies = new TreeMap<>();           // Sorted by expiry date

    // Method to add a policy to all maps
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public void listPoliciesExpiringSoon() {
        System.out.println("--- Policies Expiring Within 30 Days ---");
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        treeMapPolicies.values().stream()
                .filter(policy -> policy.getExpiryDate().isBefore(threshold))
                .forEach(System.out::println);
    }

    // List all policies for a specific policyholder
    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("--- Policies for Policyholder: " + policyholderName + " ---");
        hashMapPolicies.values().stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .forEach(System.out::println);
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        System.out.println("--- Removing Expired Policies ---");
        LocalDate today = LocalDate.now();
        hashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        treeMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("--- All Policies (LinkedHashMap) ---");
        linkedHashMapPolicies.values().forEach(System.out::println);
    }

    // Main method to run the Insurance Policy Management System
    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();

        // Adding sample policies
        system.addPolicy(new Policy("P001", "John Doe", "2025-12-01", "Health", 1200));
        system.addPolicy(new Policy("P002", "Jane Smith", "2024-11-15", "Auto", 800));
        system.addPolicy(new Policy("P003", "Alice Brown", "2024-10-10", "Home", 1500));
        system.addPolicy(new Policy("P004", "John Doe", "2024-09-05", "Auto", 1000));

        // Retrieve and display specific policy
        System.out.println("--- Retrieve Policy P002 ---");
        System.out.println(system.getPolicyByNumber("P002"));

        // Displaying policies based on various criteria
        system.listPoliciesExpiringSoon();
        system.listPoliciesByPolicyholder("John Doe");

        // Removing expired policies and displaying remaining
        system.removeExpiredPolicies();
        system.displayAllPolicies();
    }
}
