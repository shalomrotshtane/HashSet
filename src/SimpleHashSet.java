/**
 * A superclass for implementations of hash-sets implementing the SimpleSet interface.
 */
public abstract class SimpleHashSet implements SimpleSet {


    protected static final float DEFAULT_HIGHER_CAPACITY = 0.75f;

    protected static final float DEFAULT_LOWER_CAPACITY = 0.25f;

    protected static final int INITIAL_CAPACITY = 16;

    protected int currentCapacity;

    protected int size;

    protected float upperLoadFactor;

    protected float lowerLoadFactor;

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param o object to be added to this set
     * @return true if this set did not already contain the specified
     * element
     */
    @Override
    public boolean add(String o) throws Exception {
        if (contains(o)) { return false; }
        if (upperLoadFactor < SizeCapacityRatio(this.size() + 1, this.capacity())) {
            raisingTable(true);
        }
        addHelper(o);
        size++;
        return true;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public abstract boolean contains(String o);

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public abstract boolean remove(String o) throws Exception;

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set.
     */
    @Override
    public int size() { return this.size; }


    // ----------------------8888   protected methods    8888--------------------------- //


    /**
     * Returns the capacity of elements in the set.
     *
     * @return the capacity of elements in the set.
     */
    protected abstract int capacity();

    /**
     * Clamps hashing indices to fit within the current table capacity.
     *
     * @param i the index before clamping.
     * @return an index properly clamped.
     */
    protected abstract int clamp(int i);

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param o object to be added to this set.
     */
    protected abstract void addHelper(String o) throws Exception;

    /**
     * Increasing the size of the set or decreasing the size of the set.
     *
     * @param increase indicate if to increase or decrease.
     */
    protected abstract void raisingTable(boolean increase) throws Exception;

    /**
     * Return the ratio between the size and the capacity.
     *
     * @param size     - the size of the hash table.
     * @param capacity - the capacity of the hash table.
     * @return the ratio between the size and the capacity.
     */
    protected float SizeCapacityRatio(float size, float capacity) {
        return size / capacity;
    }

    /**
     * Return the lower load factor of the table.
     *
     * @return The lower load factor of the table.
     */
    public float getLowerLoadFactor() {
        return lowerLoadFactor;
    }

    /**
     * Return the higher load factor of the table.
     *
     * @return The higher load factor of the table.
     */
    public float getUpperLoadFactor() {
        return upperLoadFactor;
    }

    /**
     * Set the lower load factor of the table.
     */
    public void setLowerLoadFactor(float lowerLoadFactor) {
        this.lowerLoadFactor = lowerLoadFactor;
    }

    /**
     * Set the higher load factor of the table.
     */
    public void setUpperLoadFactor(float upperLoadFactor) {
        this.upperLoadFactor = upperLoadFactor;
    }
}
