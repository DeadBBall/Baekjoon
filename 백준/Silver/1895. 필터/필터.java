import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int r, c, t, ans;
    static int[][] board;

    public static void main(String[] args) {
        input();
        filterImage();
        System.out.println(ans);
    }

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[r][c];

        for(int y = 0; y < r; y++) {
            for(int x = 0; x < c; x++) {
                board[y][x] = sc.nextInt();
            }
        }

        t = sc.nextInt();
    }

    static void filterImage() {
        for(int y = 0; y < r - 2; y++) {
            for(int x = 0; x < c - 2; x++) {
                int median = findMedian(y, x);

                if(median >= t) ans++;
            }
        }
    }

    static int findMedian(int yStart, int xStart) {
        List<Integer> pixels = new ArrayList<>();

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                pixels.add(board[yStart + y][xStart + x]);
            }
        }

        Collections.sort(pixels);

        return pixels.get(4);
    }
}