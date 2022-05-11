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


    //the ash set
    private String[] hashSet;



    // ----------------------8888     constructors     8888--------------------------- //



    /**
     * Constructs a new, empty table with the specified load factors, and the default initial capacity (16).
     *
     * @param upperLoadFactor - The upper load factor of the hash table.
     * @param lowerLoadFactor - The lower load factor of the hash table.
     */
    public ClosedHashSet(float upperLoadFactor, float lowerLoadFactor) {
        upperLoFactor = upperLoadFactor;
        lowerLoFactor = lowerLoadFactor;
        hashSet = new String[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
    }


    /**
     * A default constructor. Constructs a new, empty table with default initial capacity (16),
     * upper load factor (0.75) and lower load factor (0.25).
     */
    public ClosedHashSet() {
        upperLoFactor = DEFAULT_HIGHER_CAPACITY;
        lowerLoFactor = DEFAULT_LOWER_CAPACITY;
        hashSet = new String[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
    }


    /**
     * Data constructor - builds the hash set by adding the elements one by one.
     * Duplicate values should be ignored. The new table has the default values of initial capacity (16),
     * upper load factor (0.75), and lower load factor (0.25).
     *
     * @param data - Values to add to the set.
     */
    public ClosedHashSet(java.lang.String[] data) {
        upperLoFactor = DEFAULT_HIGHER_CAPACITY;
        lowerLoFactor = DEFAULT_LOWER_CAPACITY;
        hashSet = new String[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
        for (String object : data) {
            this.add(object);
        }
    }



    // ----------------------8888    inherited methods     8888--------------------------- //



    //see in SimpleHashSet.
    @Override
    public int capacity() {
        return this.hashSet.length;
    }


    //see in SimpleHashSet.
    @Override
    public int clamp(int index) {
        int c;
        int i = 0;
        int j = 0;
        // as explained in the instructions.
        c = ((index + ((i + j) / 2)) & (this.capacity() - 1));
        while (this.hashSet[c] != null) {
            i += 1;
            j = i ^ 2;
            c = ((index + ((i + j) / 2)) & this.capacity() - 1);
        }
        return c;
    }


    //see in SimpleSet.
    @Override
    public boolean contains(String searchVal) {
        for (Object object : this.hashSet) {
            if (object != null) {
                if (object.equals(searchVal)) {
                    return true;
                }
            }
        }
        return false;
    }


    //see in SimpleSet.
    @Override
    public int size() {
        int SumOfElements = 0;
        for (Object object : hashSet) {
            if (object != null) {
                SumOfElements++;
            }
        }
        return SumOfElements;
    }


    //see in SimpleSet.
    @Override
    public boolean add(String newValue) {
        //making sure that the object is not all ready in the set.
        if (!contains(newValue)) {
            int size = this.size() + 1;
            int capacity = this.capacity();
            //if the ratio is bigger then the upper load factor the function increasing the table.
            if (upperLoFactor < SizeCapacityRatio(size, capacity)) {
                this.hashSet = raisingTable(this.hashSet, true);
                addHelper(newValue);
                return true;
                //if the ratio is smaller then the lower load factor the function decreasing the table.
            } else if (SizeCapacityRatio(size, capacity) < lowerLoFactor) {
                this.hashSet = raisingTable(this.hashSet, false);
                addHelper(newValue);
                return true;
            } else {
                addHelper(newValue);
            }
            return true;
        }
        return false;
    }


    //see in SimpleSet.
    @Override
    public boolean delete(java.lang.String toDelete) {
        int size = this.size() - 1;
        int capacity = this.capacity();
        for (int c = 0; c <= hashSet.length - 1; c++) {
            if (hashSet[c] != null) {
                if (hashSet[c].equals(toDelete)) {
                    hashSet[c] = null;
                    //if the ratio is smaller then the lower load factor the function decreasing the table.
                    if (SizeCapacityRatio(size, capacity) < lowerLoFactor) {
                        hashSet = raisingTable(hashSet, false);
                        return true;
                        //if the ratio is bigger then the upper load factor the function increasing the table.
                    } else if (upperLoFactor < SizeCapacityRatio(size, capacity)) {
                        hashSet = raisingTable(hashSet, true);
                        return true;
                    }
                    //if none of them
                    return true;
                }
            }
        }
        return false;
    }



    // ----------------------8888    private methods     8888--------------------------- //




    /**
     * this function helping to the add function.
     *
     * @param newValue - the value that go to the hash table.
     */
    private void addHelper(String newValue) {
        int hashCode = newValue.hashCode();
        int finalIndex = clamp(hashCode);
        this.hashSet[finalIndex] = newValue;
    }


    /**
     * this function raise the table and increases or decreases the hash table.
     *
     * @param hashSet         - the hash table that need to change.
     * @param BiggerOrSmaller - true if the table need to get bigger, false if the table need to get smaller.
     * @return the new table after the change.
     */
    private String[] raisingTable(String[] hashSet, boolean BiggerOrSmaller) {
        if (BiggerOrSmaller) {
            currentCapacity *= 2;
        } else {
            currentCapacity /= 2;
        }
        this.hashSet = new String[currentCapacity];
        for (String string : hashSet) {
            if (string != null) {
                addHelper(string);
            }
        }
        return this.hashSet;
    }
}
