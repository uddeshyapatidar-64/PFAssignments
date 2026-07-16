package PFAssignments;

import java.util.Scanner;

public class pattern2 {
    public static void printAscendingDiamond(int peakVal) {
        if (peakVal <= 0) {
            System.out.println("Pattern constraint error: Height must be greater than 0.");
            return;
        }
        StringBuilder diamondBuffer = new StringBuilder();
        for (int row = 1; row <= peakVal; row++) {
            diamondBuffer.append(buildSymmetricRow(row, peakVal)).append(System.lineSeparator());
        }
        for (int row = peakVal - 1; row >= 1; row--) {
            diamondBuffer.append(buildSymmetricRow(row, peakVal)).append(System.lineSeparator());
        }
        System.out.print(diamondBuffer);
    }
    private static String buildSymmetricRow(int currentRowVal, int peakVal) {
        StringBuilder rowBuilder = new StringBuilder();
        int structuralSpaces = peakVal - currentRowVal;
        for (int i = 0; i < structuralSpaces; i++) {
            rowBuilder.append(" ");
        }
        for (int i = 1; i <= currentRowVal; i++) {
            rowBuilder.append(i);
        }
        for (int i = currentRowVal - 1; i >= 1; i--) {
            rowBuilder.append(i);
        }
        return rowBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: The provided sequence token is not a valid integer.");
                return;
            }
            int targetLimit = scanner.nextInt();
            printAscendingDiamond(targetLimit);
        } catch (Exception e) {
            System.out.println("An unexpected system runtime exception occurred: " + e.getMessage());
        }
    }
}
