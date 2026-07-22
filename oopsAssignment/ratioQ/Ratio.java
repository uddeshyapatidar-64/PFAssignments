package PFAssignments.oopsAssignment.ratioQ;

// import java.util.Objects;

// public final class Ratio implements RatioADT {
//     private final int p; 
//     private final int q; 

//     public Ratio(int p, int q) {
//         if (q == 0) {
//             throw new IllegalArgumentException("Denominator Q cannot be zero.");
//         }
//         if (q < 0) {
//             p = -p;
//             q = -q;
//         }
//         int commonDivisor = gcd(Math.abs(p), q);
//         this.p = p / commonDivisor;
//         this.q = q / commonDivisor;
//     }

//     @Override
//     public int getP() {
//         return p;
//     }

//     @Override
//     public int getQ() {
//         return q;
//     }

//     @Override
//     public RatioADT add(RatioADT other) {
//         Objects.requireNonNull(other, "Ratio to add cannot be null.");
//         int newP = (this.p * other.getQ()) + (other.getP() * this.q);
//         int newQ = this.q * other.getQ();
//         return new Ratio(newP, newQ);
//     }

//     @Override
//     public RatioADT sub(RatioADT other) {
//         Objects.requireNonNull(other, "Ratio to subtract cannot be null.");
//         int newP = (this.p * other.getQ()) - (other.getP() * this.q);
//         int newQ = this.q * other.getQ();
//         return new Ratio(newP, newQ);
//     }

//     @Override
//     public RatioADT multiply(RatioADT other) {
//         Objects.requireNonNull(other, "Ratio to multiply cannot be null.");
//         int newP = this.p * other.getP();
//         int newQ = this.q * other.getQ();
//         return new Ratio(newP, newQ);
//     }

//     @Override
//     public RatioADT divide(RatioADT other) {
//         Objects.requireNonNull(other, "Ratio to divide cannot be null.");
//         if (other.getP() == 0) {
//             throw new ArithmeticException("Cannot divide by a ratio with zero numerator (division by zero).");
//         }
//         int newP = this.p * other.getQ();
//         int newQ = this.q * other.getP();
//         return new Ratio(newP, newQ);
//     }

//     @Override
//     public boolean isEqual(RatioADT other) {
//         if (other == null) return false;
//         return (this.p * other.getQ()) == (other.getP() * this.q);
//     }
//     private static int gcd(int a, int b) {
//         while (b != 0) {
//             int temp = b;
//             b = a % b;
//             a = temp;
//         }
//         return a;
//     }

//     @Override
//     public String toString() {
//         return p + "/" + q;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (!(obj instanceof RatioADT)) return false;
//         return isEqual((RatioADT) obj);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(p, q);
//     }
// }

import java.util.Objects;

/**
 * Immutable implementation of RatioADT.
 * Automatically simplifies P and Q to lowest terms using GCD upon instantiation.
 */
public final class Ratio implements RatioADT {
    private final int p;
    private final int q;

    public Ratio(int p, int q) {
        if (q == 0) {
            throw new IllegalArgumentException("Denominator Q cannot be zero.");
        }
        
        // Normalize sign so denominator is always positive
        if (q < 0) {
            p = -p;
            q = -q;
        }

        int commonDivisor = gcd(Math.abs(p), q);
        this.p = p / commonDivisor;
        this.q = q / commonDivisor;
    }

    @Override
    public int getP() {
        return p;
    }

    @Override
    public int getQ() {
        return q;
    }

    @Override
    public RatioADT add(RatioADT other) {
        Objects.requireNonNull(other, "Ratio to add cannot be null.");
        int newP = Math.addExact(Math.multiplyExact(this.p, other.getQ()), Math.multiplyExact(other.getP(), this.q));
        int newQ = Math.multiplyExact(this.q, other.getQ());
        return new Ratio(newP, newQ);
    }

    @Override
    public RatioADT sub(RatioADT other) {
        Objects.requireNonNull(other, "Ratio to subtract cannot be null.");
        int newP = Math.subtractExact(Math.multiplyExact(this.p, other.getQ()), Math.multiplyExact(other.getP(), this.q));
        int newQ = Math.multiplyExact(this.q, other.getQ());
        return new Ratio(newP, newQ);
    }

    @Override
    public RatioADT multiply(RatioADT other) {
        Objects.requireNonNull(other, "Ratio to multiply cannot be null.");
        int newP = Math.multiplyExact(this.p, other.getP());
        int newQ = Math.multiplyExact(this.q, other.getQ());
        return new Ratio(newP, newQ);
    }

    @Override
    public RatioADT divide(RatioADT other) {
        Objects.requireNonNull(other, "Ratio to divide cannot be null.");
        if (other.getP() == 0) {
            throw new ArithmeticException("Cannot divide by a ratio with zero numerator (division by zero).");
        }
        int newP = Math.multiplyExact(this.p, other.getQ());
        int newQ = Math.multiplyExact(this.q, other.getP());
        return new Ratio(newP, newQ);
    }

    @Override
    public boolean isEqual(RatioADT other) {
        if (other == null) return false;
        // Since terms are auto-simplified in constructor, cross-multiplication verifies equivalence safely
        return (long) this.p * other.getQ() == (long) other.getP() * this.q;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return p + "/" + q;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ratio)) return false;
        Ratio other = (Ratio) obj;
        return this.p == other.p && this.q == other.q;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, q);
    }
}