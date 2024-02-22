import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[][] abilities;

    public static void main(String[] args) {
        input();
        dividePlayers(1, 1);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        abilities = new int[n][n];
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                abilities[i][j] = sc.nextInt();
            }
        }
    }

    static void dividePlayers(int startTeam, int now) {
        int diff = compareAbilities(startTeam);

//        System.out.println("now: " + now + " team: " + startTeam + " diff: " + diff);

        ans = Math.min(ans, diff);

        if(now == n) return;

        for(int playerIdx = now; playerIdx < n; playerIdx++) {
            dividePlayers(startTeam | (1 << playerIdx), playerIdx + 1);
        }
    }

    static int compareAbilities(int startTeam) {
        int start = 0;
        int link = 0;

        for(int i = 0; i < n - 1; i++) {
            boolean isITeam = (startTeam & (1 << i)) == 1 << i;

            for(int j = i + 1; j < n; j++) {
                boolean isJTeam = (startTeam & (1 << j)) == 1 << j;

                if(isITeam && isJTeam) {
                    start += abilities[i][j];
                    start += abilities[j][i];
                }
                else if(!isITeam && !isJTeam) {
                    link += abilities[i][j];
                    link += abilities[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }

}