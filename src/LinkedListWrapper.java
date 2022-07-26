import java.util.LinkedList;
import java.lang.String;


/**
 * this class is wrapping the linked list to the open hash table.
 */
public class LinkedListWrapper {
    private LinkedList<String> linkedList;


    /**
     * contractor for the linked list.
     */
    public LinkedListWrapper() {
        this.linkedList = new LinkedList<>();
    }


    /**
     * this function return the linked list.
     *
     * @return the linked list
     */
    public LinkedList getLinkedList() {
        return this.linkedList;
    }

    public void add(String string) {
        this.linkedList.add(string);
    }

    public void remove(String string) {
        this.linkedList.remove(string);
    }

    public boolean contains(String string) {
        return this.linkedList.contains(string);
    }
}
