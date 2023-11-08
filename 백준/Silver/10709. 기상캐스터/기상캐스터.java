import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final char CLOUD = 'c';
    static int w, h;
    static String[] board;
    static int[][] ans;

    public static void main(String[] args) {
        input();
        forecast();
        printAns();
    }
    static void input() {
        h = sc.nextInt();
        w = sc.nextInt();
        board = new String[h];
        ans = new int[h][w];
        for(int hIdx = 0; hIdx < h; hIdx++) {
            board[hIdx] = sc.next();
            for(int wIdx = 0; wIdx < w; wIdx++) {
                ans[hIdx][wIdx] = -1;
            }
        }

    }

    static void forecast() {
        for(int hIdx = 0; hIdx < h; hIdx++) {
            for(int wIdx = w - 1; wIdx >= 0; wIdx--) {
                for(int before = wIdx; before >= 0; before--) {
                    if(board[hIdx].charAt(before) == CLOUD) {
                        ans[hIdx][wIdx] = wIdx - before;
                        break;
                    }
                }
            }
        }
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();
        for(int hIdx = 0; hIdx < h; hIdx++) {
            for(int wIdx = 0; wIdx < w; wIdx++) {
                ansMaker.append(ans[hIdx][wIdx] + " ");
            }
            ansMaker.append("\n");
        }
        System.out.print(ansMaker);
    }
}