import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int p, n, cnt;
    static int[] costs;
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        ps();
        System.out.println(cnt + " " + ans);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        costs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < n; idx++) {
            costs[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(costs);
    }

    static void ps() {
        int time = p - 1;

        for(int idx = 0; idx < n; idx++) {
            if(time >= costs[idx]) {
                ans += time;
                time -= costs[idx];
                cnt++;
            } else break;
        }
    }

}