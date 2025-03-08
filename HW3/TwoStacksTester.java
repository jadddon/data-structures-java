package HW3;

public class TwoStacksTester {
    public static void main(String[] args) {
        // Create an instance of TwoStacks with a small initial size
        TwoStacks stacks = new TwoStacks(5);

        // Test pushing onto Stack 1
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);

        // Test pushing onto Stack 2
        stacks.push2(40);
        stacks.push2(50);

        // Test peeking from Stack 1
        System.out.println("Top of Stack 1: " + stacks.peek1()); // Should print 30

        // Test peeking from Stack 2
        System.out.println("Top of Stack 2: " + stacks.peek2()); // Should print 50

        // Test popping from Stack 1
        System.out.println("Popped from Stack 1: " + stacks.pop1()); // Should print 30
        System.out.println("Popped from Stack 1: " + stacks.pop1()); // Should print 20

        // Test popping from Stack 2
        System.out.println("Popped from Stack 2: " + stacks.pop2()); // Should print 50
        System.out.println("Popped from Stack 2: " + stacks.pop2()); // Should print 40

        // Test size methods
        System.out.println("Size of Stack 1: " + stacks.size1()); // Should print 1
        System.out.println("Size of Stack 2: " + stacks.size2()); // Should print 0

        // Test isEmpty methods
        System.out.println("Is Stack 1 empty? " + stacks.isEmpty1()); // Should print false
        System.out.println("Is Stack 2 empty? " + stacks.isEmpty2()); // Should print true

        // Test pushing more elements to trigger resizing
        stacks.push1(60);
        stacks.push1(70);
        stacks.push1(80);
        stacks.push1(90); // This should trigger resizing

        // Test the state after resizing
        System.out.println("Top of Stack 1 after resizing: " + stacks.peek1()); // Should print 90
        System.out.println("Size of Stack 1 after resizing: " + stacks.size1()); // Should print 5
    }
}
