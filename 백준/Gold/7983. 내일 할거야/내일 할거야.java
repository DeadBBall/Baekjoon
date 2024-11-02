import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static PriorityQueue<Homework> homeworks;

    public static void main(String[] args) {
        input();
        doHomework();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        homeworks = new PriorityQueue<>(new Comparator<Homework>() {
            @Override
            public int compare(Homework o1, Homework o2) {
                return o2.limit - o1.limit;
            }
        });

        while(n-- > 0) {
            homeworks.add(new Homework(sc.nextInt(), sc.nextInt()));
        }
    }

    static void doHomework() {
        int today = Integer.MAX_VALUE;

        while(!homeworks.isEmpty()) {
            Homework now = homeworks.remove();

            if(now.limit < today) today = now.limit;

            today -= now.day;
        }

        ans = today;
    }
}

class Homework {
    int day;
    int limit;

    public Homework(int day, int limit) {
        this.day = day;
        this.limit = limit;
    }
}