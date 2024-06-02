import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<Lecture> lectures;
    static PriorityQueue<Integer> endTimePQ;
    static int n;

    public static void main(String[] args) {
        input();
        assignRoom();
        System.out.println(endTimePQ.size());
    }

    static void input() {
        lectures = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        endTimePQ = new PriorityQueue<>();

        n = sc.nextInt();
        while(n-- > 0) {
            int idx = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();

            lectures.add(new Lecture(start, end));
        }
    }

    static void assignRoom() {
        endTimePQ.add(lectures.remove().end);

        while(!lectures.isEmpty()) {
            Lecture now = lectures.remove();

            int endTime = endTimePQ.remove();

            if(now.start < endTime) {
                endTimePQ.add(endTime);
            }

            endTimePQ.add(now.end);
        }
    }

}

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}