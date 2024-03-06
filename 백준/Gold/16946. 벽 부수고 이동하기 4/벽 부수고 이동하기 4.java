import java.util.*;

public class Main {
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final int EMPTY = 0;
    static final int WALL = 1;
    static Scanner sc = new Scanner(System.in);
    static int[][] ansBoard;
    static int[][] board;
    static List<Integer> counts;
    static int n, m;

    public static void main(String[] args) {
        input();
        move();
        printAnsBoard();
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        ansBoard = new int[n][m];

        for(int y = 0; y < n; y++) {
            String boardInput = sc.next();

            for(int x = 0; x < m; x++) {
                board[y][x] = boardInput.charAt(x) - '0';
            }
        }

        counts = new ArrayList<>();

        int groupIdx = 2;

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[y][x] == EMPTY) {
                    counts.add(1);
                    board[y][x] = groupIdx;
                    groupTogether(y, x, groupIdx++);
                }
            }
        }
    }

    static void groupTogether(int y, int x, int groupIdx) {
        Queue<Position> positionQueue = new LinkedList<>();

        positionQueue.add(new Position(y, x));

        while(!positionQueue.isEmpty()) {
            Position now = positionQueue.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx) || board[ny][nx] != EMPTY) continue;

                counts.set(groupIdx - 2, counts.get(groupIdx - 2) + 1);
                board[ny][nx] = groupIdx;
                positionQueue.add(new Position(ny, nx));
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static void move() {
        Set<Integer> groupSet = new HashSet<>();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[y][x] == WALL) {
                    groupSet.clear();

                    ansBoard[y][x] = 1;

                    for(int drct = 0; drct < 4; drct++) {
                        int ny = y + DY[drct];
                        int nx = x + DX[drct];

                        if(!canMove(ny, nx) || board[ny][nx] == WALL) continue;

                        int groupIdx = board[ny][nx];

                        if(groupSet.contains(groupIdx)) continue;

                        groupSet.add(groupIdx);

                        ansBoard[y][x] += counts.get(groupIdx - 2);
                    }
                }
            }
        }
    }

    static void printAnsBoard() {
        StringBuilder ansMaker = new StringBuilder();

        for(int y = 0; y < n; y++) {
            for(int ans : ansBoard[y]) {
                ansMaker.append(ans % 10);
            }
            ansMaker.append("\n");
        }

        System.out.print(ansMaker);
    }
}

class Position {
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}