import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LinkedDequeTest.
 *
 * @author Victor Hernandez Jr
 * @version November 11, 2022
 */
public class LinkedDequeTest
{
    /**
     * Default constructor for test class LinkedDequeTest
     */
    public LinkedDequeTest()
    {
    }
    /**
     * Tests pushFront method is called twice and uses getLength and size methods to compare numbers of nodes and elements
     */
    @Test
    public void pushFrontTest()
    {
        LinkedDeque<String> deque = new LinkedDeque<String>();
        assertTrue(deque.isEmpty());
        deque.pushFront("0");
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.getLength());
        assertEquals(1, deque.size());
        deque.pushFront("7");
        assertEquals(2, deque.getLength());
        assertEquals(2, deque.size());// 2 nodes are expected because the first index of the initial array is taken
        deque.pushFront("6");
        deque.pushFront("5");
        deque.pushFront("4");
        deque.pushFront("3");
        deque.pushFront("2");
        deque.pushFront("1");
        deque.pushFront("0");
        deque.pushFront("7");
        assertEquals(10, deque.getLength());
        assertEquals(3, deque.size());
    }
    
    /**
     * Tests pushFront method is called enough to create two nodes;
     * uses getLength and size methods to compare numbers of nodes and elements
     */
    @Test
    public void pushBackTest()
    {
        LinkedDeque<Integer> deque = new LinkedDeque<Integer>();
        assertTrue(deque.isEmpty());
        deque.pushBack(0);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.getLength());
        assertEquals(1, deque.size());
        deque.pushBack(1);
        assertEquals(2, deque.getLength());
        deque.pushBack(2);
        deque.pushBack(3);
        deque.pushBack(4);
        deque.pushBack(5);
        deque.pushBack(6);
        deque.pushBack(7);
        deque.pushBack(0);
        deque.pushBack(1);
        assertEquals(10, deque.getLength());
        assertEquals(2, deque.size());
    }
    
    /**
     * Creates a linked deque of integers going down the even numbers from 20 until it reaches 0 and goes up odd numbers.
     * Pops until there are only 4 integers left in the deque.
     */
    @Test
    public void popAndPeekFrontTest()
    {
        LinkedDeque<Integer> deque = new LinkedDeque<Integer>();
        assertTrue(deque.isEmpty());
        deque.pushBack(0);
        assertFalse(deque.isEmpty());
        for (int i = 1; i <= 20; i++){
            if (i % 2 == 0){deque.pushFront(i);}
            else {deque.pushBack(i);}
        }
        assertEquals(20, deque.popFront());
        assertEquals(18, deque.popFront());
        assertEquals(16, deque.popFront());
        assertEquals(14, deque.popFront());
        assertEquals(12, deque.popFront());
        assertEquals(10, deque.popFront());
        assertEquals(8, deque.popFront());
        assertEquals(6, deque.popFront());
        assertEquals(4, deque.popFront());
        assertEquals(2, deque.popFront());
        assertEquals(0, deque.popFront());
        assertEquals(1, deque.popFront());
        assertEquals(3, deque.popFront());
        assertEquals(5, deque.popFront());
        assertEquals(7, deque.popFront());
        assertEquals(9, deque.peekFront());
        assertEquals(9, deque.popFront());
        assertEquals(11, deque.peekFront());
        assertEquals(11, deque.popFront());
        assertEquals(13, deque.peekFront());
        assertEquals(4, deque.getLength());
    }
    
    /**
     * Creates a linked deque of integers pushing the numbers divisible by 4 from 16 to the front and pushes the rest to the back.
     * Pops until there are only 8 integers left in the deque.
     */
    @Test
    public void popAndPeekBackTest()
    {
        LinkedDeque<Integer> deque = new LinkedDeque<Integer>();
        assertTrue(deque.isEmpty());
        for (int i = 0; i <= 16; i++){
            if (i % 4 == 0){deque.pushFront(i);}
            else {deque.pushBack(i);}
        }
        assertEquals(15, deque.popBack());
        assertEquals(14, deque.popBack());
        assertEquals(13, deque.popBack());
        assertEquals(11, deque.popBack());
        assertEquals(10, deque.popBack());
        assertEquals(9, deque.popBack());
        assertEquals(7, deque.peekBack());
        assertEquals(7, deque.popBack());
        assertEquals(6, deque.peekBack());
        assertEquals(6, deque.popBack());
        assertEquals(5, deque.peekBack());
        assertEquals(9, deque.getLength());
    }
}
