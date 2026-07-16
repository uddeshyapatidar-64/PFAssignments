package PFAssignments.PFAssignment;

import java.util.Scanner;

public class pattern3 {
    public static void printInvertedHollowPattern(int peakVal) {
        if (peakVal <= 0) {
            System.out.println("Pattern constraint error: Number must be greater than 0.");
            return;
        }
        StringBuilder patternBuffer = new StringBuilder();
        for (int currentRow = peakVal; currentRow >= 1; currentRow--) {
            for (int j = peakVal; j >= 1; j--) {
                if (j >= currentRow) {
                    patternBuffer.append(j);
                } else {
                    patternBuffer.append(" ");
                }
            }
            for (int j = 2; j <= peakVal; j++) {
                if (j >= currentRow) {
                    patternBuffer.append(j);
                } else {
                    patternBuffer.append(" ");
                }
            }
            patternBuffer.append(System.lineSeparator());
        }
        System.out.print(patternBuffer);
    }
    public static void main(String[] args) {
        System.out.print("Enter a num: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided sequence token is not a valid integer.");
                return;
            }
            int inputNum = scanner.nextInt();
            printInvertedHollowPattern(inputNum);
        } catch (Exception e) {
            System.out.println("An unexpected system runtime exception occurred: " + e.getMessage());
        }
    }
}
