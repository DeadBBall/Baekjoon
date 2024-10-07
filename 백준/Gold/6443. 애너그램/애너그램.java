import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[] word;
    static StringBuilder ansMaker = new StringBuilder();
    static Set<String> words;
    static boolean[] visit;

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
            makeAnagram(0, new StringBuilder());
        }

        System.out.print(ansMaker);
    }

    static void input() {
        word = sc.next().toCharArray();

        Arrays.sort(word);

        words = new HashSet<>();

        visit = new boolean[word.length];
    }

    static void makeAnagram(int depth, StringBuilder nowWord) {
        if(depth == word.length) {
            ansMaker.append(nowWord.toString()).append("\n");
            return;
        }

        for(int idx = 0; idx < word.length; idx++) {
            if(visit[idx]) continue;

            visit[idx] = true;
            nowWord.append(word[idx]);

            if(!words.contains(nowWord.toString())) {
                words.add(nowWord.toString());
                makeAnagram(depth + 1, nowWord);
            }

            nowWord.deleteCharAt(nowWord.length() - 1);
            visit[idx] = false;
        }

    }
}