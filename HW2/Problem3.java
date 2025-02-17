package HW2;

public class Problem3 {
    public static void main(String[] args) {
        
        BigO bigO = new BigO();

        int[] constants = {2, 3, 5, 10, 15};

        // cubic method
        for (int n : constants){
            long startTime = System.nanoTime();
            bigO.cubic(n);
            long endTime = System.nanoTime();
            System.out.println("cubic method: " + (endTime - startTime) + " nanoseconds");
        }

        // exp method
        for (int n : constants){
            long startTime = System.nanoTime();
            bigO.exp(n);
            long endTime = System.nanoTime();
            System.out.println("exp method: " + (endTime - startTime) + " nanoseconds");
        }

        // constant method
        for (int n : constants){
            long startTime = System.nanoTime();
            bigO.constant(n);
            long endTime = System.nanoTime();
            System.out.println("constant method: " + (endTime - startTime) + " nanoseconds");
        }
    }
}
