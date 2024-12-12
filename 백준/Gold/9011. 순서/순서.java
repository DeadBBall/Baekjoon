import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            findS();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }
    }

    static void findS() {
        boolean[] visit = new boolean[n];
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int lowCnt = 0;

            for(int j = 0; j < n; j++) {
                if(visit[j]) continue;

                if(lowCnt == numbers[i]) {
                    ans[i] = j + 1;
                    visit[j] = true;
                    break;
                }

                lowCnt++;
            }

            if(ans[i] == 0) {
                ansMaker.append("IMPOSSIBLE").append("\n");
                return;
            }
        }

        for(int idx = 0; idx < n; idx++) {
            ansMaker.append(ans[idx]).append(" ");
        }

        ansMaker.append("\n");
    }
}