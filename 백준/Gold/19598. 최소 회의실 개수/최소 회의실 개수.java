import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Meeting[] meetings;
    static PriorityQueue<Meeting> meetingQueue;

    public static void main(String[] args){
        input();
        assignRooms();
        System.out.println(meetingQueue.size());
    }

    static void input() {
        n = sc.nextInt();
        meetings = new Meeting[n];

        for(int idx = 0; idx < n; idx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            meetings[idx] = new Meeting(start, end);
        }

        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.start - o2.start;
            }
        });

        meetingQueue = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.end - b.end;
            }
        });

        meetingQueue.add(new Meeting(0, 0));
    }

    static void assignRooms() {
        for(int idx = 0; idx < n; idx++) {
            Meeting now = meetingQueue.remove();

            meetingQueue.add(meetings[idx]);

            if(now.end > meetings[idx].start) {
                meetingQueue.add(now);
            }
        }
    }
}

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}