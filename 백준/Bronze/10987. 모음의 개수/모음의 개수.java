import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String word;
    static int ans;

    public static void main(String[] args) {
        input();
        countVowel();
        System.out.println(ans);
    }

    static void input() {
        word = sc.next();
    }

    static void countVowel() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int idx = 0; idx < word.length(); idx++) {
            if(vowels.contains(word.charAt(idx))) ans++;
        }
    }
}