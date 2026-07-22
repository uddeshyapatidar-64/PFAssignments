package PFAssignments.oopsAssignment.ratioQ;


// public interface RatioADT {
//     int getP();
//     int getQ();
//     RatioADT add(RatioADT other);
//     RatioADT sub(RatioADT other);
//     RatioADT multiply(RatioADT other);
//     RatioADT divide(RatioADT other);
//     boolean isEqual(RatioADT other);
// }

public interface RatioADT {
    int getP();
    int getQ();
    RatioADT add(RatioADT other);
    RatioADT sub(RatioADT other);
    RatioADT multiply(RatioADT other);
    RatioADT divide(RatioADT other);
    boolean isEqual(RatioADT other);
}