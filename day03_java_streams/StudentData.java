package day03_java_streams;

import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String filename = "student_data.bin";

        // Store student details
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(1); // Roll number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(2); // Roll number
            dos.writeUTF("Bob"); // Name
            dos.writeDouble(3.6); // GPA

            System.out.println("Student details have been stored in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retrieve student details
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}