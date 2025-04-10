/**
 * A generic interface for a list data structure.
 * Supports basic operations such as adding, removing, sorting, and searching elements.
 * @param <T> the type of elements in this list
 */
public interface MyList<T> extends Iterable<T> {

    /**
     * Adds an element to the end of the list.
     * @param item the element to add
     */
    void add(T item);

    /**
     * Replaces the element at the specified index with the given item.
     * @param index the index of the element to replace
     * @param item the new element
     */
    void set(int index, T item);

    /**
     * Adds an element at the specified index, shifting subsequent elements to the right.
     * @param index the position at which to insert the element
     * @param item the element to add
     */
    void add(int index, T item);

    /**
     * Adds an element to the beginning of the list.
     * @param item the element to add
     */
    void addFirst(T item);

    /**
     * Adds an element to the end of the list.
     * @param item the element to add
     */
    void addLast(T item);

    /**
     * Returns the element at the specified index.
     * @param index the position of the element
     * @return the element at the given index
     */
    T get(int index);

    /**
     * Returns the first element of the list.
     * @return the first element
     */
    T getFirst();

    /**
     * Returns the last element of the list.
     * @return the last element
     */
    T getLast();

    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove
     */
    void remove(int index);

    /**
     * Removes the first element of the list.
     */
    void removeFirst();

    /**
     * Removes the last element of the list.
     */
    void removeLast();

    /**
     * Sorts the elements of the list.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified object,
     * or -1 if the object is not found.
     * @param object the object to find
     * @return the index of the object, or -1 if not found
     */
    int indexOf(Object object);

    /**
     * Returns the index of the last occurrence of the specified object,
     * or -1 if the object is not found.
     * @param object the object to find
     * @return the last index of the object, or -1 if not found
     */
    int lastIndexOf(Object object);

    /**
     * Checks whether the given object exists in the list.
     * @param object the object to check
     * @return true if the object exists, false otherwise
     */
    boolean exists(Object object);

    /**
     * Converts the list to a standard Object array.
     * @return an array containing all elements in the list
     */
    Object[] toArray();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    int size();
}
