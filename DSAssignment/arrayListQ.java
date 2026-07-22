package PFAssignments.DSAssignment;

import java.util.Arrays;

/**
 * Program to implement Array List using array. Array List should have following operations
    - adding a new item to an array list, determining whether it is already full, and then scaling the array list
    - Inserting a new item into an array list at given position 
    - Finding an item's first instance depending on its location.
    - Finding a specific item's first index in an arraylist
    - Removing a Item based on a certain Index
    - Remove a specific item from an arraylist based on value.
    - Reverse the entrire list
 */
public class arrayListQ {
    // private int[] data;
    // private int size; 
    // public arrayListQ(){
    //     this.data=new int[5];
    //     this.size =0;
    // }
    // public boolean isFull() {
    //     return size ==data.length;
    // }
    // private void scaleArray(){
    //     int newCapacity = data.length*2;
    //     int[] newArray= new int[newCapacity];
    //     for (int i = 0;i < size;i++) {
    //         newArray[i]= data[i];
    //     }
    //     data = newArray; 
    // }
    // public void add(int value){
    //     if (isFull()){
    //         scaleArray();
    //     }
    //     data[size] =value;
    //     size++;
    // }
    // public void insert(int index, int value){
    //     if (index < 0 || index > size){
    //         System.out.println("Invalid index for insert: " + index);
    //         return;
    //     }
    //     if (isFull()){
    //         scaleArray();
    //     }
    //     for(int i = size; i>index; i--){
    //         data[i] = data[i-1];
    //     }
    //     data[index]=value;
    //     size++;
    // }
    // public int get(int index){
    //     if (index < 0 || index >= size){
    //         System.out.println("Invalid index: " + index);
    //         return -1;
    //     }
    //     return data[index];
    // }
    // public int indexOf(int value) {
    //     for (int i = 0; i<size; i++){
    //         if (data[i]== value) {
    //             return i;
    //         }
    //     }
    //     return -1; 
    // }
    // public void removeAt(int index){
    //     if (index <0 || index>=size) {
    //         System.out.println("Invalid index to remove: " + index);
    //         return;
    //     }
    //     for (int i = index; i < size - 1; i++) {
    //         data[i] = data[i+1];
    //     }
    //     size--;
    // }
    // public boolean removeByValue(int value) {
    //     int targetIndex = indexOf(value);
    //     if (targetIndex!=-1) {
    //         removeAt(targetIndex);
    //         return true;
    //     }
    //     return false; 
    // }
    // public void reverse() {
    //     int left =0;
    //     int right =size-1;
    //     while (left < right) {
    //         int temp = data[left];
    //         data[left] = data[right];
    //         data[right] = temp;
    //         left++;
    //         right--;
    //     }
    // }
    // public void printList() {
    //     System.out.print("[");
    //     for (int i = 0; i < size; i++) {
    //         System.out.print(data[i]);
    //         if (i < size - 1) {
    //             System.out.print(", ");
    //         }
    //     }
    //     System.out.println("]");
    // }
    // public static void main(String[] args) {
    //     arrayListQ list = new arrayListQ();
    //     System.out.println("Add items: 10, 20 ,30");
    //     list.add(10);
    //     list.add(20);
    //     list.add(30);
    //     list.printList(); 

    //     System.out.println("\nInserting 15 at index 1:");
    //     list.insert(1, 15);
    //     list.printList(); 

    //     System.out.println("\nIndex lookup");
    //     System.out.println("Item at index 2: " + list.get(2));
    //     System.out.println("Index of value 30: " + list.indexOf(30));

    //     System.out.println("\nRemove item at inex");
    //     list.removeAt(0); 
    //     System.out.println("After remove: ");
    //     list.printList();

    //     System.out.println("Removing by value 20:");
    //     list.removeByValue(20);
    //     list.printList();

    //     System.out.println("\nReversing list");
    //     list.add(40);
    //     list.add(50);
    //     System.out.print("Before reverse:");
    //     list.printList();

    //     list.reverse();
    //     System.out.print("After reverse: ");
    //     list.printList();
    // }
    private static final int DEFAULT_CAPACITY = 5;

    private int[] data;
    private int size;

    /**
     * Initializes the dynamic array with a default initial capacity.
     */
    public arrayListQ() {
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns the current number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Doubles the capacity of the backing array when full using native memory copy.
     */
    private void scaleArray() {
        int newCapacity = data.length * 2;
        this.data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * Appends an element to the end of the list. O(1) amortized time complexity.
     */
    public void add(int value) {
        if (isFull()) {
            scaleArray();
        }
        data[size++] = value;
    }

    /**
     * Inserts an element at the specified position, shifting subsequent elements to the right.
     * Time Complexity: O(N) due to element shifting.
     */
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (isFull()) {
            scaleArray();
        }

        // Native block shift to the right
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    /**
     * Retrieves the element at the specified index. O(1) time complexity.
     */
    public int get(int index) {
        checkBounds(index);
        return data[index];
    }

    /**
     * Searches for the first occurrence of a value. Returns index or -1 if missing.
     */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the element at the specified position, shifting remaining elements left.
     * Time Complexity: O(N) due to element shifting.
     */
    public void removeAt(int index) {
        checkBounds(index);

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Native block shift to the left
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        size--;
    }

    /**
     * Removes the first occurrence of a specified value.
     */
    public boolean removeByValue(int value) {
        int targetIndex = indexOf(value);
        if (targetIndex != -1) {
            removeAt(targetIndex);
            return true;
        }
        return false;
    }

    /**
     * Reverses the elements in-place using a two-pointer technique. O(N) time complexity.
     */
    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        arrayListQ list = new arrayListQ();

        System.out.println("Adding elements: 10, 20, 30");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Current List: " + list);

        System.out.println("\nInserting 15 at index 1:");
        list.insert(1, 15);
        System.out.println("After insertion: " + list);

        System.out.println("\nLookups:");
        System.out.println("Item at index 2: " + list.get(2));
        System.out.println("Index of value 30: " + list.indexOf(30));

        System.out.println("\nRemoving at index 0:");
        list.removeAt(0);
        System.out.println("After removeAt(0): " + list);

        System.out.println("\nRemoving by value 20:");
        list.removeByValue(20);
        System.out.println("After removeByValue(20): " + list);

        System.out.println("\nReversing list:");
        list.add(40);
        list.add(50);
        System.out.println("Before reverse: " + list);

        list.reverse();
        System.out.println("After reverse: " + list);
    }
}
