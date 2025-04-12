/**
 * A simple implementation of a Min-Heap using MyArrayList-based binary heap.
 * The smallest element is always at the root.
 *
 * @param <T> a type that implements Comparable
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;
    private int size;

    public MyMinHeap() {
        heap = new MyArrayList<>();
        size = 0;
    }

    /**
     * Checks if the heap is empty.
     * @return true if heap is empty, false otherwise
     */
    public boolean empty() {
        return heap.size() == 0;
    }

    /**
     * Returns the number of elements in the heap.
     * @return size of the heap
     */
    public int size() {
        return heap.size();
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
        return heap.get(0);
    }

    /**
     * Inserts an element into the heap and maintains the heap property.
     * @param item the element to be inserted
     */
    public void insert(T item) {
        heap.add(item);
        size++;
        traverseUp(size - 1);
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
        T min = heap.get(0);
        heap.set(0, heap.get(size - 1));
        heap.remove(size - 1);
        size--;
        heapify(0);
        return min;
    }

    /**
     * Moves the element at the given index up to restore heap property.
     * @param index the index of the element to move up
     */
    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = parentOf(index);
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
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

        if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
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
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }
}
