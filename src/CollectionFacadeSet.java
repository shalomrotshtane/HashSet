/**
 * Wraps an underlying Collection and serves to both simplify its API and give
 * it a common type with the implemented SimpleHashSets.
 */
public class CollectionFacadeSet implements SimpleSet {

    // The Collection to wrap
    protected java.util.Collection<java.lang.String> collection;
    protected SimpleHashSet simpleHashSet;
    private boolean useSimpleHashSet;
    public String name;


    // ----------------------8888     constructors     8888--------------------------- //


    /**
     * Creates a new facade wrapping the specified collection.
     *
     * @param collection The Collection to wrap.
     * @param name The name of the collection
     */
    public CollectionFacadeSet(java.util.Collection<java.lang.String> collection, String name) {
        this.collection = collection;
        this.name = name;
        this.useSimpleHashSet = false;
    }

    /**
     * Creates a new facade wrapping the specified collection.
     *
     * @param collection The Collection to wrap.
     * @param name The name of the collection
     */
    public CollectionFacadeSet(SimpleHashSet collection, String name) {
        this.simpleHashSet = collection;
        this.name = name;
        this.useSimpleHashSet = true;
    }


    // ----------------------8888    inherited methods     8888--------------------------- //


    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param o object to be added to this set
     * @return true if this set did not already contain the specified
     * element
     */
    @Override
    public boolean add(String o) throws Exception {
        if (this.useSimpleHashSet){
            if (this.simpleHashSet.contains(o)) {
                return false;
            } else {
                this.simpleHashSet.add(o);
                return true;
            }
        } else {
            if (collection.contains(o)) {
                return false;
            } else {
                collection.add(o);
                return true;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(String o) {
        return (this.useSimpleHashSet ? this.simpleHashSet.contains(o) : collection.contains(o));
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(String o) throws Exception{
        if(this.useSimpleHashSet){
            if (this.simpleHashSet.contains(o)) {
                this.simpleHashSet.remove(o);
                return true;
            } else {
                return false;
            }
        } else {
            if (collection.contains(o)) {
                collection.remove(o);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set.
     */
    @Override
    public int size() {
        return this.useSimpleHashSet ? this.simpleHashSet.size() : collection.size();
    }
}
