import java.util.*;

public class Main {
    static final Map<Character, Integer> DICTIONARY = Map.ofEntries(
            Map.entry('a', 1),
            Map.entry('b', 2),
            Map.entry('k', 3),
            Map.entry('d', 4),
            Map.entry('e', 5),
            Map.entry('g', 6),
            Map.entry('h', 7),
            Map.entry('i', 8),
            Map.entry('l', 9),
            Map.entry('m', 10),
            Map.entry('n', 11),
            Map.entry('c', 12),
            Map.entry('o', 13),
            Map.entry('p', 14),
            Map.entry('r', 15),
            Map.entry('s', 16),
            Map.entry('t', 17),
            Map.entry('u', 18),
            Map.entry('w', 19),
            Map.entry('y', 20)
    );
    static Scanner sc = new Scanner(System.in);
    static int n;
    static String[] words;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        sort();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        words = new String[n];

        for(int idx = 0; idx < n; idx++) {
            words[idx] = sc.next();
        }

        ansMaker = new StringBuilder();
    }

    static void sort() {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String no1 = o1.replaceAll("ng", "c");
                String no2 = o2.replaceAll("ng", "c");

                int len = Math.min(no1.length(), no2.length());

                for(int idx = 0; idx < len; idx++) {
                    int no1Idx = DICTIONARY.get(no1.charAt(idx));
                    int no2Idx = DICTIONARY.get(no2.charAt(idx));

                    if(no1Idx != no2Idx) return no1Idx - no2Idx;
                }

                return no1.length() - no2.length();
            }
        });

        Arrays.stream(words).forEach(word -> ansMaker.append(word).append("\n"));
    }
}