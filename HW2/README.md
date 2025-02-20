Homework 2

Please remember that to submit the assignment you must click Mark as Complete under the Education menu in the toolbar.
Introduction to Interfaces

Throughout this course, we will use interfaces to provide the requirements for the code you’ll be required to write. An interface specifies a list of methods that any class implementing it must provide. In this assignment, we will provide you with an interface for each class you need to implement. This means that any class you write must have implementations of every method that its interface specifies, otherwise it won’t compile!

For more detail on interfaces, see the Oracle documentation.
Problem 1 - 20 points

In a file called BigO.java, implement BigOInterface and write methods that have the following runtime requirements:

    cubic must be O(n^3)
    exp must be O(2^n)
    constant must be O(1)

Where n is an integer which is passed into the function. The methods can contain any code fragments of your choice. However, in order to receive any credit, the runtime requirements must be satisfied. As in the previous two problems, you must implement the interface to receive full credit.

In addition to writing the code fragments, we will explore their actual runtimes, to observe big-O in action in the real world. In a file called Problem3.java write a main method which runs the code with various values of n and measures their runtime. Then, discuss the results you observed briefly in a file called Problem3.txt.

Please run each of your methods with multiple different values of n and include the elapsed time for each of these runs and the corresponding value of n in Problem3.txt.

To properly time code runtime in Java, we must disable compiler optimizations. We do this by running the code with the -Xint flag, for example: java -Xint Problem3. The easiest way to time your run is to wrap each fragment with the following code:

long startTime = System.nanoTime();
// YOUR CODE HERE
long endTime = System.nanoTime();

The elapsed time is the difference between these two variables.

Note also that you may see slightly erratic results due to noise and memory allocation delays. This may be one of the factors you discuss in addressing outliers.
Problem 2 - MyStack - 15 points

Recall from class the underlying implementation of Java’s ArrayList. It uses a regular Java array to store data and resizes to a larger array once it is full. Implement a stack in a class called MyStack that uses an array to store data and resizes the array when necessary. All methods should run in constant time, except when the array must be resized (this is still amortized constant time).

NOTE: Your class must implement MyStackInterface for full credit. You are not allowed to use any List object as your instance variable. You are only allowed to use arrays as your data retaining instance variable. Your MyStack must be generic as well.
Problem 3 - Palindrome Checker - 15 Points

Write a class called Palindrome that implements the provided the PalindromeInterface. It only requires a single method: isPalindrome which takes a String as a parameter. The method should make use of an instance of the MyStack class to verify whether the the String is a palindrome. Your method should ignore all spaces and be case insensitive. The method returns true if it is a palindrome, false if not.

We will test your method on our own input, but it would be a good idea to create your own tester class that instantiates the Palindrome class and checks it against a few things that are (and a few things that are not) palindromes to ensure that it’s working correctly.