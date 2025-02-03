/**
 * This program demonstrates the use of sorting and binary search in Java.
 * It includes methods to sort an array of Student objects and perform binary search on the sorted array.
 * The main method initializes and sorts an array of Student objects, performs binary search, and prints the results.
 */

import java.util.Arrays; // Importing the Arrays class for array operations

public class CompareStuff {

    public static void main(String[] args) {

        // Creating an array of Student objects with size 3
        Student[] s = new Student[3];
        // Initializing the array with Student objects
        s[0] = new Student("Johan","Johnson");
        s[1] = new Student("Maria","Antoinette");
        s[2] = new Student("Adam","Johnson");

        // Setting scores for each Student object
        s[0].setScore(71);
        s[1].setScore(65);
        s[2].setScore(41);
        

        // Printing the Student objects before sorting
        for(Student x : s) {
            System.out.println(x);
        }
        System.out.println("-----"); // Printing a separator line
        // Sorting the array of Student objects
        Arrays.sort(s);
        // Printing the Student objects after sorting
        for(Student x : s) {
            System.out.println(x);
        }

        // Creating a new Student object for binary search
        Student v = new Student("Ahmed","Smith");
        // Setting the score for the new Student object
        v.setScore(65);

        // Performing binary search on the sorted array
        int result = BinarySearchGeneric.binarySearch(s,v);
        // Printing the Student object found at the result index
        System.out.println(s[result]);



    }

}