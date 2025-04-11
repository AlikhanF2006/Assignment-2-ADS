/**
 * A simple generic stack implementation using MyList.
 * Follows LIFO (Last-In-First-Out) principle.
 */
public class MyStack<T> {
    private MyList<T> list;

    /**
     * Constructor accepts any implementation of MyList (e.g. MyArrayList or MyLinkedList)
     */
    public MyStack(MyList<T> list) {
        this.list = list;
    }

    /**
     * Pushes an element onto the stack (adds to the top).
     */
    public void push(T item) {
        list.addFirst(item);
    }

    /**
     * Removes and returns the top element of the stack.
     */
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    /**
     * Returns the top element without removing it.
     */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     */
    public int size() {
        return list.size();
    }
}
