/**
 * This program demonstrates the use of sorting and binary search in Java.
 * It includes methods to sort an array of Student objects and perform binary search on the sorted array.
 * The main method initializes and sorts an array of Student objects, performs binary search, and prints the results.
 */

public class Student implements Comparable<Student> {

    private int score; // Variable to store the student's score
    private String firstName; // Variable to store the student's first name
    private String lastName; // Variable to store the student's last name

    // Constructor to initialize the student's first and last names
    public Student(String firstName, String lastName) {
        this.firstName = firstName; // Assigning the first name to the instance variable
        this.lastName = lastName; // Assigning the last name to the instance variable
    }

    // Method to set the student's score
    public void setScore(int score) {
        this.score = score; // Assigning the score to the instance variable
    }

    // Method to get the student's score
    public int getScore() {
        return score; // Returning the student's score
    }

    // Method to convert the student's details to a string
    public String toString() {
        return firstName + " " + lastName + " - " + score; // Returning a string representation of the student
    }

    // Method to compare two students based on their scores
    public int compareTo(Student other) {
        return score - other.score; // Comparing the scores of the current student with another student
        /*int compareResult = lastName.compareTo(other.lastName);
        if(compareResult != 0) {
            return compareResult;
        } else {
            return firstName.compareTo(other.firstName);
        }*/
    }

}