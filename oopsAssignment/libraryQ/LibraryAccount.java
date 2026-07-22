package PFAssignments.oopsAssignment.libraryQ;

// public class LibraryAccount {

import java.util.Objects;

//     public static final int TEACHER_LIMIT = 5;
//     public static final int STUDENT_LIMIT = 3;

//     private String name;
//     private int accountNumber;
//     private String accountType;
//     private int borrowCapacity;
//     private int borrowBalance;  

//     public LibraryAccount(String name, int accountNumber, String accountType) {
//         if (name == null || name.trim().isEmpty()) {
//             throw new IllegalArgumentException("Account holder name cannot be empty.");
//         }
//         if (accountNumber <= 0) {
//             throw new IllegalArgumentException("Account number must be a positive integer.");
//         }

//         String formattedType = accountType.trim();
//         if (formattedType.equalsIgnoreCase("Teacher")) {
//             this.accountType = "Teacher";
//             this.borrowCapacity = TEACHER_LIMIT;
//         } else if (formattedType.equalsIgnoreCase("Student")) {
//             this.accountType = "Student";
//             this.borrowCapacity = STUDENT_LIMIT;
//         } else {
//             throw new IllegalArgumentException("Account type must be either teacher or student'.");
//         }

//         this.name = name.trim();
//         this.accountNumber = accountNumber;
//         this.borrowBalance = this.borrowCapacity; 
//     }

//     public void depositBack(int count) {
//         if (count <= 0) {
//             throw new IllegalArgumentException("Number of books to return must be greater than zero.");
//         }
//         int currentlyBorrowed = borrowCapacity - borrowBalance;
//         if (count > currentlyBorrowed) {
//             throw new IllegalArgumentException("Cannot return " + count + " books. You only have " + currentlyBorrowed + " books borrowed.");
//         }
//         this.borrowBalance += count;
//     }

//     public void borrowBook(int count) {
//         if (count <= 0) {
//             throw new IllegalArgumentException("Number of books to borrow must be greater than zero.");
//         }
//         if (count > this.borrowBalance) {
//             throw new IllegalArgumentException("Borrow request denied! You requested " + count + " books, but your remaining allowance is " + this.borrowBalance + ".");
//         }
//         this.borrowBalance -= count;
//     }

//     public void displayAccountInfo() {
//         System.out.println("\nLibrary Account Details: ");
//         System.out.println("Name : " + name);
//         System.out.println("Account Number : " + accountNumber);
//         System.out.println("Account Type   : " + accountType + " (Max Capacity: " + borrowCapacity + ")");
//         System.out.println("Books Borrowed : " + (borrowCapacity - borrowBalance));
//         System.out.println("Borrow Balance : " + borrowBalance + " books remaining");
//     }

//     public String getName() {
//         return name;
//     }

//     public int getBorrowBalance() {
//         return borrowBalance;
//     }
// }
public class LibraryAccount {
    private final String name;
    private final int accountNumber;
    private final AccountType accountType;
    private final int borrowCapacity;
    private int borrowBalance; // Represents remaining books allowed to borrow

    public LibraryAccount(String name, int accountNumber, AccountType accountType) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (accountNumber <= 0) {
            throw new IllegalArgumentException("Account number must be a positive integer.");
        }
        Objects.requireNonNull(accountType, "Account type cannot be null.");

        this.name = name.trim();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.borrowCapacity = accountType.getBorrowCapacity();
        this.borrowBalance = this.borrowCapacity;
    }

    /**
     * Borrow books after verifying remaining allowance.
     */
    public void borrowBook(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Number of books to borrow must be greater than zero.");
        }
        if (count > this.borrowBalance) {
            throw new IllegalArgumentException(
                "Borrow request denied! Requested: " + count + ", Remaining Allowance: " + this.borrowBalance
            );
        }
        this.borrowBalance -= count;
    }

    /**
     * Deposit/return books back to the library.
     */
    public void depositBack(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Number of books to return must be greater than zero.");
        }
        int currentlyBorrowed = getCurrentlyBorrowed();
        if (count > currentlyBorrowed) {
            throw new IllegalArgumentException(
                "Cannot return " + count + " books. You currently have " + currentlyBorrowed + " books borrowed."
            );
        }
        this.borrowBalance += count;
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Library Account Details ---");
        System.out.println("Name            : " + name);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Account Type    : " + accountType + " (Limit: " + borrowCapacity + ")");
        System.out.println("Books Borrowed  : " + getCurrentlyBorrowed());
        System.out.println("Borrow Allowance: " + borrowBalance + " books remaining");
        System.out.println("-------------------------------");
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getBorrowBalance() {
        return borrowBalance;
    }

    public int getCurrentlyBorrowed() {
        return borrowCapacity - borrowBalance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LibraryAccount other)) return false;
        return this.accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "LibraryAccount[No=" + accountNumber + ", Name=" + name + ", Type=" + accountType + "]";
    }
}