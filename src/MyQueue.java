/**
 * A simple generic queue implementation using MyList.
 * Follows FIFO (First-In-First-Out) principle.
 */
public class MyQueue<T> {
    private MyList<T> list;

    /**
     * Constructor accepts any implementation of MyList (e.g. MyArrayList or MyLinkedList)
     */
    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    /**
     * Adds an element to the end of the queue.
     */
    public void enqueue(T item) {
        list.addLast(item);
    }

    /**
     * Removes and returns the first element in the queue.
     */
    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    /**
     * Returns the first element without removing it.
     */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    /**
     * Checks if the queue is empty.
     */
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     */
    public int size() {
        return list.size();
    }
}
