/**
 * Generic list backed by a fixed-size array (static allocation).
 * Implements the {@link List} ADT using a raw Object array cast to {@code E[]}.
 * Slots are considered occupied when non-null and empty when null.
 *
 * @param <E> the type of elements stored in this list
 */
public class StaticList<E> implements List<E> {
    protected E[] elements;
    protected int numElements;

    /**
     * Allocates the internal array with the given capacity.
     *
     * @param size maximum number of elements the list can hold
     */
    public StaticList(int size) {
        elements = (E[]) new Object[size];
        numElements = 0;
    }

    /** Returns the count of non-null slots in the array. */
    @Override
    public int numElements() {
        int numElements = 0;
        for (E x : elements) {
            if (x != null) {
                numElements++;
            }
        }
        return numElements;
    }

    /** Returns true if every slot in the array is null. */
    @Override
    public boolean isEmpty() {
        for (E x : elements) {
            if (x != null) {
                return false;
            }
        }
        return true;
    }

    /** Returns true if no slot in the array is null. */
    @Override
    public boolean isFull() {
        for (E x : elements) {
            if (x == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the element at {@code pos}, or null if the slot is empty.
     *
     * @param pos array index to look up
     */
    @Override
    public E get(int pos) {
        if (elements[pos] != null)
            return elements[pos];
        else
            return null;
    }

    /**
     * Places {@code element} at {@code pos} only if the slot is currently empty.
     * If the slot is already occupied the call is silently ignored.
     *
     * @param element the element to insert
     * @param pos     target array index
     */
    @Override
    public void insert(E element, int pos) {
        if (elements[pos] == null)
            elements[pos] = element;
    }

    /**
     * Clears the slot at {@code pos} and returns the element that was there.
     *
     * @param pos array index to remove
     * @return the element that was stored at {@code pos}
     */
    @Override
    public E remove(int pos) {
        E element = elements[pos];
        elements[pos] = null;
        return element;
    }

    /**
     * Linear search using reference equality ({@code ==}).
     *
     * @param element the element to find
     * @return index of the element, or -1 if not present
     */
    @Override
    public int search(E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element)
                return i;
        }
        return -1;
    }

    /**
     * Binary search over a list of {@link Candidate} elements sorted by candidate number.
     * The list must be sorted in ascending order before calling this method.
     *
     * @param number the candidate number to find
     * @return index of the matching candidate, or -1 if not found
     */
    public int binarySearchCandidates(int number) {
        int start = 0;
        int end = elements.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            Candidate c = (Candidate) elements[mid];
            if (c.getNumber() == number) {
                return mid;
            } else if (c.getNumber() < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Sorts the list of {@link Candidate} elements in ascending order of candidate number
     * using the Insertion Sort algorithm.
     * Each element is shifted right until its correct position is found.
     */
    public void insertionSortCandidates() {
        for (int i = 1; i < elements.length; i++) {
            Candidate current = (Candidate) elements[i];
            int previous = i - 1;

            while (previous >= 0 && (Candidate) elements[previous] != null && ((Candidate) elements[previous]).getNumber() > ((Candidate) current).getNumber()) {
                elements[previous + 1] = elements[previous];
                previous--;
            }
            elements[previous + 1] = (E) current;
        }
    }
}
