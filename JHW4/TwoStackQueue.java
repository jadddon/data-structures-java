import java.util.Stack; 
import java.util.EmptyStackException;

public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{

    private Stack<T> S1;
    private Stack<T> S2;
    private int size; 

    public TwoStackQueue(){
        S1 = new Stack<>(); 
        S2 = new Stack<>(); 
        size = 0; 
    }

    // pushes to S1
    public void enqueue(T x){
        S1.push(x);
        size++; 
    }

    // pops from S2
	public T dequeue(){
        // we know popping returns the value 
        // we see if S2 is empty and if it is we can fill up the values
        if(S2.isEmpty()){ 
            if(S1.isEmpty()){
                throw new EmptyStackException();
            }
            while(!S1.empty()){
                S2.push(S1.pop());
            } 
        }
        size--;
        return S2.pop(); 
    }
	public int size(){
        return size;
    }
	public boolean isEmpty(){
        return size() == 0; 
    }

    public static void main(String[] args){
        TwoStackQueue<Integer> test = new TwoStackQueue<>(); 
        System.out.println("Current size: " + test.size()); 
        System.out.println("isEmpty: " + test.isEmpty()); 
        test.enqueue(24);
        test.enqueue(8); 
        System.out.println("Current size: " + test.size()); 
        System.out.println("isEmpty: " + test.isEmpty()); 
        System.out.println(test.dequeue()); 
        System.out.println("Current size: " + test.size()); 
        System.out.println("isEmpty: " + test.isEmpty()); 
        System.out.println(test.dequeue());
        System.out.println("Current size: " + test.size()); 
        System.out.println("isEmpty: " + test.isEmpty()); 
        
    }
}