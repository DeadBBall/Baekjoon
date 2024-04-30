import java.util.*;

public class Main {
    static final int[] DY = {0, -1, 0, 1};
    static final int[] DX = {-1, 0, 1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m, maxRoomSize, roomCount, maxTwoRoomSize;
    static int[][] board;
    static int[][] rooms;
    static List<Integer> roomSizes;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        inspectCastle();
        System.out.println(roomCount + "\n" + maxRoomSize + "\n" + maxTwoRoomSize);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[m][n];
        rooms = new int[m][n];
        visit = new boolean[m][n];
        roomSizes = new ArrayList<>();

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }

    static void inspectCastle() {
        int roomIdx = 1;

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(visit[y][x]) continue;

                countRoomSize(y, x, roomIdx++);
            }
        }

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                for(int drct = 0; drct < 4; drct++) {
                    int ny = y + DY[drct];
                    int nx = x + DX[drct];

                    if(!canMove(ny, nx)) continue;

                    if(rooms[y][x] != rooms[ny][nx]) {
                        maxTwoRoomSize = Math.max(
                                roomSizes.get(rooms[y][x] - 1) + roomSizes.get(rooms[ny][nx] - 1), maxTwoRoomSize);
                    }
                }
            }
        }

        roomCount = roomIdx - 1;
    }

    static void countRoomSize(int startY, int startX, int roomIdx) {
        visit[startY][startX] = true;

        Queue<Position> posQueue = new LinkedList<>();

        posQueue.add(new Position(startY, startX));

        rooms[startY][startX] = roomIdx;

        int roomSize = 1;

        while(!posQueue.isEmpty()) {
            Position now = posQueue.remove();

            int num = 1;

            for(int drct = 0; drct < 4; drct++) {
                if((board[now.y][now.x] & num) != num) {
                    int ny = now.y + DY[drct];
                    int nx = now.x + DX[drct];

                    if(!visit[ny][nx]) {

                        visit[ny][nx] = true;

                        roomSize++;

                        rooms[ny][nx] = roomIdx;

                        posQueue.add(new Position(ny, nx));
                    }
                }

                num <<= 1;
            }
        }

        roomSizes.add(roomSize);

        maxRoomSize = Math.max(maxRoomSize, roomSize);
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < m && x >= 0 && x < n;
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