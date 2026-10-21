public class BoundedStats {
    static <N extends Number> double average(N[] values) {
        double sum = 0;
        for (N n : values) {
            sum += n.doubleValue();
        }
        return sum / values.length;
    }
    public static void main(String[] args) {
        Integer[] a = {10, 20, 30};
        Double[] b = {2.5, 3.5, 4.5};
        Long[] c = {100L, 200L, 300L};

        System.out.println("Integer average: " + average(a));
        System.out.println("Double average: " + average(b));
        System.out.println("Long average: " + average(c));
    }
}