/**
 * Generic interface defining the List ADT (Abstract Data Type).
 *
 * @param <E> the type of elements held in this list
 */
public interface List<E> {

    /** Returns the number of elements currently in the list. */
    public int numElements();

    /** Returns true if the list contains no elements. */
    public boolean isEmpty();

    /** Returns true if the list has no remaining capacity. */
    public boolean isFull();

    /**
     * Inserts {@code element} at the given position.
     *
     * @param element the element to insert
     * @param pos     the index at which to insert
     */
    public void insert(E element, int pos);

    /**
     * Removes and returns the element at the given position.
     *
     * @param pos the index of the element to remove
     * @return the removed element
     */
    public E remove(int pos);

    /**
     * Returns the element at the given position without removing it.
     *
     * @param pos the index to look up
     * @return the element at {@code pos}, or null if the slot is empty
     */
    public E get(int pos);

    /**
     * Searches for {@code element} and returns its index, or -1 if not found.
     *
     * @param element the element to search for
     * @return index of the element, or -1
     */
    public int search(E element);
}
