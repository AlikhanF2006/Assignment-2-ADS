/**
 * A simple implementation of a Min-Heap using array-based binary heap.
 * The smallest element is always at the root.
 *
 * @param <T> a type that implements Comparable
 */
public class MyMinHeap<T extends Comparable<T>> {
    private Object[] heap;
    private int size;

    public MyMinHeap() {
        heap = new Object[10];
        size = 0;
    }

    /**
     * Checks if the heap is empty.
     * @return true if heap is empty, false otherwise
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the heap.
     * @return size of the heap
     */
    public int size() {
        return size;
    }

    /**
     * Returns the minimum element (root of the heap).
     * @return the minimum element
     * @throws IllegalStateException if the heap is empty
     */
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) heap[0];
    }

    /**
     * Inserts an element into the heap and maintains the heap property.
     * @param item the element to be inserted
     */
    public void insert(T item) {
        if (size == heap.length) {
            increaseCapacity();
        }
        heap[size] = item;
        traverseUp(size);
        size++;
    }

    /**
     * Removes and returns the minimum element from the heap (root).
     * @return the minimum element
     * @throws IllegalStateException if the heap is empty
     */
    public T extractMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapify(0);
        return min;
    }

    /**
     * Doubles the capacity of the heap array when full.
     */
    private void increaseCapacity() {
        Object[] newHeap = new Object[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    /**
     * Moves the element at the given index up to restore heap property.
     * @param index the index of the element to move up
     */
    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = parentOf(index);
            T current = (T) heap[index];
            T parent = (T) heap[parentIndex];
            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Restores the heap property by recursively moving the element down.
     * @param index the index of the element to move down
     */
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        if (left < size && ((T) heap[left]).compareTo((T) heap[smallest]) < 0) {
            smallest = left;
        }
        if (right < size && ((T) heap[right]).compareTo((T) heap[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    /**
     * Swaps the elements at the specified indices.
     * @param i the first index
     * @param j the second index
     */
    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Returns the index of the left child of a given element.
     * @param index the index of the current element
     * @return the index of the left child
     */
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of the right child of a given element.
     * @param index the index of the current element
     * @return the index of the right child
     */
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    /**
     * Returns the index of the parent of a given element.
     * @param index the index of the current element
     * @return the index of the parent
     */
    private int parentOf(int index) {
        return (index - 1) / 2;
    }
}
