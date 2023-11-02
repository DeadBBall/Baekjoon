import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String word;
    static int ans;

    public static void main(String[] args) {
        input();
        makePalindrome();
        System.out.println(ans);
    }
    static void input() {
        word = sc.next();
        ans = word.length();
    }

    static void makePalindrome() {
        StringBuilder wordMaker = new StringBuilder(word);
        if(wordMaker.reverse().toString().equals(word)) return;

        wordMaker.reverse();

        for(int idx = word.length() - 2; idx >= 0; idx--) {
            wordMaker.append(word.charAt(idx));
            String nowWord = wordMaker.toString();
            if(wordMaker.reverse().toString().equals(nowWord)) {
                ans = wordMaker.length();
                break;
            }
            wordMaker.reverse();
        }

        wordMaker = new StringBuilder(word);
        for(int idx = 0; idx < word.length(); idx++) {
            wordMaker.insert(wordMaker.length() - idx, word.charAt(idx));
            String nowWord = wordMaker.toString();
//            System.out.println(nowWord);
            if(wordMaker.reverse().toString().equals(nowWord)) {
                ans = Math.min(ans, wordMaker.length());
                break;
            }
            wordMaker.reverse();
        }
    }
}