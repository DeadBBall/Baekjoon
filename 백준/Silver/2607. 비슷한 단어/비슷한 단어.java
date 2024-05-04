import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int ans, n;
    static String origin;
    static int[] originAlp;

    public static void main(String[] args) {
        input();
        countWord();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        originAlp = new int['z' - 'a' + 1];
        origin = sc.next();

        for(int idx = 0; idx < origin.length(); idx++) {
            originAlp[origin.charAt(idx) - 'A']++;
        }
    }

    static void countWord() {
        int[] targetAlp = new int['z' - 'a' + 1];

        while(n-- > 1) {
            String target = sc.next();
            Arrays.fill(targetAlp, 0);

            if(Math.abs(origin.length() - target.length()) >= 2) continue;

            for(int idx = 0; idx < target.length(); idx++) {
                targetAlp[target.charAt(idx) - 'A']++;
            }

            int diffCnt = 0;
            int diff = 0;

            for(int idx = 0; idx < targetAlp.length; idx++) {
                if(targetAlp[idx] != originAlp[idx]) {
                    diffCnt++;
                    diff += Math.abs(targetAlp[idx] - originAlp[idx]);
                }
            }

            if(diffCnt == 0 || (diffCnt == 1 && diff == 1) || (diffCnt == 2 && diff <= 2)) ans++;
        }
    }

}