import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final char STUDENT = 'S';
    static final char TEACHER = 'T';
    static final char EMPTY = 'X';
    static final char BLOCK = 'O';
    static int n;
    static char[][] board;
    static List<Teacher> teachers;
    static boolean canAvoid;

    public static void main(String[] args) {
        input();
        avoidSurveillance(0, 0);
        System.out.println(canAvoid ? "YES" : "NO");
    }

    static void input() {
        n = sc.nextInt();
        board = new char[n][n];
        teachers = new ArrayList<>();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.next().charAt(0);

                if(board[y][x] == TEACHER) {
                    teachers.add(new Teacher(y, x));
                }
            }
        }
    }

    static void avoidSurveillance(int now, int blockCount) {
        if(blockCount == 3) {
            canAvoid = checkTeachers();
            return;
        }

        if(now == n * n) return;

        for(int boardIdx = now; boardIdx < n * n; boardIdx++) {
            int y = boardIdx / n;
            int x = boardIdx % n;

            if(!canMove(y, x) || board[y][x] != EMPTY) continue;

            board[y][x] = BLOCK;

            avoidSurveillance(boardIdx + 1, blockCount + 1);

            if(canAvoid) return;

            board[y][x] = EMPTY;
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static boolean checkTeachers() {
        for(Teacher now : teachers) {
            for(int drct = 0; drct < 4; drct++) {
                int dist = 1;

                while(true) {
                    int ny = now.y + DY[drct] * dist;
                    int nx = now.x + DX[drct] * dist;

                    if(!canMove(ny, nx)) break;

                    if(board[ny][nx] == STUDENT) return false;

                    if(board[ny][nx] != EMPTY) break;

                    dist++;
                }
            }
        }

        return true;
    }

}

class Teacher {
    int y;
    int x;

    public Teacher(int y, int x) {
        this.y = y;
        this.x = x;
    }
}