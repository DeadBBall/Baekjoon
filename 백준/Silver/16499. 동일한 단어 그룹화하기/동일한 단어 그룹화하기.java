import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<String> words;
    static int n;

    public static void main(String[] args) {
        input();
        countGroups();
        System.out.println(words.size());
    }

    static void input() {
        n = sc.nextInt();
        words = new HashSet<>();
    }
    
    static void countGroups() {
        while(n-- > 0) {
            char[] word = sc.next().toCharArray();
            Arrays.sort(word);

            words.add(String.valueOf(word));
        }
    }
}