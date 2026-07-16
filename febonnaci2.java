package PFAssignments;
import java.util.Scanner;
public class febonnaci2 {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int input = scanner.nextInt();
            printFibonacciLessThan(input);

        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
    public static void printFibonacciLessThan(int input) {
        if (input <= 0) {
            System.out.println("No Fibonacci numbers are strictly less than " + input);
            return;
        }
        StringBuilder resultBuilder = new StringBuilder();
        int firstTerm = 0;
        int secondTerm = 1;
        while (firstTerm < input) {
            resultBuilder.append(firstTerm).append(" ");
            if (firstTerm > Integer.MAX_VALUE - secondTerm) {
                System.out.println("Integer overflow limit reached. Halting calculation.");
                break;
            }
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println("Fibonacci numbers: " + resultBuilder.toString().trim());
    }
}