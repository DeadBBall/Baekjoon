import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int d, p;
    static Pipe[] pipes;
    static int[] dp;

    public static void main(String[] args) {
        input();
        construct();
        System.out.println(dp[d]);
    }

    static void input() {
        d = sc.nextInt();
        p = sc.nextInt();

        pipes = new Pipe[p + 1];

        for(int idx = 1; idx <= p; idx++) {
            pipes[idx] = new Pipe(sc.nextInt(), sc.nextInt());
        }

        dp = new int[d + 1];
        dp[0] = Integer.MAX_VALUE;
    }

    static void construct() {
        for(int idx = 1; idx <= p; idx++) {
            for(int len = d; len >= pipes[idx].length; len--) {
                dp[len] = Math.max(dp[len], Math.min(dp[len - pipes[idx].length], pipes[idx].capacity));
            }
        }
    }

}

class Pipe {
    int length;
    int capacity;

    public Pipe(int length, int capacity) {
        this.length = length;
        this.capacity = capacity;
    }
}