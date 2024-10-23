import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, targetIdx;
    static Set<String> wordSet;
    static String[] words;

    public static void main(String[] args) {
        input();
        System.out.println(connectWords());
    }

    static void input() {
        n = sc.nextInt();
        words = new String[n];
        wordSet = new HashSet<>();

        for(int idx = 0; idx < n; idx++) {
            String word = sc.next();
            wordSet.add(word);
            words[idx] = word;

            if(word.equals("?")) targetIdx = idx;
        }

        m = sc.nextInt();
    }

    static String connectWords() {
        while(m-- > 0) {
            String word = sc.next();

            if(m == 0) return word;

            if(wordSet.contains(word)) continue;

            if(targetIdx == 0) {
                if(word.charAt(word.length() - 1) == words[targetIdx + 1].charAt(0)) return word;
            } else if(targetIdx == n - 1) {
                if(word.charAt(0) == words[targetIdx - 1].charAt(words[targetIdx - 1].length() - 1)) return word;
            } else {
                if(word.charAt(word.length() - 1) == words[targetIdx + 1].charAt(0) &&
                        word.charAt(0) == words[targetIdx - 1].charAt(words[targetIdx - 1].length() - 1)) return word;
            }
        }

        return "";
    }
}