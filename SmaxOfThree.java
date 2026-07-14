package PFAssignments;

import java.util.Arrays;
import java.util.Scanner;

public class SmaxOfThree {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Choose variation for Second Max:");
            System.out.println("1. Logical Brackets");
            System.out.println("2. Safe Array Sorting");
            System.out.println("3. Arithmetic Elimination");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.print("Enter A: ");
            int a = input.nextInt();
            System.out.print("Enter B: ");
            int b = input.nextInt();
            System.out.print("Enter C: ");
            int c = input.nextInt();

            int secondMax;
            switch (choice) {
                case 1:
                    secondMax = findSecondMaxViaLogic(a, b, c);
                    System.out.println("Second max is: " + secondMax);
                    break;
                case 2:
                    secondMax = findSecondMaxViaSort(a, b, c);
                    System.out.println("Second max is: " + secondMax);
                    break;
                case 3:
                    secondMax = findSecondMaxViaElimination(a, b, c);
                    System.out.println("Second max is: " + secondMax);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public static int findSecondMaxViaLogic(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) return a;
        if ((b >= a && b <= c) || (b <= a && b >= c)) return b;
        return c;
    }
    public static int findSecondMaxViaSort(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums); 
        return nums[1];
    }
    public static int findSecondMaxViaElimination(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return (a + b + c) - max - min;
    }
}
