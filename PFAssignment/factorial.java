package PFAssignments.PFAssignment;

import java.math.BigInteger;
import java.util.Scanner;

public class factorial {
    public static BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.print("Enter a non-negative integer: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int inputVal = scanner.nextInt();
            if (inputVal < 0) {
                System.out.println("Error: Factorial is mathematically undefined for negative numbers.");
                return;
            }
            BigInteger result = calculateFactorial(inputVal);
            System.out.printf( inputVal +" = " +result);
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}
