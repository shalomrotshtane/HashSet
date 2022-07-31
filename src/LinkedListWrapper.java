import java.util.LinkedList;
import java.lang.String;


/**
 * this class is wrapping the linked list to the open hash table.
 */
public class LinkedListWrapper {
    private LinkedList<String> linkedList;

    /**
     * Contractor for the linked list.
     */
    public LinkedListWrapper() {
        this.linkedList = new LinkedList<>();
    }

    /**
     * Return the linked list.
     *
     * @return the linked list
     */
    public LinkedList getLinkedList() {
        return this.linkedList;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param o object to be added to this set
     * @return true if this set did not already contain the specified
     * element
     */
    public void add(String o) {
        this.linkedList.add(o);
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    public void remove(String o) {
        this.linkedList.remove(o);
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(String o) {
        return this.linkedList.contains(o);
    }
}
