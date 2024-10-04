import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Player> players;
    static int[][][] dp;

    public static void main(String[] args) {
        input();
        makeTeam();
        System.out.println(dp[players.size()][15][15]);
    }

    static void input() {
        players = new ArrayList<>();

        while(sc.hasNextInt()) {
            players.add(new Player(sc.nextInt(), sc.nextInt()));
        }

        dp = new int[players.size() + 1][17][17];
    }

    static void makeTeam() {
        for(int idx = 0; idx < players.size(); idx++) {
            for(int w = 0; w < 16; w++) {
                for(int b = 0; b < 16; b++) {
                    dp[idx + 1][w][b + 1] = Math.max(dp[idx + 1][w][b + 1], dp[idx][w][b] + players.get(idx).black);
                    dp[idx + 1][w + 1][b] = Math.max(dp[idx + 1][w + 1][b], dp[idx][w][b] + players.get(idx).white);
                    dp[idx + 1][w][b] = Math.max(dp[idx + 1][w][b], dp[idx][w][b]);
                }
            }
        }
    }
}

class Player {
    int white;
    int black;

    Player(int white, int black) {
        this.white = white;
        this.black = black;
    }
}