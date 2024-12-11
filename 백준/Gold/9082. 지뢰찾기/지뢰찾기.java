import java.util.*;

public class Main {
    static final int[] DX = {1, 0, -1};
    static final char MINE = '*';
    static Scanner sc = new Scanner(System.in);
    static int n;
    static char[][] mines;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            findMine();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        mines = new char[2][n];

        for(int i = 0; i < 2; i++) {
            String mine = sc.next();

            for(int j = 0; j < n; j++) {
                mines[i][j] = mine.charAt(j);
            }
        }
    }

    static void findMine() {
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int mineCnt = mines[0][i] - '0';
            
            if(mineCnt == 0) continue;

            for(int j = 0; j < 3; j++) {
                int ni = i + DX[j];

                if(ni < 0 || ni >= n) continue;

                if(mines[1][ni] == MINE) {
                    mineCnt--;
                }
            }

            for(int j = 0; j < 3; j++) {
                if(mineCnt == 0) break;

                int ni = i + DX[j];

                if(ni < 0 || ni >= n) continue;

                if(mines[1][ni] != MINE) {
                    mines[1][ni] = MINE;
                    mineCnt--;
                }
            }

            if(mines[1][i] == MINE) ans++;
        }

        ansMaker.append(ans).append("\n");
    }
}