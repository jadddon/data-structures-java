package L6;

// Importing necessary classes and interfaces
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList( )
    {
        doClear( );       // Calls the doClear method to initialize the list
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;   // Returns the current size of the list
    }
    
    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return size( ) == 0; // Checks if the size of the list is 0 to determine if it's empty
    }
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        if( idx < 0 || idx >= size( ) ) // Checks if the index is within the bounds of the list
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];    // Returns the item at the specified index
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        if( idx < 0 || idx >= size( ) ) // Checks if the index is within the bounds of the list
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        AnyType old = theItems[ idx ];    // Stores the old value at the specified index
        theItems[ idx ] = newVal; // Sets the new value at the specified index
        return old;    // Returns the old value
    }

    @SuppressWarnings("unchecked")      //@SuppressWarnings sign can go in front of a method declaration
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < theSize ) // Checks if the new capacity is less than the current size
            return; // If true, no need to increase capacity

        AnyType [ ] old = theItems; // Stores the current array
        theItems = (AnyType []) new Object[ newCapacity ];  // Creates a new array with the specified capacity
        for( int i = 0; i < size( ); i++ ) // Copies elements from the old array to the new array
            theItems[ i ] = old[ i ];
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x )     // whether or not add was successful
    {
    add( size( ), x ); // Calls the add method with the current size as the index and the object to add
        return true;            
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     * @param x any object.
     * @return true.
     */
    public void add( int idx, AnyType x )    // adds item at specific place (idx) and value/object (x)
    {
        if( theItems.length == size( ) )       //check capacity (length of array)
            ensureCapacity( size( ) * 2 + 1 ); // Increases capacity if necessary

        for( int i = theSize; i > idx; i-- ) // Shifts elements to the right to make space for the new element
            theItems[ i ] = theItems[ i - 1 ];

        theItems[ idx ] = x; // Places the new element at the specified index
        theSize++;          // Increments the size of the list
    }
      
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )                // memorize this removal
    {
        AnyType removedItem = theItems[ idx ]; // Stores the item to be removed
        for( int i = idx; i < size( ) - 1; i++ ) // Shifts elements to the left to fill the gap
            theItems[ i ] = theItems[ i + 1 ];
        theSize--;                                // Decrements the size of the list
        return removedItem;                       // Returns the removed item
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        doClear( ); // Calls the doClear method to clear the list
    }
    
    private void doClear( )
    {
        theSize = 0; // Resets the size of the list to 0
        ensureCapacity( DEFAULT_CAPACITY );    // Sets the capacity to the default capacity
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )       // iterator is a method that returns an iterator object
    {
        return new ArrayListIterator( ); // Returns a new ArrayListIterator object
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
            StringBuilder sb = new StringBuilder( "[ " );   //string class is immutable //StringBuilder is a helper function that allocates array of characters

            for( AnyType x : this ) // Iterates over the list to build the string representation
                sb.append( x + " " );
            sb.append( "]" );

            return new String( sb ); // Returns the string representation of the list
    }
    
    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyArrayList.
     */
    private class ArrayListIterator implements java.util.Iterator<AnyType>   // non-static nested class -- can access the outer class's fields
    {
        private int current = 0; // Keeps track of the current position in the list
        private boolean okToRemove = false; // Flag to check if removal is allowed
        
        public boolean hasNext( )
        {
            return current < size( ); // Checks if there are more elements to iterate over
        }
        
        
        public AnyType next( )
        {
            if( !hasNext( ) ) 
                throw new java.util.NoSuchElementException( ); 
            okToRemove = true;    
            return theItems[ current++ ]; // Returns the next element and increments the current position
        }
        
        public void remove( )
        {
            if( !okToRemove )
                throw new IllegalStateException( );
            MyArrayList.this.remove( --current ); // Removes the element at the current position
            okToRemove = false;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 10; // hard coded constant
    
    private AnyType [ ] theItems; // Array to store the elements of the list
    private int theSize; // Size of the list
}

class TestArrayList
{
    public static void main( String [ ] args )
    {
        MyArrayList<Integer> lst = new MyArrayList<>( );

        for( int i = 0; i < 10; i++ )
                lst.add( i ); // Adds elements to the list
        for( int i = 20; i < 30; i++ )
                lst.add( 0, i ); // Adds elements at the beginning of the list

        lst.remove( 0 ); // Removes the first element
        lst.remove( lst.size( ) - 1 ); // Removes the last element

        System.out.println( lst ); // Prints the list
    }
}
