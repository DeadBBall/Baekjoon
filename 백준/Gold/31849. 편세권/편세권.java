import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, r, c, ans;
    static int[][] dists;
    static Room[] rooms;
    static Queue<int[]> stores;

    public static void main(String[] args){
        input();
        findRooms();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        dists = new int[n + 1][m + 1];
        rooms = new Room[r];
        stores = new LinkedList<>();

        for(int roomIdx = 0; roomIdx < r; roomIdx++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int cost = sc.nextInt();
            rooms[roomIdx] = new Room(y, x, cost);
        }

        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                dists[y][x] = Integer.MAX_VALUE;
            }
        }

        for(int storeIdx = 0; storeIdx < c; storeIdx++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            stores.add(new int[]{y, x});
            dists[y][x] = 0;
        }

        ans = Integer.MAX_VALUE;
    }

    static void findRooms() {
        while(!stores.isEmpty()) {
            int[] now = stores.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now[0] + DY[drct];
                int nx = now[1] + DX[drct];

                if(!canMove(ny, nx)) continue;

                int nd = dists[now[0]][now[1]] + 1;

                if(nd >= dists[ny][nx]) continue;

                dists[ny][nx] = nd;

                stores.add(new int[]{ny, nx});
            }
        }

        for(Room room : rooms) {
            ans = Math.min(ans, dists[room.y][room.x] * room.cost);
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= m;
    }

}

class Room {
    int y;
    int x;
    int cost;

    Room(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}