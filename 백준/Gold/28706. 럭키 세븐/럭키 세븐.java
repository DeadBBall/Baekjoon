import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int PLUS = 0;
    static final int PRODUCT = 1;
    static int n;
    static int[][] nums;
    static int[][] signs;
    static boolean[][] visit;
    static String ans;


    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int testIdx = 0; testIdx < t; testIdx++) {
            input();
            searchSeven(1, 0);
            System.out.println(ans);
        }
    }

    static void input() {
        n = sc.nextInt();

        nums = new int[n][2];
        signs = new int[n][2];
        visit = new boolean[n + 1][7];
        ans = "UNLUCKY";

        for(int turnIdx = 0; turnIdx < n; turnIdx++) {
            for(int choiceIdx = 0; choiceIdx < 2; choiceIdx++) {
                String sign = sc.next();
                int num = sc.nextInt();

                if (sign.equals("+")) {
                    signs[turnIdx][choiceIdx] = PLUS;
                } else {
                    signs[turnIdx][choiceIdx] = PRODUCT;
                }

                nums[turnIdx][choiceIdx] = num;
            }
        }
    }

    static void searchSeven(int nowNumber, int nowIdx) {
        nowNumber %= 7;

        if(visit[nowIdx][nowNumber]) return;

        visit[nowIdx][nowNumber] = true;

        if(nowIdx == n) {
            if(nowNumber % 7 == 0) ans = "LUCKY";
            return;
        }

        for(int choiceIdx = 0; choiceIdx < 2; choiceIdx++) {

            if(signs[nowIdx][choiceIdx] == PLUS) {
                searchSeven(nowNumber + nums[nowIdx][choiceIdx], nowIdx + 1);
            } else {
                searchSeven(nowNumber * nums[nowIdx][choiceIdx] % 7, nowIdx + 1);
            }

            if(ans.equals("LUCKY")) return;
        }
    }

}