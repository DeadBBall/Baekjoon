import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while(true) {
            input();

            if(n == 0 && m == 0) break;

            sellCD();
        }

        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    static void sellCD() throws IOException {
        int ans = 0;

        Set<Integer> cds = new HashSet<>();

        while(n-- > 0) {
            int cd = Integer.parseInt(br.readLine());

            cds.add(cd);
        }

        while(m-- > 0) {
            int cd = Integer.parseInt(br.readLine());

            if(cds.contains(cd)) ans++;
        }

        ansMaker.append(ans).append("\n");
    }

}