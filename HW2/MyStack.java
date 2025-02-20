package HW2;

import java.util.EmptyStackException;

public class MyStack<T> implements MyStackInterface<T> {
    //initial size of stack
    private static final int DEFAULT_SIZE = 20;

    private T[] stack;

    private int size;

    // myStack constructor
    @SuppressWarnings("unchecked")
    public MyStack() {
        stack = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    // private helper method that allows me to update the size of the stack array -- ref ensureCapacity in textbook
    @SuppressWarnings("unchecked")
    private void updateSize(int newSize){
        T[] updatedStack = (T[]) new Object[newSize];
        for (int i=0; i<size; i++){
            updatedStack[i] = stack[i];
        }
        stack = updatedStack;
    }

    // push method to add item to top
    public void push(T x){
        if (size == stack.length){
            updateSize(stack.length * 2 + 1);
        }
        stack[size++] = x;
    }

    // pop method to delete top item in the stack
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T item = stack[--size];
        stack[size] = null;
        return item;

    }

    // peak method to return top item
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    // size method to return size of stack
    public int size(){
        return size;
    }


    // isEmpty method to determine if stack is empty
    public boolean isEmpty(){
        return size == 0;
    }
    
}
