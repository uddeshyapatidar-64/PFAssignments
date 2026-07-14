package PFAssignments;

import java.util.Scanner;

public class palindrome3 {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                return;
            }
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
                return;
            }
            StringBuilder resultBuilder = new StringBuilder();
            int counter = 0;
            int currentNum = 0;
            while (counter < n) {
                if (isPalindrome(currentNum)) {
                    resultBuilder.append(currentNum).append(" ");
                    counter++;
                }
                currentNum++; 
            }
            System.out.println("First " + n + " palindrome numbers: " + resultBuilder.toString().trim());

        } catch (Exception e) {
           System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
    public static boolean isPalindrome(int number) {
        if (number < 0) return false;
        if (number < 10) return true;
        if (number % 10 == 0) return false;
        int originalNumber = number;
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
