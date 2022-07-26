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


    //see in SimpleSet.
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

    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return The current capacity of the table.
     */
    public abstract int capacity();


    // ----------------------8888    abstract methods     8888--------------------------- //


    //see in SimpleSet.
    @Override
    public abstract boolean contains(String searchVal);

    //see in SimpleSet.
    @Override
    public abstract boolean delete(String toDelete) throws Exception;


    // ----------------------8888   protected methods    8888--------------------------- //


    /**
     * this function Clamps hashing indices to fit within the current
     * table capacity.
     * @param index the index before clamping.
     * @return an index properly clamped.
     */
    protected abstract int clamp(int index);

    /**
     * this method adding the object to the hashset.
     */
    protected abstract void addHelper(String newValue) throws Exception;

    /**
     * this method raising the table.
     */
    protected abstract void raisingTable(boolean increase) throws Exception;

    /**
     * this function return the ratio between the size and the capacity.
     *
     * @param size     - the size of the hash table.
     * @param capacity - the capacity of the hash table.
     * @return the ratio between the size and the capacity.
     */
    protected float SizeCapacityRatio(float size, float capacity) {
        return size / capacity;
    }

    /**
     * @return The lower load factor of the table.
     */
    public float getLowerLoadFactor() {
        return lowerLoadFactor;
    }

    /**
     * @return The higher load factor of the table.
     */
    public float getUpperLoadFactor() {
        return upperLoadFactor;
    }

    /**
     * The setter lower load factor of the table.
     */
    public void setLowerLoadFactor(float lowerLoadFactor) {
        this.lowerLoadFactor = lowerLoadFactor;
    }

    /**
     * The setter higher load factor of the table.
     */
    public void setUpperLoadFactor(float upperLoadFactor) {
        this.upperLoadFactor = upperLoadFactor;
    }
}
