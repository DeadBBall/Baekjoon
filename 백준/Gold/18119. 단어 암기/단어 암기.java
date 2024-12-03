import java.util.*;

public class Main {
    static final int LOSS = 1;
    static Scanner sc = new Scanner(System.in);
    static int n, m, memory;
    static int[] words;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        memorizeWords();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        words = new int[n];

        ansMaker = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String word = sc.next();

            int wordToBit = 0;

            for(int j = 0; j < word.length(); j++) {
                int num = (int)Math.pow(2, word.charAt(j) - 'a');

                wordToBit |= num;
            }

            words[i] = wordToBit;
        }

        memory = (int)Math.pow(2, 26) - 1;
    }

    static void memorizeWords() {
        for(int i = 0; i < m; i++) {
            int order = sc.nextInt();
            char alp = sc.next().charAt(0);
            int num = (int)Math.pow(2, alp - 'a');

            int cnt = 0;

            if(order == LOSS) {
                memory -= num;
            } else {
                memory += num;
            }

            for(int j = 0; j < n; j++) {
                if((words[j] & memory) == words[j]) {
                    cnt++;
                }
            }

            ansMaker.append(cnt).append("\n");
        }
    }
}