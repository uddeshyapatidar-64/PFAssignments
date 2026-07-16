package PFAssignments.PFAssignment;

import java.util.Scanner;

public class calculateSeries {
    public static double calculateAlternatingFactorialSeries(int targetLimit) {
        if (targetLimit <= 0) {
            return 0.0;
        }
        double seriesSum = 1.0;
        double currentFactorial = 1.0; 
        int signMultiplier = -1; 
        for (int term = 2; term <= targetLimit; term++) {
            currentFactorial *= term; 
            double termValue = (double) term / currentFactorial;
            seriesSum += signMultiplier * termValue;
            signMultiplier = -signMultiplier;
        }
        return seriesSum;
    }
    public static void main(String[] args) {
        System.out.print("Enter a num: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided sequence token is not a valid integer.");
                return;
            }
            int targetLimit = scanner.nextInt();
            if (targetLimit <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
                return;
            }
            double finalResult = calculateAlternatingFactorialSeries(targetLimit);
            System.out.printf("Sum of series for N = %d is: %f%n", targetLimit, finalResult);
        } catch (Exception e) {
            System.out.println("An unexpected system runtime exception occurred: " + e.getMessage());
        }
    }
}
