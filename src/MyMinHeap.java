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
        heap = new Object[10]; // initial capacity
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) heap[0];
    }

    public void insert(T item) {
        if (size == heap.length) {
            increaseCapacity();
        }
        heap[size] = item;
        traverseUp(size);
        size++;
    }

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

    // === Private helper methods ===

    private void increaseCapacity() {
        Object[] newHeap = new Object[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

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

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
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
