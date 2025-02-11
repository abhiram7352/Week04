package day02_java_collections;

import java.util.*;

// Class representing a patient in the hospital triage system
class Patient {
    private String name;     // Name of the patient
    private int severity;    // Severity level (higher means more urgent)

    // Constructor to initialize patient attributes
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Getter methods
    public String getName() { return name; }
    public int getSeverity() { return severity; }

    // Overriding toString() for readable patient information
    @Override
    public String toString() {
        return "Patient: " + name + ", Severity: " + severity;
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // PriorityQueue to manage patients based on severity
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
                Comparator.comparingInt(Patient::getSeverity).reversed()  // Higher severity treated first
        );

        // Adding patients to the queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Simulating patient treatment based on severity
        System.out.println("Order of treatment:");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.poll();  // Poll the patient with the highest severity
            System.out.println(nextPatient);
        }
    }
}
