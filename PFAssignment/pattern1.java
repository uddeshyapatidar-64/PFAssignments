package PFAssignments.PFAssignment;

import java.util.Scanner;

public class pattern1 {
    public static void printNumberDiamond(int peakVal) {
        if (peakVal <= 0) {
            System.out.println("Pattern height must be a positive integer greater than 0.");
            return;
        }
        StringBuilder outputBuffer = new StringBuilder();
        for (int rowValue = 1; rowValue <= peakVal; rowValue++) {
            outputBuffer.append(buildRow(rowValue, peakVal)).append(System.lineSeparator());
        }
        for (int rowValue = peakVal - 1; rowValue >= 1; rowValue--) {
            outputBuffer.append(buildRow(rowValue, peakVal)).append(System.lineSeparator());
        }
        System.out.print(outputBuffer);
    }
    private static String buildRow(int currentRowVal, int peakVal) {
        StringBuilder rowBuilder = new StringBuilder();
        int leadingSpaces = peakVal - currentRowVal;
        for (int i = 0; i < leadingSpaces; i++) {
            rowBuilder.append(" ");
        }
        for (int i = currentRowVal; i >= 1; i--) {
            rowBuilder.append(i);
        }
        for (int i = 2; i <= currentRowVal; i++) {
            rowBuilder.append(i);
        }
        return rowBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.print("Enter peak number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided value is not a valid integer.");
                return;
            }
            int inputSize = scanner.nextInt();
            printNumberDiamond(inputSize);
        } catch (Exception e) {
            System.out.println("An unexpected system error occurred: " + e.getMessage());
        }
    }
}

