package PFAssignments;

import java.util.Scanner;

public class primeArmstrong {
    public static boolean isArmstrong(int number) {
        if (number < 0) return false;
        if (number < 10) return true; 
        int digits = (int) Math.log10(number) + 1;
        int originalNumber = number;
        long sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.round(Math.pow(digit, digits));
            number /= 10;
        }
        return sum == originalNumber;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void printPrimeArmstrongsLessThan(int limit) {
        if (limit <= 2) {
            System.out.println("No prime Armstrong numbers exist strictly less than " + limit);
            return;
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            if (isArmstrong(i) && isPrime(i)) {
                resultBuilder.append(i).append(" ");
            }
        }
        String output = resultBuilder.toString().trim();
        if (output.isEmpty()) {
            System.out.println("No matching numbers found below " + limit);
        } else {
            System.out.printf("Numbers under %d that are both Prime and Armstrong: %s%n", limit, output);
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter a limit: ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int limit = scanner.nextInt();
            printPrimeArmstrongsLessThan(limit);
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}
