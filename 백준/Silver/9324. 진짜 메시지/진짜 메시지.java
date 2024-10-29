import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String m;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            ansMaker.append(checkMessage() ? "OK" : "FAKE").append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        m = sc.next();
    }

    static boolean checkMessage() {
        int[] alpCounts = new int[26];

        for(int idx = 0; idx < m.length(); idx++) {
            char now = m.charAt(idx);

            alpCounts[now - 'A']++;

            if(alpCounts[now - 'A'] == 3) {
                if(idx == m.length() - 1 || m.charAt(idx + 1) != now) return false;

                alpCounts[now - 'A'] = 0;

                idx++;
            }
        }

        return true;
    }
}