import java.io.*;
import java.util.*;

public class Main {
//    static final Scanner SC = new Scanner(System.in);
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static String[] titles;
    static int[] powers;
    static StringBuilder ansMaker;

    public static void main(String[] args) throws IOException {
        input();
        giveTitle();
        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(BR.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        titles = new String[n];
        powers = new int[n];

        for(int titleIdx = 0; titleIdx < n; titleIdx++) {
            st = new StringTokenizer(BR.readLine());
            String title = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            titles[titleIdx] = title;
            powers[titleIdx] = power;
        }

        ansMaker = new StringBuilder();
    }

    static void giveTitle() throws IOException {
        for(int characterIdx = 0; characterIdx < m; characterIdx++) {
            int power = Integer.parseInt(BR.readLine());

            int left = 0;
            int right = n;

            while(left < right) {
                int mid = (left + right) >> 1;

                if(power <= powers[mid]) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            ansMaker.append(titles[right]).append("\n");
        }
    }
}
