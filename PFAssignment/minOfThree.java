package PFAssignments.PFAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class minOfThree {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Choose variation for finding Minimum:");
            System.out.println("1. If else");
            System.out.println("2. Array Sorting");
            System.out.println("3. Built-in Math method");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.print("Enter A: ");
            int a = input.nextInt();
            System.out.print("Enter B: ");
            int b = input.nextInt();
            System.out.print("Enter C: ");
            int c = input.nextInt();

            int min;
            switch (choice) {
                case 1:
                    min = findMinBranching(a, b, c);
                    System.out.println("Minimum num: " + min);
                    break;
                case 2:
                    min = findMinViaSort(a, b, c);
                    System.out.println("Minimum num: " + min);
                    break;
                case 3:
                    min = findMinViaMathAPI(a, b, c);
                    System.out.println("Minimum num: " + min);
                    break;
                default:
                    System.out.println("Invalid choice selection.");
            }
        }
    }
    public static int findMinBranching(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        return (b <= c) ? b : c; 
    }
    public static int findMinViaSort(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        return nums[0]; 
    }
    public static int findMinViaMathAPI(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
