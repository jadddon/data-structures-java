package HW0;

import java.util.Arrays;

/**
 * This class provides a generic binary search method for arrays of comparable elements.
 */
public class BinarySearchGeneric {

    /**
     * Performs a binary search on the given array for the specified element.
     * 
     * @param a The array to search in.
     * @param x The element to search for.
     * @return The index of the element if found, -1 otherwise.
     */
    public static <E extends Comparable<E>> int binarySearch(E[] a, E x) {
        // Call the private binarySearch method with the initial start and stop indices.
        return binarySearch(a, x, 0, a.length - 1);
    }
    
    /**
     * Private helper method for binary search.
     * 
     * @param a The array to search in.
     * @param x The element to search for.
     * @param start The starting index of the search range.
     * @param stop The ending index of the search range.
     * @return The index of the element if found, -1 otherwise.
     */
    private static <E extends Comparable<E>> int binarySearch(E[] a, E x, int start, int stop) {
        // Base case: If the start index is greater than the stop index, the element is not found.
        if (start > stop) {
            return -1;
        }

        // Calculate the middle index of the search range.
        int mid = (start + stop) / 2;
        // Compare the middle element with the target element.
        int compareResult = a[mid].compareTo(x);

        // If the middle element is equal to the target element, return the middle index.
        if (compareResult == 0) {
            return mid;
        } 
        // If the middle element is greater than the target element, search in the lower half.
        else if (compareResult > 0) {
            return binarySearch(a, x, start, mid - 1);
        } 
        // If the middle element is less than the target element, search in the upper half.
        else {
            return binarySearch(a, x, mid + 1, stop);
        }
    }

    /**
     * Main method to test the binarySearch method.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        String[] arr = {"carrot", "banana", "apple", "eggplant", "date"};
        
        // Sort the array before performing binary search.
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        // Perform binary search for a specific element.
        int index = binarySearch(arr, "carrot");
        System.out.println("Index of 'carrot': " + index);
    }
}