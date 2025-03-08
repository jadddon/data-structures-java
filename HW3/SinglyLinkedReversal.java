package HW3;

public class SinglyLinkedReversal {
    // Define the Node class for the singly linked list
    public static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null; // Initialize next as null
        }
    }
    
    // Iterative method to print the linked list in reverse order without modifying the original list.
    public static void printReverse(Node head) {
        // Create a new reversed copy of the linked list.
        Node reversedHead = null; // Initialize the head of the reversed list as null
        Node current = head; // Start from the head of the original list
        
        // Traverse the original list and build the reversed list
        while (current != null) {
            // Create a new node with the same val as current node
            Node newNode = new Node(current.val);
            // Insert the new node at the beginning of the reversed list
            newNode.next = reversedHead; // Set the next of the new node to the current head of the reversed list
            reversedHead = newNode; // Update the head of the reversed list to the new node
            
            current = current.next; // Move to the next node in the original list
        }
        
        // Traverse the reversed list and print each element
        current = reversedHead; // Start from the head of the reversed list
        while (current != null) {
            System.out.println(current.val); // Print the val of the current node
            current = current.next; // Move to the next node in the reversed list
        }
    }
    
    // Sample usage of the printReverse method
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1); // Head of the list
        head.next = new Node(2); // Second node
        head.next.next = new Node(3); // Third node
        head.next.next.next = new Node(4); // Fourth node
        
        // Print the list in reverse: 4, 3, 2, 1
        printReverse(head); // Call the printReverse method with the head of the list
    }
}