package HW4;

import java.util.Stack;

public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    
    // S1 for enqueue 
    private Stack<T> S1;
    // S2 for dequeue
    private Stack<T> S2;
    
    // init stacks
    public TwoStackQueue() {
        S1 = new Stack<>(); 
        S2 = new Stack<>(); 
    }
    
    //look to see if empty 
    public boolean isEmpty() {
        // Time complexity: O(1)
        return S1.isEmpty() && S2.isEmpty(); //both stacks must be empty
    }

    // size of queue  
    public int size() {
        // Time complexity: O(1)
        // Size is the sum of elements in both stacks
        return S1.size() + S2.size(); // take sum of both  
    }

    // add element  
    public void enqueue(T x) {
        // Time complexity: O(1)
        S1.push(x); // push element to S1
    }
    
    // pop and return element 
    public T dequeue() {
        // Amortized time complexity: O(1)
        if (S2.isEmpty()) {
            while (!S1.isEmpty()) {    //  elements from S1 to S2 to reverse
                S2.push(S1.pop());
            }
        }
        // queue is empty
        if (S2.isEmpty()) {
            throw new RuntimeException("empty");
        }
        // pop top of s2
        return S2.pop();
    }
    
    // test main method
    public static void main(String[] args){
        TwoStackQueue<Integer> test = new TwoStackQueue<>(); // Create a new queue
        System.out.println("Current size: " + test.size()); // Print current size
        System.out.println("isEmpty: " + test.isEmpty()); // Check if queue is empty
        test.enqueue(3); // Enqueue element 3
        test.enqueue(4); // Enqueue element 4
        test.enqueue(5); // Enqueue element 5
        System.out.println("Current size: " + test.size()); // Print current size
        System.out.println("isEmpty: " + test.isEmpty()); // Check if queue is empty
        System.out.println(test.dequeue()); // Dequeue and print element
        System.out.println("Current size: " + test.size()); // Print current size
        System.out.println("isEmpty: " + test.isEmpty()); // Check if queue is empty
        System.out.println(test.dequeue()); // Dequeue and print element
        System.out.println("Current size: " + test.size()); // Print current size
        System.out.println("isEmpty: " + test.isEmpty()); // Check if queue is empty
        System.out.println(test.dequeue()); // Dequeue and print element
        System.out.println("Current size: " + test.size()); // Print current size
        System.out.println("isEmpty: " + test.isEmpty()); // Check if queue is empty
    }
}
