package PFAssignments;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try(Scanner scanner = new Scanner(System.in)) {
            int inputVal = scanner.nextInt();
            if(isPalindrome(inputVal)){
                System.out.println(inputVal + " is Palindrome.");
            }else{
                System.out.println(inputVal+ " is not Palindrome.");
            }
        } catch (Exception e) {
            System.out.println("Invallid input " + e.getMessage());
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
