package HW3;

public class TwoStacks2<T> {
    // default array length to 10
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int firstStackCount, secondStackCount;

    @SuppressWarnings("unchecked")
    public TwoStacks2(){
        // begin first stack counter at -1
        firstStackCount = -1;
        // set second stack count to default capacity (10)
        secondStackCount = DEFAULT_CAPACITY;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    // method to push in first stack
    public void pushFirst(T x){
        // stack overflow warning, does not push if total size breaches 10
        if (sizeAggregate() == DEFAULT_CAPACITY) {
            System.out.println("Cannot push, stack overflow.");
            return;
        } else {
            // add element to first stack
            stack[++firstStackCount] = x;
        }
    }

    // remove most recent element in the first stack
    public T popFirst(){
        if (isFirstEmpty()) {
            return null;
        } else {
            T poppedFirstValue = stack[firstStackCount];
            stack[firstStackCount--] = null;
            return poppedFirstValue;
        }
    }

    // view most recent element in first stack
    public T peekFirst(){
        if (isFirstEmpty()) {
            return null;
        } else {
            return stack[firstStackCount];
        }
    }

    // check for first stack count equal to initial value (-1)
    public boolean isFirstEmpty(){
        return firstStackCount == -1;
    }

    // retrieve size of first stack
    public int sizeFirst(){
        return firstStackCount + 1;
    }

    // method to push in second stack
    public void pushSecond(T x){
        // stack overflow warning, does not push if total size breaches 10
        if (sizeAggregate() == DEFAULT_CAPACITY) {
            System.out.println("Cannot push, stack overflow.");
            return;
        }
        // add element to second stack
        stack[--secondStackCount] = x;
    }

    // remove most recent element in the second stack
    public T popSecond(){
        if (isSecondEmpty()) {
            return null;
        } else {
            T poppedSecondValue = stack[secondStackCount];
            stack[secondStackCount++] = null;
            return poppedSecondValue;
        }
    }

    // view most recent element in second stack
    public T peekSecond(){
        if (isSecondEmpty()) {
            return null;
        } else {
            return stack[secondStackCount];
        }
    }

    // check for first stack count equal to initial value (10)
    public boolean isSecondEmpty(){
        return secondStackCount == DEFAULT_CAPACITY;
    }

    // retrieve size of second stack
    public int sizeSecond(){
        return DEFAULT_CAPACITY - secondStackCount;
    }

    // methods for checking stack aggregates emptiness
    public boolean isAggregateEmpty(){
        return sizeAggregate() == 0;
    }

    // retrieve size of aggregated first and second stacks
    public int sizeAggregate(){
        return sizeFirst() + sizeSecond();
    }
}