package HW2;

/**
 * This interface defines three methods that are expected to have specific time complexities.
 * 
 * @author Your Name
 */
public interface BigOInterface {

    /**
     * This method should have a time complexity of O(n^3), where n is the input parameter.
     * 
     * @param n The input parameter that affects the time complexity.
     */
    public void cubic(int n);

    /**
     * This method should have a time complexity of O(2^n), where n is the input parameter.
     * 
     * @param n The input parameter that affects the time complexity.
     */
    public void exp(int n);

    /**
     * This method should have a time complexity of O(1), meaning it should execute in constant time regardless of the input parameter.
     * 
     * @param n The input parameter that does not affect the time complexity.
     */
    public void constant(int n);
    
}
