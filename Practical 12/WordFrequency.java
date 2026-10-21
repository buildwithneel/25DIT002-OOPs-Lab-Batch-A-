import java.util.*;
public class WordFrequency {
    public static void main(String[] args) {
        String s = "java is easy and java is powerful";
        String[] words = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                return map.get(b) - map.get(a);
            }
        });

        for (String w : list) {
            System.out.println(w + " : " + map.get(w));
        }
    }
}