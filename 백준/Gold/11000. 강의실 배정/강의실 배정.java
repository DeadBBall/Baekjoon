import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static PriorityQueue<Lecture> lectures;
    static PriorityQueue<Integer> endTimePQ;

    public static void main(String[] args) {
        input();
        countLectureRoom();
        System.out.println(endTimePQ.size());
    }
    static void input() {
        n = sc.nextInt();
        lectures = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        endTimePQ = new PriorityQueue<>();

        for(int idx = 0; idx < n; idx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lectures.add(new Lecture(start, end));
        }
    }

    static void countLectureRoom() {
        endTimePQ.add(lectures.remove().end);
        while(!lectures.isEmpty()) {
            Lecture now = lectures.remove();
            Integer fastEndTime = endTimePQ.remove();
            if(fastEndTime > now.start) {
                endTimePQ.add(fastEndTime);
            }
            endTimePQ.add(now.end);
        }
    }

    static class Lecture {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}