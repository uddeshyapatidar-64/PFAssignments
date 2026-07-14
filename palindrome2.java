package PFAssignments;

import java.util.Scanner;

public class palindrome2 {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int target = scanner.nextInt();
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 1; i <= target; i++) {
                if (isPalindrome(i)) {
                    resultBuilder.append(i).append(" ");
                }
            }
            System.out.println("Palindrome numbers: " + resultBuilder.toString().trim());
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        if (number < 10) {
            return true;
        }
        if (number % 10 == 0) {
            return false;
        }
        int originalNumber = number;
        int reversedNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
