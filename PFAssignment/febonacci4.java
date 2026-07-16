package PFAssignments.PFAssignment;

import java.util.Scanner;

public class febonacci4 {
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void printFibonacciPrimesLessThan(int threshold) {
        if (threshold <= 2) {
            System.out.println("No Fibonacci primes exist strictly less than " + threshold);
            return;
        }
        StringBuilder resultBuilder = new StringBuilder();
        long firstTerm = 0;
        long secondTerm = 1;
        while (firstTerm < threshold) {
            if (isPrime(firstTerm)) {
                resultBuilder.append(firstTerm).append(" ");
            }
            if (firstTerm > Long.MAX_VALUE - secondTerm) {
                System.out.println("Long integer overflow threshold reached. Halting sequence generation.");
                break;
            }
            long nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        String output = resultBuilder.toString().trim();
        if (output.isEmpty()) {
            System.out.println("No Fibonacci primes found under " + threshold);
        } else {
            System.out.println("Prime Fibonacci numbers less than "+ threshold +" :"+ output);
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int limit = scanner.nextInt();
            printFibonacciPrimesLessThan(limit);
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}
