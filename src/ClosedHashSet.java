/**
 * this class represent closed hash set.
 * <p>
 * Fields inherited from class SimpleHashSet:
 * - DEFAULT_HIGHER_CAPACITY.
 * - DEFAULT_LOWER_CAPACITY.
 * - INITIAL_CAPACITY.
 * - currentCapacity.
 * see details in SimpleHashSet.
 */
public class ClosedHashSet extends SimpleHashSet {

    private String[] hashSet;


    // ----------------------8888     constructors     8888--------------------------- //


    /**
     * Constructs a new, empty table with the specified load factors, and the default initial capacity (16).
     *
     * @param upperLoadFactor - The upper load factor of the hash table.
     * @param lowerLoadFactor - The lower load factor of the hash table.
     */
    public ClosedHashSet(float upperLoadFactor, float lowerLoadFactor) {
        this.upperLoadFactor = upperLoadFactor;
        this.lowerLoadFactor = lowerLoadFactor;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new String[INITIAL_CAPACITY];
    }

    /**
     * A default constructor. Constructs a new, empty table with default initial capacity (16),
     * upper load factor (0.75) and lower load factor (0.25).
     */
    public ClosedHashSet() {
        this.upperLoadFactor = DEFAULT_HIGHER_CAPACITY;
        this.lowerLoadFactor = DEFAULT_LOWER_CAPACITY;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new String[INITIAL_CAPACITY];
    }

    /**
     * Data constructor - builds the hash set by adding the elements one by one.
     * Duplicate values should be ignored. The new table has the default values of initial capacity (16),
     * upper load factor (0.75), and lower load factor (0.25).
     *
     * @param data - Values to add to the set.
     */
    public ClosedHashSet(String[] data) throws Exception {
        this.upperLoadFactor = DEFAULT_HIGHER_CAPACITY;
        this.lowerLoadFactor = DEFAULT_LOWER_CAPACITY;
        this.currentCapacity = INITIAL_CAPACITY;
        this.hashSet = new String[INITIAL_CAPACITY];
        for(String o : data) { this.add(o); }
    }


    // ----------------------8888    Public methods     8888--------------------------- //


    /**
     * Returns the capacity of elements in the set.
     *
     * @return the capacity of elements in the set.
     */
    @Override
    public int capacity() {
        return this.hashSet.length;
    }

    /**
     * Clamps hashing indices to fit within the current table capacity.
     *
     * @param i the index before clamping.
     * @return an index properly clamped.
     */
    @Override
    public int clamp(int i) {
        int c;
        int j = 0;
        c = (i + (j + (int) Math.pow(j, 2)) / 2) & (this.capacity() - 1);
        while (this.hashSet[c] != null) {
            c = (i + (j + (int) Math.pow(j, 2)) / 2) & (this.capacity() - 1);
            j++;
        }
        return c;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(String o) {
        for (String str : this.hashSet) {
            if (str != null && str.equals(o)) { return true; }
        }
        return false;
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(String o) throws Exception {
        for (int i = 0; i < hashSet.length; i++) {
            if (hashSet[i] != null && hashSet[i].equals(o)) {
                hashSet[i] = null;
                this.size--;

                if (SizeCapacityRatio(this.size() - 1, this.capacity()) < lowerLoadFactor &&
                        this.capacity() > 16) {
                    raisingTable(false);
                }
                return true;
            }
        }
        return false;
    }


    // ----------------------8888    Private/Protected methods     8888--------------------------- //


    /**
     * this function helping to the add function.
     *
     * @param o - the value that go to the hash table.
     */
    @Override
    protected void addHelper(String o) throws Exception {
        int finalIndex = clamp(o.hashCode());
        try{
            this.hashSet[finalIndex] = o;
        } catch (Exception e){
            throw new Exception("Error occured in the addHelper(String newValue); " +
                    "when adding new element after getting index from the hash function. e.getMessage():"
                    + e.getMessage());
        }
    }

    /**
     * Increasing the size of the set or decreasing the size of the set.
     *
     * @param increase indicate if to increase or decrease.
     */
    @Override
    protected void raisingTable(boolean increase) throws Exception{
        this.currentCapacity = increase ? this.currentCapacity * 2 : this.currentCapacity / 2;
        String[] temp = this.hashSet;
        this.hashSet = new String[currentCapacity];

        for (String o : temp) {
            if (o != null) { addHelper(o); }
        }
    }
}
