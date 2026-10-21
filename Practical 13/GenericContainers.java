class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
class Pair<A, B> {
    A first;
    B second;
    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    void display() {
        System.out.println(first + " " + second);
    }
}
public class GenericContainers {
    static <T> T first(T[] a) {
        return a[0];
    }
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Integer Box: " + b1.get());
        Box<String> b2 = new Box<>();
        b2.set("Java");
        System.out.println("String Box: " + b2.get());
        Pair<String, Integer> p = new Pair<>("Neel", 25);
        System.out.print("Pair: ");
        p.display();
        String[] names = {"Rahul", "Amit", "Neel"};
        Integer[] nums = {10, 20, 30};
        System.out.println("First name: " + first(names));
        System.out.println("First number: " + first(nums));
    }
}