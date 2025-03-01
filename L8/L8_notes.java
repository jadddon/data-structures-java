public class L8_notes {

    private int[] q;
    private int size;
    private int head;
    private int tail;

    public L8_notes(int capacity) {
        q = new int[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    void enqueue(int x){
        if (size == q.length){
            overflow();
        }
        tail = (tail + 1) % q.length;
        q[tail] = x;
        size++;
    }

    int dequeue(){
        if (size == 0) {
            underflow();
        }
        int r = q[head];
        head = (head + 1) % q.length;
        size--;
        return r;
    }

    private void overflow() {
        System.out.println("Queue overflow");
    }

    private void underflow() {
        System.out.println("Queue underflow");
    }
}