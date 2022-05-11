/**
 * A superclass for implementations of hash-sets implementing the SimpleSet interface.
 */
public abstract class SimpleHashSet extends java.lang.Object implements SimpleSet {


    // Describes the higher load factor of a newly created hash set.
    protected static final float DEFAULT_HIGHER_CAPACITY = 0.75f;

    //Describes the lower load factor of a newly created hash set.
    protected static final float DEFAULT_LOWER_CAPACITY = 0.25f;

    //Describes the capacity of a newly created hash set.
    protected static final int INITIAL_CAPACITY = 16;

    //the current capacity
    protected int currentCapacity;

    //the current hash srt.
    public String[] hashSet;

    //the current higher capacity.
    public float upperLoFactor;

    //the current lower capacity.
    public float lowerLoFactor;


    // ----------------------8888     constructors     8888--------------------------- //



    /**
     * Constructs a new hash set with the default capacities given in
     * DEFAULT_LOWER_CAPACITY and DEFAULT_HIGHER_CAPACITY.
     */
    protected SimpleHashSet() {
        upperLoFactor = DEFAULT_HIGHER_CAPACITY;
        lowerLoFactor = DEFAULT_LOWER_CAPACITY;
        hashSet = new String[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
    }


    /**
     * Constructs a new hash set with capacity INITIAL_CAPACITY.
     *
     * @param upperLoadFactor the upper load factor before rehashing.
     * @param lowerLoadFactor the lower load factor before rehashing.
     */
    protected SimpleHashSet(float upperLoadFactor, float lowerLoadFactor) {
        upperLoFactor = upperLoadFactor;
        lowerLoFactor = lowerLoadFactor;
        hashSet = new String[INITIAL_CAPACITY];
        currentCapacity = INITIAL_CAPACITY;
    }



    // ----------------------8888    abstract methods     8888--------------------------- //



    //see in SimpleSet.
    @Override
    public abstract boolean add(String newValue);


    //see in SimpleSet.
    @Override
    public abstract boolean contains(String searchVal);


    //see in SimpleSet.
    @Override
    public abstract boolean delete(String toDelete);


    //see in SimpleSet.
    public abstract int size();


    /**
     * @return The current capacity (number of cells) of the table.
     */
    public abstract int capacity();


    /**
     * this function Clamps hashing indices to fit within the current
     * table capacity.
     *
     * @param index the index before clamping.
     * @return an index properly clamped.
     */
    public abstract int clamp(int index);



    // ----------------------8888   protected methods    8888--------------------------- //



    /**
     * this function return the ratio between the size and the capacity.
     *
     * @param size     - the size of the hash table.
     * @param capacity - the capacity of the hash table.
     * @return the ratio between the size and the capacity.
     */
    protected float SizeCapacityRatio(int size, int capacity) {
        return (float) size / (float) capacity;
    }


    /**
     * @return The lower load factor of the table.
     */
    protected float getLowerLoadFactor() {
        return lowerLoFactor;
    }


    /**
     * @return The higher load factor of the table.
     */
    protected float getUpperLoadFactor() {
        return upperLoFactor;
    }
}
