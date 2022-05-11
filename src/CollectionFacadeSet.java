/**
 * Wraps an underlying Collection and serves to both simplify its API and give
 * it a common type with the implemented SimpleHashSets.
 */
public class CollectionFacadeSet extends java.lang.Object implements SimpleSet {


    //The Collection to wrap.
    protected java.util.Collection<java.lang.String> collection;


    // ----------------------8888     constructors     8888--------------------------- //


    /**
     * Creates a new facade wrapping the specified collection.
     *
     * @param collection - The Collection to wrap.
     */
    public CollectionFacadeSet(java.util.Collection<java.lang.String> collection) {
        this.collection = collection;
    }


    // ----------------------8888    inherited methods     8888--------------------------- //


    //see in SimpleSet.
    @Override
    public boolean add(String newValue) {
        if (collection.contains(newValue)) {
            return false;
        } else {
            collection.add(newValue);
            return true;
        }
    }


    //see in SimpleSet.
    @Override
    public boolean contains(String searchVal) {
        return (collection.contains(searchVal));
    }


    //see in SimpleSet.
    @Override
    public boolean delete(String toDelete) {
        if (collection.contains(toDelete)) {
            collection.remove(toDelete);
            return true;
        } else {
            return false;
        }
    }


    //see in SimpleSet.
    @Override
    public int size() {
        return collection.size();
    }
}
