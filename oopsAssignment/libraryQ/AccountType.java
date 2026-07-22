package PFAssignments.oopsAssignment.libraryQ;

public enum AccountType {
    TEACHER(5),
    STUDENT(3);

    private final int borrowCapacity;

    AccountType(int borrowCapacity) {
        this.borrowCapacity = borrowCapacity;
    }

    public int getBorrowCapacity() {
        return borrowCapacity;
    }
}
