package PFAssignments.DataStructure;

import java.util.LinkedList;
import java.util.Scanner;

public class linkedListQ2 {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 50;
    private static final int FILTER_THRESHOLD = 25;
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter number of elements to add: ");
            if(!scanner.hasNextInt()){
                System.out.println("Enter a valid integer.");
                return;
            }
            int expectedCount = scanner.nextInt();
            if(expectedCount<=0){
                System.out.println("Element count must be in positive integer");
                return;
            }
            for (int i = 0; i < expectedCount; i++) {
                System.out.printf("Enter element %d of %d (Range %d-%d): ", i + 1, expectedCount, RANGE_MIN, RANGE_MAX);
                if (scanner.hasNextInt()) {
                    int inputVal = scanner.nextInt();
                    if (inputVal >= RANGE_MIN && inputVal <= RANGE_MAX) {
                        list.add(inputVal);
                    } else {
                        System.out.printf("Out of range! Please enter a number between %d and %d.%n", RANGE_MIN, RANGE_MAX);
                        i--; 
                    }
                } else {
                    System.out.println("Invalid non-numeric input string detected. Please enter integers only.");
                    scanner.next(); 
                    i--;
                }
            }
            System.out.println("Original List: " + list);
            filterNodesGreaterThanThreshold(list);
            System.out.println("Filtered List (Values <= 25): " + list);
        } catch (Exception e) {
        }
    }
    public static void filterNodesGreaterThanThreshold(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.removeIf(value -> value > FILTER_THRESHOLD);
    }
}
