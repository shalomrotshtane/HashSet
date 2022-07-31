
public interface SimpleSet {

	/**
	 * Adds the specified element to this set if it is not already present.
	 *
	 * @param o object to be added to this set
	 * @return true if this set did not already contain the specified
	 * element
	 */
	boolean add(String o) throws Exception;

	/**
	 * Returns true if this set contains the specified element.
	 *
	 * @param o element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */

	boolean contains(String o);

	/**
	 * Removes the specified element from this set if it is present.
	 *
	 * @param o object to be removed from this set, if present
	 * @return true if the set contained the specified element
	 */
	boolean remove(String o) throws Exception;

	/**
	 * Returns the number of elements in the set.
	 *
	 * @return the number of elements in the set.
	 */
	int size();
}
