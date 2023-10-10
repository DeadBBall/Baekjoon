import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int ans;
    static String[] words;
    static boolean[] alphabet;

    public static void main(String[] args) {
        input();
        teachWord();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        words = new String[n];
        alphabet = new boolean[26];

        for(int idx = 0; idx < n; idx++) {
            words[idx] = sc.next();
        }

        alphabet['a' - 'a'] = true;
        alphabet['c' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['n' - 'a'] = true;
    }

    static void teachWord() {
        if(k < 5) return;
        else if(k == 26) {
            ans = n;
            return;
        }
        checkAll(0, 0);
    }

    static void checkAll(int start, int count) {
        if(count == k - 5) {
            int sum = 0;
            for(int wordIdx = 0; wordIdx < n; wordIdx++) {
                if(checkWord(words[wordIdx])) sum++;
            }
            ans = Math.max(ans, sum);
            return;
        }

        if(start == 26) return;

        for(int idx = start; idx < 26; idx++) {
            if(alphabet[idx]) continue;
            alphabet[idx] = true;
            checkAll(idx + 1, count + 1);
            alphabet[idx] = false;
        }
    }

    static boolean checkWord(String word) {
        for(int idx = 4; idx < word.length() - 3; idx++) {
            if(!alphabet[word.charAt(idx) - 'a']) return false;
        }
        return true;
    }
}