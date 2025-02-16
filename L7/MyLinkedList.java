package L7;

/** 
 * LinkedList class implements a doubly-linked list.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty LinkedList.
     */
    public MyLinkedList( )
    {
        doClear( ); // Calls the doClear method to initialize the list
    }
    
    private void clear( )
    {
        doClear( ); // Calls the doClear method to clear the list
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void doClear( )
    {
        beginMarker = new Node<>( null, null, null ); // Creates a new Node for the beginning marker
        endMarker = new Node<>( null, beginMarker, null ); // Creates a new Node for the end marker
        beginMarker.next = endMarker; // Links the beginning marker to the end marker
        
        theSize = 0; // Resets the size of the list to 0
        modCount++; // Increments the modification count
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize; // Returns the current size of the list
    }
    
    public boolean isEmpty( )
    {
        return size( ) == 0; // Checks if the list is empty by comparing size to 0
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x )
    {
        add( size( ), x ); // Calls the add method with the current size as the index and the object to add
        return true; // Always returns true indicating successful addition
    }
    
    /**
     * Adds an item to this collection, at specified position.
     * Items at or after that position are slid one position higher.
     * @param x any object.
     * @param idx position to add at.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    public void add( int idx, AnyType x )
    {
        addBefore( getNode( idx, 0, size( ) ), x ); // Calls the addBefore method to add the object at the specified position
    }
    
    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */    
    private void addBefore( Node<AnyType> p, AnyType x )
    {
        Node<AnyType> newNode = new Node<>( x, p.prev, p ); // Creates a new Node with the object to add and links it to the previous and next nodes
        newNode.prev.next = newNode; // Links the previous node to the new node
        p.prev = newNode; // Links the new node to the next node
        theSize++; // Increments the size of the list
        modCount++; // Increments the modification count
    }   
    
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        return getNode( idx ).data; // Returns the data of the Node at the specified index
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        Node<AnyType> p = getNode( idx ); // Gets the Node at the specified index
        AnyType oldVal = p.data; // Stores the old value
        p.data = newVal; // Sets the new value
        return oldVal; // Returns the old value
    }
    
    /**
     * Gets the Node at position idx, which must range from 0 to size( ) - 1.
     * @param idx index to search at.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size( ) - 1, inclusive.
     */
    private Node<AnyType> getNode( int idx )
    {
        return getNode( idx, 0, size( ) - 1 ); // Calls the overloaded getNode method with the specified index and valid range
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */    
    private Node<AnyType> getNode( int idx, int lower, int upper )
    {
        Node<AnyType> p;
        
        if( idx < lower || idx > upper )
            throw new IndexOutOfBoundsException( "getNode index: " + idx + "; size: " + size( ) ); // Throws an exception if the index is out of range
            
        if( idx < size( ) / 2 )
        {
            p = beginMarker.next; // Starts from the beginning of the list
            for( int i = 0; i < idx; i++ )
                p = p.next; // Iterates to the specified index
        }
        else
        {
            p = endMarker; // Starts from the end of the list
            for( int i = size( ); i > idx; i-- )
                p = p.prev; // Iterates to the specified index
        } 
        
        return p; // Returns the Node at the specified index
    }
    
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
        return remove( getNode( idx ) ); // Calls the remove method with the Node at the specified index
    }
    
    /**
     * Removes the object contained in Node p.
     * @param p the Node containing the object.
     * @return the item was removed from the collection.
     */
    private AnyType remove( Node<AnyType> p )
    {
        p.next.prev = p.prev; // Links the next node to the previous node
        p.prev.next = p.next; // Links the previous node to the next node
        theSize--; // Decrements the size of the list
        modCount++; // Increments the modification count
        
        return p.data; // Returns the data of the removed Node
    }
    
    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( "[ " ); // Creates a StringBuilder to build the string representation

        for( AnyType x : this )
            sb.append( x + " " ); // Iterates through the list and appends each element to the StringBuilder
        sb.append( "]" ); // Appends the closing bracket

        return new String( sb ); // Returns the string representation
    }

    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new LinkedListIterator( ); // Returns a new LinkedListIterator
    }

    /**
     * This is the implementation of the LinkedListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyLinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<AnyType>
    {
        private Node<AnyType> current = beginMarker.next; // Initializes the current node to the first node in the list
        private int expectedModCount = modCount; // Stores the expected modification count
        private boolean okToRemove = false; // Flag to check if removal is allowed
        
        public boolean hasNext( )
        {
            return current != endMarker; // Checks if there are more elements in the list
        }
        
        public AnyType next( )
        {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( ); // Throws an exception if the list has been modified
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException( ); // Throws an exception if there are no more elements
            
            AnyType nextItem = current.data; // Stores the data of the current node
            current = current.next; // Moves to the next node
            okToRemove = true; // Allows removal
            return nextItem; // Returns the data of the current node
        }
        
        public void remove( )
        {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( ); // Throws an exception if the list has been modified
            if( !okToRemove )
                throw new IllegalStateException( ); // Throws an exception if removal is not allowed
                
            MyLinkedList.this.remove( current.prev ); // Removes the node before the current node
            expectedModCount++; // Updates the expected modification count
            okToRemove = false; // Disallows removal
        }
    }
    
    /**
     * This is the doubly-linked list node.
     */
    private static class Node<AnyType>
    {
        public Node( AnyType d, Node<AnyType> p, Node<AnyType> n )
        {
            data = d; prev = p; next = n; // Initializes the node with data and links
        }
        
        public AnyType data; // Data stored in the node
        public Node<AnyType>   prev; // Link to the previous node
        public Node<AnyType>   next; // Link to the next node
    }
    
    private int theSize; // Size of the list
    private int modCount = 0; // Modification count
    private Node<AnyType> beginMarker; // Marker for the beginning of the list
    private Node<AnyType> endMarker; // Marker for the end of the list
}

class TestLinkedList
{
    public static void main( String [ ] args )
    {
        MyLinkedList<Integer> lst = new MyLinkedList<>( );

        for( int i = 0; i < 10; i++ )
                lst.add( i ); // Adds elements to the list
        for( int i = 20; i < 30; i++ )
                lst.add( 0, i ); // Adds elements at the beginning of the list

        lst.remove( 0 ); // Removes the first element
        lst.remove( lst.size( ) - 1 ); // Removes the last element

        System.out.println( lst ); // Prints the list

        java.util.Iterator<Integer> itr = lst.iterator( ); // Creates an iterator for the list
        while( itr.hasNext( ) )
        {
                itr.next( ); // Moves to the next element
                itr.remove( ); // Removes the current element
                System.out.println( lst ); // Prints the list after each removal
        }
    }
}

