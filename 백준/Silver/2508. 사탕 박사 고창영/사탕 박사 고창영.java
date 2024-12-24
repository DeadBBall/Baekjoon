import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int r, c;
    static String[] board;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            countCandy();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        board = new String[r];

        for(int y = 0; y < r; y++) {
            board[y] = sc.next();
        }
    }

    static void countCandy() {
        int candy = 0;

        for(int y = 0; y < r; y++) {
            for(int x = 0; x < c; x++) {
                if(board[y].charAt(x) == 'o') {
                    if(x > 0 && x < c - 1) {
                        if(board[y].charAt(x - 1) == '>' && board[y].charAt(x + 1) == '<') {
                            candy++;
                            continue;
                        }
                    }

                    if(y > 0 && y < r - 1) {
                        if(board[y - 1].charAt(x) == 'v' && board[y + 1].charAt(x) == '^') {
                            candy++;
                        }
                    }
                }
            }
        }

        ansMaker.append(candy).append("\n");
    }
}