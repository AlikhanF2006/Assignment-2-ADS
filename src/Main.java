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

        System.out.println("\nExists \"Apple\"? " + list.exists("Apple")); // true
        System.out.println("Exists \"Pineapple\"? " + list.exists("Pineapple")); // false

        list.add("Banana");
        System.out.println("\nIndex of 'Banana': " + list.indexOf("Banana")); // first
        System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana")); // last

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
        System.out.println("\nAfter clear(), size: " + list.size()); // 0
    }
}
