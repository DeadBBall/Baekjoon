import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int[] counts;
    static String word;

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
            makeAnagram(0, new StringBuilder());
        }

        System.out.print(ansMaker);
    }

    static void input() {
        word = sc.next();

        counts = new int[26];

        for(int idx = 0; idx < word.length(); idx++) {
            counts[word.charAt(idx) - 'a']++;
        }
    }

    static void makeAnagram(int depth, StringBuilder nowWord) {
        if(depth == word.length()) {
            ansMaker.append(nowWord.toString()).append("\n");
            return;
        }

        for(int idx = 0; idx < 26; idx++) {
            if(counts[idx] > 0) {
                counts[idx]--;
                nowWord.append((char)('a' + idx));

                makeAnagram(depth + 1, nowWord);

                counts[idx]++;
                nowWord.deleteCharAt(nowWord.length() - 1);
            }
        }
    }
}