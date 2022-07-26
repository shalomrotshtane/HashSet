/**
 * Wraps an underlying Collection and serves to both simplify its API and give
 * it a common type with the implemented SimpleHashSets.
 */
public class CollectionFacadeSet extends java.lang.Object implements SimpleSet {


    // The Collection to wrap
    protected java.util.Collection<java.lang.String> collection;
    protected SimpleHashSet simpleHashSet;
    private boolean useSimpleHashSet;
    public String name;


    // ----------------------8888     constructors     8888--------------------------- //


    /**
     * Creates a new facade wrapping the specified collection.
     *
     * @param collection - The Collection to wrap.
     */
    public CollectionFacadeSet(java.util.Collection<java.lang.String> collection, String name) {
        this.collection = collection;
        this.name = name;
        this.useSimpleHashSet = false;
    }

    public CollectionFacadeSet(SimpleHashSet collection, String name) {
        this.simpleHashSet = collection;
        this.name = name;
        this.useSimpleHashSet = true;
    }


    // ----------------------8888    inherited methods     8888--------------------------- //


    //see in SimpleSet.
    @Override
    public boolean add(String newValue) throws Exception {
        if (this.useSimpleHashSet){
            if (this.simpleHashSet.contains(newValue)) {
                return false;
            } else {
                this.simpleHashSet.add(newValue);
                return true;
            }
        } else {
            if (collection.contains(newValue)) {
                return false;
            } else {
                collection.add(newValue);
                return true;
            }
        }

    }


    //see in SimpleSet.
    @Override
    public boolean contains(String searchVal) {
        return (this.useSimpleHashSet ? this.simpleHashSet.contains(searchVal) : collection.contains(searchVal));
    }


    //see in SimpleSet.
    @Override
    public boolean delete(String toDelete) throws Exception{
        if(this.useSimpleHashSet){
            if (this.simpleHashSet.contains(toDelete)) {
                this.simpleHashSet.delete(toDelete);
                return true;
            } else {
                return false;
            }
        } else {
            if (collection.contains(toDelete)) {
                collection.remove(toDelete);
                return true;
            } else {
                return false;
            }
        }
    }


    //see in SimpleSet.
    @Override
    public int size() {
        return this.useSimpleHashSet ? this.simpleHashSet.size() : collection.size();
    }
}
