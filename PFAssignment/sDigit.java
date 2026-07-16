package PFAssignments.PFAssignment;
import java.util.Scanner;

public class sDigit{
    public static int reduceToSingleDigitMath(long n) {
        long value = Math.abs(n);
        if (value == 0) {
            return 0;
        }
        return (int) (1 + (value - 1) % 9);
    }
    public static int reduceToSingleDigitIterative(long n) {
        long value = Math.abs(n);
        while (value >= 10) {
            long tempSum = 0;
            long current = value;
            while (current > 0) {
                tempSum += current % 10;
                current /= 10;
            }
            value = tempSum;
        }
        return (int) value;
    }
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextLong()) {
                System.out.println("Invalid input: The provided value is not a valid 64-bit integer.");
                return;
            }
            long inputNum = scanner.nextLong();
            int result = reduceToSingleDigitMath(inputNum);
            System.out.println("Single digit reduction: " + result);

        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}