public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Orange");
        list.add("Banana");
        list.add("Apple");
        list.addFirst("First");
        list.addLast("Last");

        System.out.println("Original list:");
        for (String item : list) {
            System.out.println(item);
        }

        list.set(1, "Grapes");
        System.out.println("\nAfter set(1, \"Grapes\"):");
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("\nExists \"Apple\"? " + list.exists("Apple"));
        System.out.println("Exists \"Pineapple\"? " + list.exists("Pineapple"));

        list.add("Banana");
        System.out.println("\nIndex of 'Banana': " + list.indexOf("Banana"));
        System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana"));

        list.sort();
        System.out.println("\nAfter sort:");
        for (String item : list) {
            System.out.println(item);
        }

        Object[] array = list.toArray();
        System.out.println("\nArray output:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        list.clear();
        System.out.println("\nAfter clear(), size: " + list.size());

        System.out.println("\n=== Testing MyStack ===");
        MyStack<String> stack = new MyStack<>(new MyArrayList<>());
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("New Top: " + stack.peek());

        System.out.println("\n=== Testing MyQueue ===");
        MyQueue<String> queue = new MyQueue<>(new MyLinkedList<>());
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("New Front: " + queue.peek());
    }
}
