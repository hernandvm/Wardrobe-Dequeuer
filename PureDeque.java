
/**
 * This interface defines methods to access the elements at both 
 * ends of the deque.
 *
 * @author Victor Hernandez Jr
 * @version November 11, 2022
 */
public interface PureDeque<E>
{
    /**
     * Inserts specified item at the front of the deque
     * 
     * @param item element to add to deque
     */
    void pushFront(E item);
    
    /**
     * Inserts specified item at the back of the deque
     * 
     * @param item element to add to deque
     */
    void pushBack(E item);
    
    /**
     * Retrieves and removes item at the front of deque
     * 
     * @return the head of the deque
     */
    E popFront();
    
    /**
     * Retrieves and removes item at the back of deque
     * 
     * @return the tail of the deque
     */
    E popBack();
    
    /**
     * Retrieves but does not remove the item at the front of deque
     * 
     * @return the head of the deque
     */
    E peekFront();
    
    /**
     * Retrieves but does not remove the item at the back of deque
     * 
     * @return the tail of the deque
     */
    E peekBack();
    
    /**
     * Checks whether deque is empty or not
     * 
     * @return whether deque is empty or not
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in deque
     * 
     * @return number of elements in deque
     */
    int getLength();
}
