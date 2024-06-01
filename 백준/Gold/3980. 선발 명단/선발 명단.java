import java.util.Scanner;

public class Main {
    static final int PLAYER_SIZE = 11;
    static Scanner sc = new Scanner(System.in);
    static int[][] values;
    static boolean[] visit;
    static int ans;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            deployPlayers(0, 0);
            ansMaker.append(ans).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        visit = new boolean[PLAYER_SIZE];
        values = new int[PLAYER_SIZE][PLAYER_SIZE];
        ans = 0;

        for(int plIdx = 0; plIdx < PLAYER_SIZE; plIdx++) {
            for(int poIdx = 0; poIdx < PLAYER_SIZE; poIdx++) {
                values[plIdx][poIdx] = sc.nextInt();
            }
        }
    }

    static void deployPlayers(int nowPlayer, int totalValue) {
        if(nowPlayer == 11) {
            ans = Math.max(ans, totalValue);
            return;
        }

        for(int poIdx = 0; poIdx < 11; poIdx++) {
            if(values[nowPlayer][poIdx] == 0 || visit[poIdx]) continue;

            visit[poIdx] = true;

            deployPlayers(nowPlayer + 1, totalValue + values[nowPlayer][poIdx]);

            visit[poIdx] = false;
        }
    }

}