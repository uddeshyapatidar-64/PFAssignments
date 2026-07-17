package PFAssignments.DataStructure;

import java.util.ArrayList;
import java.util.List;
public class arrayListQ2 {
    public record Result(int min, int max){
        @Override
        public String toString(){
            return String.format("Min: %d, Max: %d", min, max);
        }
    }
    public static Result findresult(ArrayList<Integer> numbers){
        if(numbers == null || numbers.isEmpty()){
            throw new IllegalArgumentException("Cannot find min max of a null or empty ArrayList.");
        }
        int firstElement = numbers.get(0);
        int min = firstElement;
        int max = firstElement;
        for(int current : numbers){
            if(max<current){
                max = current;
            } else if(current < min){
                min = current;
            }
        }
        return new Result(min, max);
    }
    public static void main(String[] args) {
        ArrayList<Integer> dataset = new ArrayList<>(List.of(12,34,1,3,0,99));
        try {
            System.out.println("Existing Dataset: " + dataset);
            Result result = findresult(dataset);
            System.out.println("Max in arraylist is: " +result.max()+" and Min in arraylist is: "+result.min());
        } catch (Exception e) {
            System.out.println("An unexpectted system error occurred: " + e.getMessage());
        }
    }
}
