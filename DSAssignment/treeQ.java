package PFAssignments.DSAssignment;

import java.util.Scanner;

    public class treeQ {
     
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public treeQ() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserts a value into the BST.
     */
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        // Duplicate values are ignored by default in standard BSTs
        return current;
    }

    /**
     * Public driver for In-Order Traversal (Left, Root, Right).
     */
    public void printInOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    /**
     * Public driver for Pre-Order Traversal (Root, Left, Right).
     */
    public void printPreOrder() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     * Public driver for Post-Order Traversal (Left, Right, Root).
     */
    public void printPostOrder() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        treeQ bst = new treeQ();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of insertions: ");
            int inputCount = scanner.nextInt();
            
            for (int i = 0; i < inputCount; i++) {
                System.out.print("Enter value " + (i + 1) + ": ");
                int temp = scanner.nextInt();
                bst.insert(temp);
            }
        } catch (Exception e) {
            System.out.println("Invalid input stream or scanner error encountered.");
        }

        System.out.println("\n--- Tree Traversals ---");
        System.out.print("In-Order:   ");
        bst.printInOrder();

        System.out.print("Pre-Order:  ");
        bst.printPreOrder();

        System.out.print("Post-Order: ");
        bst.printPostOrder();
    }
}

