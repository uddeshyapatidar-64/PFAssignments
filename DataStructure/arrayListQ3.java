package PFAssignments.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayListQ3 {
    public static boolean isAscending(ArrayList<Integer> list) {
        if (list == null || list.size() < 2) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements you would like to enter: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: Element count must be a valid integer.");
                return;
            }
            int totalElements = scanner.nextInt();
            if (totalElements < 0) {
                System.out.println("Element count cannot be negative.");
                return;
            }
            for (int i = 0; i < totalElements; i++) {
                System.out.println("Enter element"+i+1+" of " +totalElements);
                if (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                } else {
                    System.out.println("Skipping invalid entry. Please enter integers only.");
                    scanner.next(); 
                    i--; 
                }
            }
            boolean sorted = isAscending(numbers);
            System.out.println("Your List: " + numbers);
            System.out.println("Is ArrayList sorted in ascending order? " + sorted);
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}
