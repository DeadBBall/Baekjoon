import java.util.*;

public class Main {
    static final char COOKIE = '*';
    static Scanner sc = new Scanner(System.in);
    static int n, leftArm, rightArm, leftLeg, rightLeg, waist;
    static String[] board;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        findBody();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        board = new String[n];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }

        ansMaker = new StringBuilder();
    }

    static void findBody() {
        int heartY = 0;
        int heartX = 0;

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(board[y].charAt(x) == COOKIE) {
                    heartY = y + 1;
                    heartX = x;
                    break;
                }
            }

            if(heartX != 0) break;
        }

        for(int x = heartX - 1; x >= 0; x--) {
            if(board[heartY].charAt(x) == COOKIE) leftArm++;
            else break;
        }

        for(int x = heartX + 1; x < n; x++) {
            if(board[heartY].charAt(x) == COOKIE) rightArm++;
            else break;
        }

        for(int y = heartY + 1; y < n; y++) {
            if(board[y].charAt(heartX) == COOKIE) waist++;
            else break;
        }

        for(int y = heartY + waist + 1; y < n; y++) {
            if(board[y].charAt(heartX - 1) == COOKIE) leftLeg++;
            else break;
        }

        for(int y = heartY + waist + 1; y < n; y++) {
            if(board[y].charAt(heartX + 1) == COOKIE) rightLeg++;
            else break;
        }

        ansMaker.append(heartY + 1).append(" ").append(heartX + 1).append("\n");
        ansMaker.append(leftArm).append(" ").append(rightArm).append(" ");
        ansMaker.append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
    }
}