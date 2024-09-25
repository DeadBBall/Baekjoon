import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int k;
    static String w;
    static int[] counts;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            findStr();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        w = sc.next();
        k = sc.nextInt();
        counts = new int[26];

        for(int idx = 0; idx < w.length(); idx++) {
            counts[w.charAt(idx) - 'a']++;
        }
    }

    static void findStr() {
        if(k == 1) {
            ansMaker.append(1).append(" ").append(1).append("\n");
            return;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < w.length(); i++) {
            if(counts[w.charAt(i) - 'a'] < k) continue;

            int count = 1;

            for(int j = i + 1; j < w.length(); j++) {
                if(w.charAt(i) == w.charAt(j)) count++;

                if(count == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            ansMaker.append(-1);
        } else {
            ansMaker.append(min).append(" ").append(max);
        }

        ansMaker.append("\n");
    }
}