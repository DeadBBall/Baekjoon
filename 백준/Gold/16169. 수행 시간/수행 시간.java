import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static List<Computer>[] computers;

    public static void main(String[] args) {
        input();
        perform();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        computers = new List[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            computers[idx] = new ArrayList<>();
        }

        for(int idx = 1; idx <= n; idx++) {
            int rank = sc.nextInt();
            int time = sc.nextInt();

            computers[rank].add(new Computer(idx, time));
        }
    }

    static void perform() {
        for(int rank = 1; rank <= n; rank++) {
            List<Computer> nowComputers = computers[rank];

            for(Computer now : nowComputers) {
                now.totalTime += now.time;
                ans = Math.max(ans, now.totalTime);
            }

            if(rank == n || computers[rank + 1].isEmpty()) break;

            for(Computer now : nowComputers) {
                for(Computer next : computers[rank + 1]) {
                    int transmitTime = (int) Math.pow(now.idx - next.idx, 2);

                    next.totalTime = Math.max(next.totalTime, transmitTime + now.totalTime);
                }
            }
        }
    }
}

class Computer {
    int idx;
    int time;
    int totalTime;

    public Computer(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}