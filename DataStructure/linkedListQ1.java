package PFAssignments.DataStructure;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class linkedListQ1 {
    public static void main(String[] args) {
        LinkedList<Integer> dataset = new LinkedList<>(List.of(1,2,3,4,5,6));
        System.out.println("Current dataset: " + dataset);
        try(Scanner Scanner = new Scanner(System.in)){
            System.out.print("Enter the target value: ");
            int target = Scanner.nextInt();
            int result = findTargetIndex(dataset, target);
            if(result != -1){
                System.out.println("Target: " + target+ " found at index: "+result);
            }else{
                System.out.println("Target not found in dataset");
            }
        }catch(Exception e){
            System.out.println("Unexpected error occurred: "+e.getMessage());
        }
    }
    public static int findTargetIndex(LinkedList list, int target){
        if(list == null || list.isEmpty()){
            return -1;
        }
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            int currentIndex = iterator.nextIndex();
            Integer currentValue = iterator.next();
            if(currentValue != null && currentValue.equals(target)){
                return currentIndex;
            }
        }
        return  -1;
    }
}
