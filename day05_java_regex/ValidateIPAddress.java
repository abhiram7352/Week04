package day05_java_regex;

import java.util.regex.*;

public class ValidateIPAddress {
    public static boolean isValidIPv4(String ip) {
        // Regular expression for a valid IPv4 address
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        // Return whether the IP address matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example IP addresses
        String[] testIPs = {
                "192.168.1.1",    // Valid
                "255.255.255.255", // Valid
                "0.0.0.0",         // Valid
                "256.100.50.25",   // Invalid (256 > 255)
                "192.168.1.300",   // Invalid (300 > 255)
                "192.168.01.1",    // Invalid (leading zero)
                "192.168.1",       // Invalid (only 3 parts)
                "192.168.1.1.1"    // Invalid (5 parts)
        };

        // Validate each IP address
        for (String ip : testIPs) {
            System.out.println(ip + " is valid? " + isValidIPv4(ip));
        }
    }
}
