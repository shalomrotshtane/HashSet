/**
 * this class represent open hash set.
 * <p>
 * Fields inherited from class SimpleHashSet:
 * - DEFAULT_HIGHER_CAPACITY.
 * - DEFAULT_LOWER_CAPACITY.
 * - INITIAL_CAPACITY.
 * - currentCapacity.
 * see details in SimpleHashSet.
 */
public class OpenHashSet extends SimpleHashSet {

    private LinkedListWrapper[] hashSet;


    // ----------------------8888     constructors     8888--------------------------- //


    /**
     * A default constructor. Constructs a new, empty table with default initial capacity (16),
     * upper load factor (0.75) and lower load factor (0.25).
     */
    public OpenHashSet() {
        this.upperLoadFactor = DEFAULT_HIGHER_CAPACITY;
        this.lowerLoadFactor = DEFAULT_LOWER_CAPACITY;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new LinkedListWrapper[INITIAL_CAPACITY];
    }

    /**
     * Constructs a new, empty table with the specified load factors, and the default initial capacity (16).
     *
     * @param upperLoadFactor - The upper load factor of the hash table.
     * @param lowerLoadFactor - The lower load factor of the hash table.
     */
    public OpenHashSet(float upperLoadFactor, float lowerLoadFactor) {
        this.upperLoadFactor = upperLoadFactor;
        this.lowerLoadFactor = lowerLoadFactor;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new LinkedListWrapper[INITIAL_CAPACITY];
    }

    /**
     * Data constructor - builds the hash set by adding the elements one by one. Duplicate values should be ignored.
     * The new table has the default values of initial capacity (16),
     * upper load factor (0.75), and lower load factor (0.25).
     *
     * @param data - Values to add to the set.
     */
    public OpenHashSet(String[] data) throws Exception {
        this.upperLoadFactor = DEFAULT_HIGHER_CAPACITY;
        this.lowerLoadFactor = DEFAULT_LOWER_CAPACITY;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new LinkedListWrapper[INITIAL_CAPACITY];
        for(String o : data) { this.add(o); }
    }


    // ----------------------8888    Public methods     8888--------------------------- //


    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(String o) {
        int i = clamp(o.hashCode());
        return (this.hashSet[i] != null && this.hashSet[i].getLinkedList().contains(o));
    }

    /**
     * Returns the capacity of elements in the set.
     *
     * @return the capacity of elements in the set.
     */
    @Override
    public int capacity() {
        return hashSet.length;
    }

    /**
     * Clamps hashing indices to fit within the current table capacity.
     *
     * @param i the index before clamping.
     * @return an index properly clamped.
     */
    @Override
    public int clamp(int i) {
        return i & (hashSet.length - 1);
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(String o) throws Exception{
        if (contains(o)) {
            this.hashSet[clamp(o.hashCode())].remove(o);
            this.size--;
            return true;
        } else {
            return false;
        }
    }


    // ----------------------8888     Private/Protected methods     8888--------------------------- //


    /**
     * this function helping to the add function.
     *
     * @param o - the object that go to the hash table.
     */
    @Override
    protected void addHelper(String o) throws Exception{
        int i = clamp(o.hashCode());
        try{

            if (this.hashSet[i] == null) { this.hashSet[i] = new LinkedListWrapper(); }
            this.hashSet[i].add(o);

        } catch (Exception e){

            throw new Exception("Error occured when adding new object in the function addHelper(String o);" +
                    "most likley that there is an error with the hash index. e.getMessage():"
                    + e.getMessage());
        }
    }

    /**
     * Increasing the size of the set or decreasing the size of the set.
     *
     * @param increase indicate if to increase or decrease.
     */
    @Override
    protected void raisingTable(boolean increase) throws Exception {
        this.currentCapacity = increase ? this.currentCapacity * 2 : this.currentCapacity / 2;
        LinkedListWrapper[] temp = this.hashSet;
        this.hashSet = new LinkedListWrapper[currentCapacity];

        try{

            for (LinkedListWrapper ll : temp) {
                if (ll != null) {
                    for(Object o : ll.getLinkedList()){
                        addHelper((String)o);
                    }
                }
            }

        } catch (Exception e){
            throw new Exception("Error occurred when raising the table. e.getMessage():"
                    + e.getMessage());
        }
    }
}
