package HW3;

public class SinglyLinkedReversalO1 {
    // Define the Node class for the singly linked list
    public static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Iterative method to print the linked list in reverse order using O(1) extra space.
     * The original list is not modified.
     * Runtime: O(n²)
     */
    public static void printReverseO1(Node head) {
        // Step 1: Count the number of nodes in the list.
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Step 2: For each index from count - 1 down to 0, traverse the list to that index and print the node.
        for (int i = count - 1; i >= 0; i--) {
            current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            System.out.println(current.data);
        }
    }
    
    // Sample usage of the printReverseO1 method
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        // Print the list in reverse order
        printReverseO1(head);
    }
}