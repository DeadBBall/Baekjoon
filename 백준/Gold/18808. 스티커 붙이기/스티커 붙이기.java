import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static boolean[][] board;
    static List<boolean[][]> stickers;

    public static void main(String[] args) {
        input();
        stickStickers();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new boolean[n][m];
        stickers = new ArrayList<>(k);

        for(int idx = 0; idx < k; idx++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            boolean[][] sticker = new boolean[r][c];

            for(int y = 0; y < r; y++) {
                for(int x = 0; x < c; x++) {
                    int space = sc.nextInt();

                    sticker[y][x] = space == 1;
                }
            }

            stickers.add(sticker);
        }
    }

    static void stickStickers() {
        for (boolean[][] sticker : stickers) {
            for(int rotate = 0; rotate < 4; rotate++) {
                if(checkAllSpace(sticker)) break;

                if(rotate == 3) break;

                sticker = rotateSticker(sticker);
            }
        }

    }

    static boolean checkAllSpace(boolean[][] sticker) {
        for(int y = 0; y < n - sticker.length + 1; y++) {
            for(int x = 0; x < m - sticker[0].length + 1; x++) {
                if(canStick(sticker, y, x)) return true;
            }
        }
        return false;
    }

    static boolean canStick(boolean[][] sticker, int startY, int startX) {
        for(int y = 0; y < sticker.length; y++) {
            for(int x = 0; x < sticker[0].length; x++) {
                if(sticker[y][x] && board[startY + y][startX + x]) return false;
            }
        }

        for(int y = 0; y < sticker.length; y++) {
            for(int x = 0; x < sticker[0].length; x++) {
                if(sticker[y][x]) {
                    board[startY + y][startX + x] = true;
                    ans++;
                }
            }
        }

        return true;
    }

    static boolean[][] rotateSticker(boolean[][] sticker) {
        boolean[][] rotatedSticker = new boolean[sticker[0].length][sticker.length];

        for(int y = 0; y < sticker[0].length; y++) {
            for(int x = 0; x < sticker.length; x++) {
                rotatedSticker[y][x] = sticker[sticker.length - 1 - x][y];
            }
        }

        return rotatedSticker;
    }

}
