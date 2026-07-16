package PFAssignments.PFAssignment;
import java.util.Scanner;

public class maxOfThree {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Choose your variation:\n1. Brute-Force If-Else\n2. Variable Comparison\n3. 3. Built-in Math method\nEnter your choice: ");
            int choice = input.nextInt();
            System.out.print("Enter A: ");
            int a = input.nextInt();
            System.out.print("Enter B: ");
            int b = input.nextInt();
            System.out.print("Enter C: ");
            int c = input.nextInt();
            int max;
            switch (choice) {
                case 1:
                    max = byBruteForce(a, b, c);
                    System.out.println("Max (via If-Else) is: " + max);
                    break;
                case 2:
                    max = byIteration(a, b, c);
                    System.out.println("Max (via Iterative Comparison) is: " + max);
                    break;
                case 3:
                    max = byMath(a, b, c);
                    System.out.println("Max (via Math) is: " + max);
                    break;
                default:
                    System.out.println("Invalid choice selection.");
            }
        }
    }
    public static int byBruteForce(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        return (b >= c) ? b : c;
    }
    public static int byIteration(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static int byMath(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
