package HW3;

import java.util.EmptyStackException;

public class TwoStacks<T> {
    // Array to hold the elements of the two stacks
    private T[] arr;
    // Size of the array
    private int size;
    // Top of the first stack
    private int topStack1;
    // Top of the second stack
    private int topStack2;

    // Constructor: initializes the array and the two tops.
    public TwoStacks(int n) {
        size = n;
        arr =  (T[]) new Object[size];
        topStack1 = -1;       // Stack1 starts from the left end
        topStack2 = size;     // Stack2 starts from the right end
    }

    // Private helper method to resize the array when full
    @SuppressWarnings("unchecked")
    private void updateSize(int newSize) {
        T[] updatedArr = (T[]) new Object[newSize];
        for (int i = 0; i <= topStack1; i++) {
            updatedArr[i] = arr[i];
        }
        for (int i = size - 1, j = newSize - 1; i >= topStack2; i--, j--) {
            updatedArr[j] = arr[i];
        }
        topStack2 += (newSize - size);
        arr = updatedArr;
        size = newSize;
    }
 
    // Push an element onto Stack 1.
    public void pushStack1(T val) {
        if (topStack1 == topStack2 - 1) {
            updateSize(arr.length * 2 + 1);
        }
        arr[++topStack1] = val;
    }
    // Push an element onto Stack 2.
    public void pushStack2(T val) {
        if (topStack1 == topStack2 - 1) {
            updateSize(arr.length * 2 + 1);
        }
        arr[--topStack2] = val;
    }

    // Pop an element from Stack 1.
    public T popStack1() {
        // Check if Stack 1 is not empty
        if (topStack1 >= 0) {
            // Return the top element of Stack 1 and decrement top1
            return arr[topStack1--];
        } else {
            // Throw an exception if Stack 1 is empty
            throw new RuntimeException("Stack Underflow on Stack 1");
        }
    }

    // Pop an element from Stack 2.
    public T popStack2() {
        // Check if Stack 2 is not empty
        if (topStack2 < size) {
            // Return the top element of Stack 2 and increment top2
            return arr[topStack2++];
        } else {
            // Throw an exception if Stack 2 is empty
            throw new RuntimeException("Stack Underflow on Stack 2");
        }
    }

    // Peek the top element of Stack 1.
    public T peekStack1() {
        if (topStack1 >= 0) {
            return arr[topStack1];
        } else {
            throw new EmptyStackException();
        }
    }

    // Peek the top element of Stack 2.
    public T peekStack2() {
        if (topStack2 < size) {
            return arr[topStack2];
        } else {
            throw new EmptyStackException();
        }
    }

    // Return the size of Stack 1.
    public int sizeStack1() {
        return topStack1 + 1;
    }

    // Return the size of Stack 2.
    public int sizeStack2() {
        return size - topStack2;
    }

    // Check if Stack 1 is empty.
    public boolean isEmptyStack1() {
        return topStack1 == -1;
    }

    // Check if Stack 2 is empty.
    public boolean isEmptyStack2() {
        return topStack2 == size;
    }
}