public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.addFirst("First");
        list.addLast("Last");
        list.remove(1);
        System.out.println(list.get(0)); // First
        System.out.println(list.get(1)); // Banana
        System.out.println("Size: " + list.size());
    }
}
