/**
 * This program demonstrates the use of recursion in Java.
 * It includes methods to calculate the factorial of a number and the nth Fibonacci number.
 * The main method allows the user to input a number and see the result of the factorial and Fibonacci calculations.
 */

public class Recursion {

    // Method to calculate factorial of a number
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if(n==0) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n*factorial(n-1);
    }

    // Method to calculate nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases: Fibonacci sequence starts with 1 and 1
        if(n==0) {
            return 1;
        } else if(n==1) {
            return 1;
        }
        // Recursive case: Fibonacci number is the sum of the two preceding ones
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        // Parse the first command line argument to an integer
        int x = Integer.parseInt(args[0]);
        // Print the nth Fibonacci number
        System.out.println( fibonacci(x) );
    }

}