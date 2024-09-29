import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str;
    static boolean[] visit;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        zoac(0, str.length());
        System.out.print(ansMaker);
    }

    static void input() {
        str = sc.next();
        ansMaker = new StringBuilder();
        visit = new boolean[str.length()];
    }

    static void zoac(int start, int end) {
        int minIdx = start;
        char min = str.charAt(minIdx);

        for(int idx = start; idx < end; idx++) {
            char now = str.charAt(idx);

            if(min > now) {
                min = now;
                minIdx = idx;
            }
        }

        visit[minIdx] = true;

        for(int idx = 0; idx < str.length(); idx++) {
            if(visit[idx]) {
                ansMaker.append(str.charAt(idx));
            }
        }

        ansMaker.append("\n");

        if(minIdx + 1 != end) zoac(minIdx + 1, end);
        if(minIdx != start) zoac(start, minIdx);
    }

}