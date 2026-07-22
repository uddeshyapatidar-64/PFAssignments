package PFAssignments.oopsAssignment.libraryQ;

import java.util.InputMismatchException;
import java.util.Scanner;

// public class LibraryMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         String name = getValidString(scanner, "Enter Account Holder Name: ");
//         int accNum = getValidPositiveInt(scanner, "Enter Account Number: ");
//         String accType = getValidAccountType(scanner, "Enter Account Type (Teacher / Student): ");
//         LibraryAccount account = new LibraryAccount(name, accNum, accType);
//         System.out.println("\nAccount successfully created for " + account.getName() + "!");
//         boolean exitProgram = false;
//         do {
//             System.out.println("1. Borrow Books");
//             System.out.println("2. Return / Deposit Books Back");
//             System.out.println("3. Display Account Details & Balance");
//             System.out.println("4. Exit");
//             int choice = getValidChoice(scanner, "Enter choice (1-4): ", 1, 4);
//             switch (choice) {
//                 case 1:
//                     int booksToBorrow = getValidPositiveInt(scanner, "Enter number of books to borrow: ");
//                     try {
//                         account.borrowBook(booksToBorrow);
//                         System.out.println("Borrowed " + booksToBorrow + " books. Remaining: " + account.getBorrowBalance());
//                     } catch (IllegalArgumentException e) {
//                         System.out.println("Error: " + e.getMessage());
//                     }
//                     break;

//                 case 2:
//                     int booksToReturn = getValidPositiveInt(scanner, "Enter number of books to return: ");
//                     try {
//                         account.depositBack(booksToReturn);
//                         System.out.println("Returned " + booksToReturn + " books. Now remaining: " + account.getBorrowBalance());
//                     } catch (IllegalArgumentException e) {
//                         System.out.println("Error: " + e.getMessage());
//                     }
//                     break;
//                 case 3:
//                     account.displayAccountInfo();
//                     break;
//                 case 4:
//                     exitProgram = true;
//                     break;
//                 default:
//                     System.out.println("Invalid option.");
//                     break;
//             }
//         } while (!exitProgram);

//         scanner.close();
//     }

//     private static String getValidString(Scanner scanner, String prompt) {
//         String input = "";
//         boolean isValid = false;
//         while (!isValid) {
//             System.out.print(prompt);
//             input = scanner.nextLine().trim();
//             if (!input.isEmpty()) {
//                 isValid = true;
//             } else {
//                 System.out.println("Error: Field cannot be empty. Please try again.");
//             }
//         }
//         return input;
//     }

//     private static int getValidPositiveInt(Scanner scanner, String prompt) {
//         int value = 0;
//         boolean isValid = false;

//         while (!isValid) {
//             System.out.print(prompt);
//             try {
//                 value = scanner.nextInt();
//                 if (value > 0) {
//                     isValid = true;
//                 } else {
//                     System.out.println("Error: Please enter a positive integer greater than 0.");
//                 }
//             } catch (InputMismatchException e) {
//                 System.out.println("Error: Invalid input! Please enter a valid number.");
//             } finally {
//                 scanner.nextLine();
//             }
//         }
//         return value;
//     }

//     private static String getValidAccountType(Scanner scanner, String prompt) {
//         String type = "";
//         boolean isValid = false;
//         while (!isValid) {
//             System.out.print(prompt);
//             type = scanner.nextLine().trim();
//             if (type.equalsIgnoreCase("Teacher") || type.equalsIgnoreCase("Student")) {
//                 isValid = true;
//             } else {
//                 System.out.println("Error: Invalid type! Account type must be teacher or student.");
//             }
//         }
//         return type;
//     }

//     private static int getValidChoice(Scanner scanner, String prompt, int min, int max) {
//         int choice;
//         do {
//             choice = getValidPositiveInt(scanner, prompt);
//             if (choice < min || choice > max) {
//                 System.out.println("Error: Option out of range. Select between " + min + " and " + max + ".");
//             }
//         } while (choice < min || choice > max);

//         return choice;
//     }
// }
public class LibraryMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== School Library Management System ===");
            
            String name = getValidString(scanner, "Enter Account Holder Name: ");
            int accNum = getValidPositiveInt(scanner, "Enter Account Number: ");
            AccountType accType = getValidAccountType(scanner, "Enter Account Type (Teacher / Student): ");

            LibraryAccount account = new LibraryAccount(name, accNum, accType);
            System.out.println("\nAccount successfully created for " + account.getName() + "!");

            boolean exitProgram = false;
            do {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Borrow Books");
                System.out.println("2. Return / Deposit Books Back");
                System.out.println("3. Display Account Details & Balance");
                System.out.println("4. Exit");

                int choice = getValidChoice(scanner, "Enter choice (1-4): ", 1, 4);

                switch (choice) {
                    case 1 -> {
                        int booksToBorrow = getValidPositiveInt(scanner, "Enter number of books to borrow: ");
                        try {
                            account.borrowBook(booksToBorrow);
                            System.out.println("Successfully borrowed " + booksToBorrow + " book(s). Remaining allowance: " + account.getBorrowBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        int booksToReturn = getValidPositiveInt(scanner, "Enter number of books to return: ");
                        try {
                            account.depositBack(booksToReturn);
                            System.out.println("Successfully returned " + booksToReturn + " book(s). Remaining allowance: " + account.getBorrowBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> account.displayAccountInfo();
                    case 4 -> {
                        System.out.println("Thank you for using the Library Management System!");
                        exitProgram = true;
                    }
                }
            } while (!exitProgram);
        }
    }

    private static String getValidString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: Field cannot be empty. Please try again.");
        }
    }

    private static int getValidPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Error: Please enter a positive integer greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid whole number.");
            }
        }
    }

    private static AccountType getValidAccountType(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            for (AccountType type : AccountType.values()) {
                if (type.name().equalsIgnoreCase(input)) {
                    return type;
                }
            }
            System.out.println("Error: Invalid account type! Please enter 'Teacher' or 'Student'.");
        }
    }

    private static int getValidChoice(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int choice = getValidPositiveInt(scanner, prompt);
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Error: Option out of range. Select between " + min + " and " + max + ".");
        }
    }
}