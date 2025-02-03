/**
 * This program demonstrates the use of binary search in Java.
 * It includes methods to perform binary search on arrays and ArrayLists.
 * The main method allows the user to input a value and see the result of the binary search.
 */ 

public class BinarySearchGeneric {

    // Method to perform binary search on a generic array
    public static <E extends Comparable<E>> 
        int binarySearch(E[] a, E value) {
        
        int start = 0; // Initialize start index
        int stop = a.length-1; // Initialize stop index

        // Perform binary search
        while(start<=stop) {
            int mid = (start+stop)/2; // Calculate mid index

            int compareResult = a[mid].compareTo(value); // Compare mid value with the target value
            if(compareResult == 0) { // If mid value is equal to the target value, return mid index
                return mid;
            } else if( compareResult > 0) { // If mid value is greater than the target value, update stop index
                stop = mid-1;
            } else { // If mid value is less than the target value, update start index
                start = mid + 1;
            }
        }

        return -1; // If the target value is not found, return -1

    }

    // Method to perform binary search recursively on a generic array
    public static <E extends Comparable<E>> 
        int binarySearchRecursive(E[] a, E value) {

            return binarySearchRecursive(a,value,0,a.length-1);

    }

    // Helper method to perform binary search recursively on a generic array
    private static <E extends Comparable<E>> 
        int binarySearchRecursive(E[] a, E value, int start, int stop) {

            if(start > stop) { // If start index is greater than stop index, the target value is not found
                return -1;
            }

            int mid = (start+stop)/2; // Calculate mid index
            
            int compareResult = a[mid].compareTo(value); // Compare mid value with the target value
            if(compareResult == 0) { // If mid value is equal to the target value, return mid index
                return mid;
            } else if( compareResult > 0) { // If mid value is greater than the target value, perform binary search on the lower half
                return binarySearchRecursive(a,value,start,mid-1);
            } else { // If mid value is less than the target value, perform binary search on the upper half
                return binarySearchRecursive(a,value,mid+1,stop);
            }


    }


    // Main method to test the binary search methods
    public static void main(String[] args) {

        String[] arr = { "aardvark", "hello", "world", "zoo", "zoom"};

        System.out.println(binarySearch(arr,"hello"));
        System.out.println(binarySearch(arr,"goodbye"));
        System.out.println(binarySearch(arr,"zoom"));



    }




}