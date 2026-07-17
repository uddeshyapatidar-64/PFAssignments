package PFAssignments.DataStructure;

import java.util.Scanner;

public class arrayListQ1 {
    public static void collectAndPrintNames() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of names you would like to add: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: Count must be a valid integer.");
                return;
            }
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("The array size must be greater than 0.");
                return;
            }
            scanner.nextLine(); 
            String[] namesArray = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Enter name:  "+ i+" " + 1);
                namesArray[i] = scanner.nextLine().trim();
            }
            System.out.println(String.join(", ", namesArray));
        } catch (Exception e) {
            System.out.println("An unexpected I/O error occurred during execution: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        collectAndPrintNames();
    }
}
