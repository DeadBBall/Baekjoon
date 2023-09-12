import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Integer> numMap;
    static boolean[][] board;
    static int ans;

    public static void main(String[] args) {
        input();
        playBingo();
        System.out.println(ans);
    }

    static void input() {
        numMap = new HashMap<>();
        board = new boolean[5][5];

        for(int idx = 0; idx < 25; idx++) {
            int nowNumber = sc.nextInt();
            numMap.put(nowNumber, idx);
        }

    }

    static void playBingo() {
        int bingoCount = 0;
        for(int idx = 0; idx < 25; idx++) {
            int nowNumber = sc.nextInt();
            int numberIdx = numMap.get(nowNumber);
            board[numberIdx / 5][numberIdx % 5] = true;
            bingoCount = checkBingo();

            if(bingoCount >= 3) {
                ans = idx + 1;
                return;
            }
        }
    }

    static int checkBingo() {
        int bingoCount = 0;

        for(int y = 0; y < 5; y++) {
            int sum = 0;
            for(int x = 0; x < 5; x++) {
                if(board[y][x]) sum++;
            }

            if(sum == 5) bingoCount++;
        }

        for(int x = 0; x < 5; x++) {
            int sum = 0;
            for(int y = 0; y < 5; y++) {
                if(board[y][x]) sum++;
            }

            if(sum == 5) bingoCount++;
        }

        int sum = 0;
        for(int y = 0, x = 0; y < 5 && x < 5; y++, x++) {
            if(board[y][x]) sum++;
        }
        if(sum == 5) bingoCount++;

        sum = 0;
        for(int y = 0, x = 4; y < 5 && x >= 0; y++, x--) {
            if(board[y][x]) sum++;
        }
        if(sum == 5) bingoCount++;

        return bingoCount;
    }
}