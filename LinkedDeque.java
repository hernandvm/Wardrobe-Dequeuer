import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * A linear collection of arrays that supports insertion and removal
 * at both ends. Implements methods of the PureDeque interface
 * and overrides methods of the AbstractCollection class.
 * 
 * @author Victor Hernandez Jr
 * @version November 11, 2022
 */
public class LinkedDeque<E> extends AbstractCollection<E> implements PureDeque<E>
{
    private int numElements = 0;
    private Node head = null;
    private Node tail = null;
    private int front = 0;
    private int back = 0;

    /**
     * Creates a node with an empty array and reference to 
     * its following node
     */
    public class Node
    {
        private int capacity = 8;
        E[] array;
        Node next;
        int elements;

        public Node(Node next)
        {
            this.next = next;
            array = (E[]) new Object[capacity];
            elements = 0;
        }

        public String toStringInternal(){
            StringBuffer arrayString = new StringBuffer();
            arrayString.append("(");
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] == null){
                    arrayString.append("-, ");
                } else {arrayString.append(array[i].toString() + ", ");}
            }
            if (array[capacity - 1] == null){
                arrayString.append("-");
            } else {arrayString.append(array[capacity - 1].toString());}
            arrayString.append(")");
            return arrayString.toString();
        }

        public boolean headFull(){
            return array[0] != null;
        }

        public boolean tailFull(){
            return array[capacity - 1] != null;
        }

        public boolean isEmpty(){
            return elements == 0;
        }
    }

    @Override
    public void pushFront(E item)
    {
        if (head == null){
            head = new Node(null);
            tail = head;
            front = 0;
            back = 0;
        } else if (head.headFull()){
            head = new Node(head);
            front = 7;
        } else {
            front--;
        }
        head.array[front] = item;
        head.elements++;
        numElements++;
    }

    @Override
    public void pushBack(E item)
    {
        if (tail == null){
            head = new Node(null);
            tail = head;
            front = 0;
            back = 0;
        } else if (tail.tailFull()){
            Node prevTail = tail;
            tail = new Node(null);
            prevTail.next = tail;
            back = 0;
        } else {
            back++;
        }
        tail.array[back] = item;
        tail.elements++;
        numElements++;
    }

    @Override
    public E popFront()
    {
        if (head != null) {
            E frontItem = head.array[front];
            head.array[front] = null;
            head.elements--;
            front++;
            numElements--;
            if (head.isEmpty()) {
                front = 0;
                head = head.next;
            }
            return frontItem;
        }
        return null;
    }

    @Override
    public E popBack()
    {   
        if (tail != null){
            E backItem = tail.array[back];
            tail.array[back] = null;
            tail.elements--;
            back--;
            numElements--;
            if (tail.isEmpty()) {
                
                if (head == tail){
                    back = 0;
                    tail = null;
                } else {
                    back = 7;
                    Node cursor = head;
                    Node cursorPrev = head;
                    while (cursor.next != null){
                        cursorPrev = cursor;
                        cursor = cursor.next;
                    }
                    tail = cursorPrev;
                    tail.next = null;
                }
            }
            return backItem;
        }
        return null;
    }

    @Override
    public E peekFront()
    {
        return head.array[front];
    }

    @Override
    public E peekBack()
    {
        return tail.array[back];
    }

    @Override
    public boolean isEmpty()
    {
        return numElements == 0; 
    }

    @Override
    public int getLength()
    {
        return numElements;
    }

    /**
     * Shows internal structure of nodes in deque
     * 
     * @return internal structure of deque
     */
    public String toString()
    {
        StringBuffer dequeString = new StringBuffer();
        Node cursor = head;
        if (cursor == null){return "Empty.";}
        dequeString.append("[");
        while (cursor.next != null){
            dequeString.append(cursor.toStringInternal() + ", ");
            cursor = cursor.next;
        }
        dequeString.append(cursor.toStringInternal() + "]");
        return dequeString.toString();
    }

    /**
     * Returns the number of nodes in deque
     * 
     * @return number of nodes in deque
     */
    @Override
    public int size()
    {
        int numNodes = 0;
        Node cursor = head;
        while (cursor != null){
            numNodes++;
            cursor = cursor.next;
        }
        return numNodes;
    }

    /**
     * Returns a new iterator 
     * 
     * @return new iterator
     */
    @Override
    public Iterator<E> iterator()
    {
        return new MyIterator();
    }

    /**
     * An iterator over a collection which allow to determine whether
     * there is a following element and what the element is.
     */
    public class MyIterator implements Iterator<E>
    {
        Node cursor = head;
        int elmnt = 0;
        public boolean hasNext()
        {
            return (numElements > 0 && (cursor != null || cursor.array[elmnt] != null));
        }

        public E next()
        {
            if (!hasNext()){throw new IllegalStateException();}
            E obj = (E) cursor.array[elmnt];
            elmnt++;
            if (elmnt == cursor.array.length) {
                cursor = cursor.next;
                elmnt = 0;
            }
            return obj;
        }
    }
}
