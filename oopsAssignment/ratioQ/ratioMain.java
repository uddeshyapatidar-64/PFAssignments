package PFAssignments.oopsAssignment.ratioQ;

import java.util.InputMismatchException;
import java.util.Scanner;

// public class ratioMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter First Ratio R1");
//         int num1 = getValidInteger(scanner, "Enter R1 numerator: ");
//         int den1 = getValidDenominator(scanner, "Enter R1 denominator make sure its not 0: ");
//         RatioADT r1 = new Ratio(num1, den1);

//         System.out.println("\nEnter Second Ratio R2");
//         int num2 = getValidInteger(scanner, "Enter R2 numerator: ");
//         int den2 = getValidDenominator(scanner, "Enter R2 denominator make sure its not 0: ");
//         RatioADT r2 = new Ratio(num2, den2);

//         System.out.println("\nCreated Ratios:");
//         System.out.println("R1 = "+r1);
//         System.out.println("R2 = "+r2);

//         System.out.println("\nSelect an Operation");
//         System.out.println("1. Add R1+R2");
//         System.out.println("2. Subtract R1-R2");
//         System.out.println("3. Multiply R1*R2");
//         System.out.println("4. Divide R1/R2");
//         System.out.println("5. Check if Equal R1==R2");

//         int choice = getValidChoice(scanner, "Enter your choice (1-5): ", 1, 5);

//         System.out.println("\nResult");
//         switch (choice) {
//             case 1:
//                 System.out.println("Add: " + r1.add(r2));
//                 break;
//             case 2:
//                 System.out.println("Sub: " + r1.sub(r2));
//                 break;
//             case 3:
//                 System.out.println("Multiply: " + r1.multiply(r2));
//                 break;
//             case 4:
//                 try {
//                     System.out.println("Divide: " + r1.divide(r2));
//                 } catch (ArithmeticException | IllegalArgumentException e) {
//                     System.out.println("Division Error: " + e.getMessage());
//                 }
//                 break;
//             case 5:
//                 System.out.println("Is Equal: " + r1.isEqual(r2));
//                 break;
//             default:
//                 System.out.println("Invalid operation choice.");
//                 break;
//         }

//         scanner.close();
//     }

//     private static int getValidInteger(Scanner scanner, String prompt) {
//         int value = 0;
//         boolean isValid = false;
//         while (!isValid) {
//             System.out.print(prompt);
//             try {
//                 value = scanner.nextInt();
//                 isValid = true;
//             } catch (InputMismatchException e) {
//                 System.out.println("Error: Invalid input! Please enter a whole number.");
//                 scanner.nextLine(); 
//             }
//         }
//         return value;
//     }
//     private static int getValidDenominator(Scanner scanner, String prompt) {
//         int den;
//         do {
//             den = getValidInteger(scanner, prompt);
//             if (den == 0) {
//                 System.out.println("Error: Denominator cannot be zero! Please try again.");
//             }
//         } while (den == 0);
//         return den;
//     }
//     private static int getValidChoice(Scanner scanner, String prompt, int min, int max) {
//         int choice;
//         do {
//             choice = getValidInteger(scanner, prompt);
//             if (choice < min || choice > max) {
//                 System.out.println("Error: Please select a valid option between " + min + " and " + max + ".");
//             }
//         } while (choice < min || choice > max);
//         return choice;
//     }
// }

public class ratioMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Enter First Ratio R1 ---");
            int num1 = getValidInteger(scanner, "Enter R1 numerator (P): ");
            int den1 = getValidDenominator(scanner, "Enter R1 denominator (Q != 0): ");
            RatioADT r1 = new Ratio(num1, den1);

            System.out.println("\n--- Enter Second Ratio R2 ---");
            int num2 = getValidInteger(scanner, "Enter R2 numerator (P): ");
            int den2 = getValidDenominator(scanner, "Enter R2 denominator (Q != 0): ");
            RatioADT r2 = new Ratio(num2, den2);

            System.out.println("\nCreated Ratios (Auto-Simplified):");
            System.out.println("R1 = " + r1);
            System.out.println("R2 = " + r2);

            System.out.println("\nSelect an Operation:");
            System.out.println("1. Add (R1 + R2)");
            System.out.println("2. Subtract (R1 - R2)");
            System.out.println("3. Multiply (R1 * R2)");
            System.out.println("4. Divide (R1 / R2)");
            System.out.println("5. Check Equality (R1 == R2)");

            int choice = getValidChoice(scanner, "Enter choice (1-5): ", 1, 5);

            System.out.println("\n--- Result ---");
            switch (choice) {
                case 1 -> System.out.println("Add: " + r1.add(r2));
                case 2 -> System.out.println("Sub: " + r1.sub(r2));
                case 3 -> System.out.println("Multiply: " + r1.multiply(r2));
                case 4 -> {
                    try {
                        System.out.println("Divide: " + r1.divide(r2));
                    } catch (ArithmeticException e) {
                        System.out.println("Division Error: " + e.getMessage());
                    }
                }
                case 5 -> System.out.println("Is Equal: " + r1.isEqual(r2));
            }
        }
    }

    private static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid buffer
            }
        }
    }

    private static int getValidDenominator(Scanner scanner, String prompt) {
        int den;
        do {
            den = getValidInteger(scanner, prompt);
            if (den == 0) {
                System.out.println("Error: Denominator Q cannot be zero! Try again.");
            }
        } while (den == 0);
        return den;
    }

    private static int getValidChoice(Scanner scanner, String prompt, int min, int max) {
        int choice;
        do {
            choice = getValidInteger(scanner, prompt);
            if (choice < min || choice > max) {
                System.out.println("Error: Choice out of range. Select between " + min + " and " + max + ".");
            }
        } while (choice < min || choice > max);
        return choice;
    }
}