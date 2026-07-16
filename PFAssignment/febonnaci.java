package PFAssignments.PFAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class febonnaci {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int requestedLength = scanner.nextInt();
            if (requestedLength < 0) {
                System.out.println("Please enter a non-negative integer (0 or greater).");
                return;
            }
            int[] resultSequence = generateFibonacci(requestedLength);
            System.out.println("Fibonacci Series: " + Arrays.toString(resultSequence));

        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
    public static int[] generateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Sequence length cannot be negative.");
        }
        if (n == 0) return new int[0];
        if (n == 1) return new int[]{0};
        int[] sequence = new int[n];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }
}
