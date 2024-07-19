import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, atk;
    static Room[] rooms;

    public static void main(String[] args) {
        input();
        System.out.println(huntDragon());
    }

    static void input() {
        n = sc.nextInt();
        atk = sc.nextInt();
        rooms = new Room[n];

        for(int roomIdx = 0; roomIdx < n; roomIdx++) {
            int type = sc.nextInt();
            int a = sc.nextInt();
            int h = sc.nextInt();

            rooms[roomIdx] = new Room(type == 2, a, h);
        }
    }

    static long huntDragon() {
        long left = 1;
        long right = (long) 9e18;
        long ans = 0;

        while(left <= right) {
            long mid = (left + right) >> 1;

            if(huntDragon(mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    static boolean huntDragon(long hp) {
        long nowHp = hp;
        long nowAtk = atk;
        
        for(Room room : rooms) {
            if(room.isPotion) {
                nowAtk += room.a;
                nowHp = Math.min(nowHp + room.h, hp);
            } else {
                int monHp = room.h;

                long totalMonAtk = (monHp - 1) / nowAtk * room.a;

                if(totalMonAtk >= nowHp) return false;

                nowHp -= totalMonAtk;
            }
        }

        return true;
    }
}

class Room {
    boolean isPotion;
    int a;
    int h;

    public Room(boolean isPotion, int a, int h) {
        this.isPotion = isPotion;
        this.a = a;
        this.h = h;
    }
}