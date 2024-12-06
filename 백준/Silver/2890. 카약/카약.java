import java.util.*;

public class Main {
    static final char EMPTY = '.';
    static Scanner sc = new Scanner(System.in);
    static int r, c;
    static String[] board;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        holdChampionship();
        System.out.print(ansMaker);
    }

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        board = new String[r];

        for(int y = 0; y < r; y++) {
            board[y] = sc.next();
        }

        ansMaker = new StringBuilder();
    }

    static void holdChampionship() {
        int[] rank = new int[10];

        int nowRank = 1;
        boolean flag = false;

        for(int x = c - 2; x > 0; x--) {
            for(int y = 0; y < r; y++) {
                char now = board[y].charAt(x);

                if(now != EMPTY && rank[now - '1' + 1] == 0) {
                    rank[now - '1' + 1] = nowRank;
                    flag = true;
                }
            }

            if(flag) {
                nowRank++;
                flag = false;
            }
        }

        for(int idx = 1; idx <= 9; idx++) {
            ansMaker.append(rank[idx]).append("\n");
        }
    }

}