package PFAssignments.DSAssignment;
/**
 * Program to implement a Linkedlist that should contain below operations:
    - Creation of linked list
    - Add the particular item in the linked list at the particular position
    - Removal of an item based on its value   
    - Removal of an item based on its index
    - Retrieval of an item of particular indexf)Reversal of linked list
    - Sorting of linked list
 */
public class linkedListQ{
//     private class Node{
//         int data;
//         Node next;
//         Node(int data){
//             this.data=data;
//             this.next=null;
//         }
//     }
//     private Node head; 
//     private int size; 
//     public linkedListQ() {
//         this.head = null;
//         this.size = 0;
//     }
//     public void add(int value){
//         insert(size, value);
//     }
//     public void insert(int index, int value){
//         if (index<0|| index>size) {
//             System.out.println("Invalid index for insert: " + index);
//             return;
//         }
//         Node newNode = new Node(value);
//         if (index == 0){
//             newNode.next=head;
//             head=newNode;
//         }else{
//             Node current=head;
//             for(int i = 0;i<index-1; i++){
//                 current=current.next;
//             }
//             newNode.next =current.next;
//             current.next=newNode;
//         }
//         size++;
//     }
//     public boolean removeByValue(int value){
//         if (head==null){
//             System.out.println("List is empty");
//             return false;
//         }
//         if(head.data==value){
//             head=head.next;
//             size--;
//             return true;
//         }

//         Node current=head;
//         while (current.next!=null&&current.next.data!=value){
//             current=current.next;
//         }
//         if(current.next != null){
//             current.next=current.next.next; 
//             size--;
//             return true;
//         }
//         System.out.println("Value " + value + " not found in the list");
//         return false;
//     }
//     public void removeAt(int index){
//         if(index<0||index>=size){
//             System.out.println("Invalid index for removal: " + index);
//             return;
//         }
//         if(index==0){
//             head=head.next;
//         }else{
//             Node current=head;
//             for (int i = 0; i < index - 1; i++){
//                 current=current.next;
//             }
//             current.next =current.next.next; 
//         }
//         size--;
//     }
//     public int get(int index){
//         if (index<0 || index>=size) {
//             System.out.println("Invalid index: " + index);
//             return -1;
//         }
//         Node current=head;
//         for (int i =0; i<index; i++) {
//             current = current.next;
//         }
//         return current.data;
//     }
//     public void reverse(){
//         Node previous=null;
//         Node current=head;
//         Node next=null;
//         while(current!=null) {
//             next=current.next;
//             current.next= previous;
//             previous= current;     
//             current= next;         
//         }
//         head=previous; 
//     }
//     public void sort(){
//         if(size<=1){
//             return; 
//         }
//         for (int i = 0;i<size-1; i++){
//             Node current=head;
//             Node next=head.next;
//             for(int j = 0;j<size-1-i; j++){
//                 if (current.data>next.data){
//                     int temp=current.data;
//                     current.data=next.data;
//                     next.data=temp;
//                 }
//                 current=next;
//                 next=next.next;
//             }
//         }
//     }
//     public void printList(){
//         if(head==null){
//             System.out.println("[]");
//             return;
//         }
//         System.out.print("[");
//         Node current=head;
//         while(current!=null){
//             System.out.print(current.data);
//             if (current.next!=null) {
//                 System.out.print("->");
//             }
//             current=current.next;
//         }
//         System.out.println("]");
//     }
//     public static void main(String[] args){
//         linkedListQ list = new linkedListQ();
//         System.out.println(">Adding Items 30,10,40");
//         list.add(30);
//         list.add(10);
//         list.add(40);
//         list.printList(); 

//         System.out.println("\n>Insert 20 at index 1");
//         list.insert(1, 20);
//         list.printList(); 
//         System.out.println("\n>Retrieval");
//         System.out.println("Item at index 2: " + list.get(2)); 

//         System.out.println("\n>Sorting the List");
//         list.sort();
//         System.out.print("Sorted List: ");
//         list.printList(); 

//         System.out.println("\n>Reversing the List");
//         list.reverse();
//         System.out.print("Reversed List: ");
//         list.printList(); 

//         System.out.println("\n>Removal by Value 30");
//         list.removeByValue(30);
//         list.printList();

//         System.out.println("\n>Removal by Index 0");
//         list.removeAt(0);
//         list.printList(); 
//     }
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public linkedListQ() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends an item to the end of the list in O(1) constant time using the tail pointer.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts an item at a specific index. Time Complexity: O(N) worst-case.
     */
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index for insert: " + index + ", Size: " + size);
        }

        if (index == size) {
            add(value);
            return;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = getNodeAt(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Removes the first node containing the specified value.
     */
    public boolean removeByValue(int value) {
        if (isEmpty()) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }

    /**
     * Removes the node at the specified index.
     */
    public void removeAt(int index) {
        checkBounds(index);

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node prev = getNodeAt(index - 1);
            if (prev.next == tail) {
                tail = prev;
            }
            prev.next = prev.next.next;
        }
        size--;
    }

    /**
     * Retrieves the value at the specified index.
     */
    public int get(int index) {
        checkBounds(index);
        return getNodeAt(index).data;
    }

    /**
     * Reverses the linked list in-place in O(N) time.
     */
    public void reverse() {
        if (size <= 1) {
            return;
        }

        Node previous = null;
        Node current = head;
        Node next = null;

        tail = head; // Old head becomes the new tail

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous; // Previous is now the new head
    }

    /**
     * Sorts the linked list using Merge Sort in O(N log N) time complexity.
     */
    public void sort() {
        if (size <= 1) {
            return;
        }
        head = mergeSort(head);
        
        // Re-sync tail reference after sort
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null; // Split list into two halves

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private Node getMiddle(Node node) {
        if (node == null) return node;
        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node getNodeAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        linkedListQ list = new linkedListQ();

        System.out.println("Adding Items: 30, 10, 40");
        list.add(30);
        list.add(10);
        list.add(40);
        System.out.println("Initial List: " + list);

        System.out.println("\nInserting 20 at index 1:");
        list.insert(1, 20);
        System.out.println("After insertion: " + list);

        System.out.println("\nRetrieval:");
        System.out.println("Item at index 2: " + list.get(2));

        System.out.println("\nSorting the List (Merge Sort O(N log N)):");
        list.sort();
        System.out.println("Sorted List: " + list);

        System.out.println("\nReversing the List:");
        list.reverse();
        System.out.println("Reversed List: " + list);

        System.out.println("\nRemoval by Value (30):");
        list.removeByValue(30);
        System.out.println("After removal: " + list);

        System.out.println("\nRemoval by Index (0):");
        list.removeAt(0);
        System.out.println("After removal: " + list);
    }
}
