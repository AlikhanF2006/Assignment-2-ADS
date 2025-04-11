/**
 * A custom implementation of a resizable array-based list.
 * Implements the MyList<T> interface and supports all basic list operations.
 *
 * @param <T> the type of elements held in this list
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    /**
     * Default constructor initializing array with capacity 5
     */
    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    /**
     * Adds an element to the end of the list.
     * Automatically increases capacity if needed.
     */
    @Override
    public void add(T item) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = item;
    }

    /**
     * Doubles the size of the array when capacity is reached.
     */
    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * Returns the element at the given index.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Replaces the element at the specified index with the given item.
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    /**
     * Inserts an element at the given index.
     * Shifts subsequent elements to the right.
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }

    /**
     * Removes the element at the specified index.
     * Shifts elements to the left.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[length - 1] = null;
        length--;
    }

    /**
     * Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Returns the first element in the list.
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the last element in the list.
     */
    @Override
    public T getLast() {
        return get(length - 1);
    }

    /**
     * Adds an element at the beginning of the list.
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an element to the end of the list.
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Removes the first element in the list.
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last element in the list.
     */
    @Override
    public void removeLast() {
        remove(length - 1);
    }

    /**
     * Clears the list by reinitializing the array.
     */
    @Override
    public void clear() {
        elements = new Object[5];
        length = 0;
    }

    /**
     * Returns a shallow copy of the list as an Object array.
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    /**
     * Checks whether the list contains the given object.
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Returns the index of the first occurrence of the object, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the object, or -1 if not found.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Sorts the list using Bubble Sort.
     * Assumes elements implement Comparable.
     */
    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                if (a.compareTo((T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Validates that the index is within bounds.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    /**
     * Returns an iterator over the elements in the list.
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int cursor = 0;

            public boolean hasNext() {
                return cursor < length;
            }

            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
}
