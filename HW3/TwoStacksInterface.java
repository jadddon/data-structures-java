package HW3;

public interface TwoStacksInterface<T> {
    // Push an element onto Stack 1.
    void push1(T data);

    // Push an element onto Stack 2.
    void push2(T data);

    // Pop an element from Stack 1.
    T pop1();

    // Pop an element from Stack 2.
    T pop2();

    // Peek the top element of Stack 1.
    T peek1();

    // Peek the top element of Stack 2.
    T peek2();

    // Return the size of Stack 1.
    int size1();

    // Return the size of Stack 2.
    int size2();

    // Check if Stack 1 is empty.
    boolean isEmpty1();

    // Check if Stack 2 is empty.
    boolean isEmpty2(); 
    
}
