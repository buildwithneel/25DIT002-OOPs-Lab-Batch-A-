import java.util.*;
public class UniqueVisitors {
    public static void main(String[] args) {
        String[] users = {"Neel", "Vraj", "Rudra", "Kunj", "Viraj", "Dhyan", "Parva"};

        HashSet<String> set = new HashSet<>();
        LinkedHashSet<String> order = new LinkedHashSet<>();
        for (String u : users) {
            set.add(u);
            order.add(u);
        }
        System.out.println("Unique visitors: " + set.size());
        System.out.println("First three distinct names:");
        int i = 0;
        for (String u : order) {
            if (i == 3) {
                break;
            }
            System.out.println(u);
            i++;
        }
    }
}