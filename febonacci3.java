package PFAssignments;

import java.util.Scanner;

public class febonacci3 {
    public static void main(String[] args) {
        System.out.print("Enter the number of Fibonacci-Primes to generate: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int count = scanner.nextInt();
            printNFibonacciPrimes(count);

        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }

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
    public static void printNFibonacciPrimes(int targetCount) {
        if (targetCount <= 0) {
            System.out.println("Please enter a count greater than 0.");
            return;
        }
        StringBuilder resultBuilder = new StringBuilder();
        int foundCount = 0;
        long firstTerm = 0;
        long secondTerm = 1;
        while (foundCount < targetCount) {
            if (isPrime(firstTerm)) {
                resultBuilder.append(firstTerm).append(" ");
                foundCount++;
            }
            if (firstTerm > Long.MAX_VALUE - secondTerm) {
                System.out.println("Long integer overflow threshold reached. Halting calculations.");
                break;
            }
            long nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.printf("First %d Fibonacci-Prime numbers: %n%s%n", 
                foundCount, resultBuilder.toString().trim());
    }
}
