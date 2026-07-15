package PFAssignments;

import java.util.Scanner;

public class armstrong {
    public static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        }
        if (number < 10) {
            return true;
        }
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
    public static void main(String[] args) {
        System.out.print("Enter a maximum limit: ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int limit = scanner.nextInt();
            if (limit < 0) {
                System.out.println("Please enter a non-negative integer.");
                return;
            }
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < limit; i++) {
                if (isArmstrong(i)) {
                    resultBuilder.append(i).append(" ");
                }
            }
            String output = resultBuilder.toString().trim();
            if (output.isEmpty()) {
                System.out.println("No Armstrong numbers found below " + limit);
            } else {
                System.out.println("Armstrong numbers: " + output);
            }
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}
