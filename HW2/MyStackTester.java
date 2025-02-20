package HW2;

public class MyStackTester {
    public static void main(String[] args) {
        MyStack<String> test = new MyStack<>();

        System.out.println(test.size());
        System.out.println(test.isEmpty());

        test.push("A");
        System.out.println(test.peek());

        test.push("B");
        test.push("C");
        test.push("D");
        test.push("E");

        System.out.println(test.size());
    
        test.pop();
        test.pop();
        test.pop();
        
        System.out.println(test.size());

        System.out.println(test.peek());
    }
}
