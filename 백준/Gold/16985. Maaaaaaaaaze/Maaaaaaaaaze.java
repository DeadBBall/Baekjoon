import java.util.*;

public class Main {
    static final int[] DZ = {1, -1, 0, 0, 0, 0};
    static final int[] DY = {0, 0, 1, -1, 0, 0};
    static final int[] DX = {0, 0, 0, 0, 1, -1};
    static final int START = 0;
    static final int END = 4;
    static final int WALL = 0;
    static final int EMPTY = 1;
    static final int MAZE_SIZE = 5;
    static Scanner sc = new Scanner(System.in);
    static int[][][] maze;
    static int ans;

    public static void main(String[] args){
        input();
        bruteForce(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void input() {
        maze = new int[MAZE_SIZE][MAZE_SIZE][MAZE_SIZE];

        for(int z = 0; z < MAZE_SIZE; z++) {
            for(int y = 0; y < MAZE_SIZE; y++) {
                for(int x = 0; x < MAZE_SIZE; x++) {
                    maze[z][y][x] = sc.nextInt();
                }
            }
        }

        ans = Integer.MAX_VALUE;
    }

    static void bruteForce(int z) {
        if(ans == 12) return;
        
        if(z == MAZE_SIZE) {
            changeOrder(0);
            return;
        }

        for(int rotate = 0; rotate < 4; rotate++) {
            bruteForce(z + 1);
            rotate(z);
        }
    }

    static void rotate(int z) {
        int[][] rotatedMaze = new int[MAZE_SIZE][MAZE_SIZE];

        for(int y = 0; y < MAZE_SIZE; y++) {
            for(int x = 0; x < MAZE_SIZE; x++) {
                rotatedMaze[x][MAZE_SIZE - 1 - y] = maze[z][y][x];
            }
        }

        for(int y = 0; y < MAZE_SIZE; y++) {
            for(int x = 0; x < MAZE_SIZE; x++) {
                maze[z][y][x] = rotatedMaze[y][x];
            }
        }
    }

    static void changeOrder(int start) {
        if(start == MAZE_SIZE) {
            escapeMaze();
            return;
        }

        for(int z = start; z < MAZE_SIZE; z++) {
            swap(z, start);

            changeOrder(start + 1);

            swap(z, start);
        }
    }

    static void swap(int origin, int target) {
        int[][] tmp = maze[origin];
        maze[origin] = maze[target];
        maze[target] = tmp;
    }

    static void escapeMaze() {
        if(maze[START][START][START] == WALL || maze[END][END][END] == WALL) return;

        Queue<Position> positions = new LinkedList<>();
        positions.add(new Position(START, START, START, 0));

        boolean[][][] visit = new boolean[MAZE_SIZE][MAZE_SIZE][MAZE_SIZE];
        visit[START][START][START] = true;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            for(int drct = 0; drct < 6; drct++) {
                int nz = now.z + DZ[drct];
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(nz, ny, nx) || visit[nz][ny][nx]) continue;

                visit[nz][ny][nx] = true;

                if(now.dist >= ans) return;

                if(nz == END && ny == END && nx == END) {
                    ans = Math.min(ans, now.dist + 1);
                    return;
                }

                positions.add(new Position(nz, ny, nx, now.dist + 1));
            }
        }
    }

    static boolean canMove(int z, int y, int x) {
        return z >= START && z <= END && y >= START && y <= END && x >= START && x <= END && maze[z][y][x] == EMPTY;
    }

}

class Position {
    int x;
    int y;
    int z;
    int dist;

    Position(int z, int y, int x, int dist) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dist = dist;
    }
}