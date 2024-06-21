import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int MONSTER = 1;
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static long d;
    static PriorityQueue<Long> equipment, monsters;

    public static void main(String[] args){
        input();
        playGame();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        d = sc.nextLong();
        equipment = new PriorityQueue<>();
        monsters = new PriorityQueue<>();

        while(n-- > 0) {
            int a = sc.nextInt();
            long x = sc.nextLong();

            if(a == MONSTER) {
                monsters.add(x);
            } else {
                equipment.add(x);
            }
        }
    }

    static void playGame() {
        while(!monsters.isEmpty() || !equipment.isEmpty()) {
            int before = ans;

            while(!monsters.isEmpty() && monsters.peek() < d) {
                d += monsters.remove();
                ans++;
            }

            if(!equipment.isEmpty()) {
                d *= equipment.remove();
                ans++;
            }

            if(before == ans) break;
        }
    }

}