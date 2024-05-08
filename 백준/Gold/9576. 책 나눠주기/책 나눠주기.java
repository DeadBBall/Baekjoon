import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static boolean[] visit;
    static PriorityQueue<Student> students;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            giveBooks();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        visit = new boolean[n + 1];

        students = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.end == o2.end) {
                    return o2.start - o1.start;
                }
                return o1.end - o2.end;
            }
        });

        for(int idx = 0; idx < m; idx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            students.add(new Student(start, end));
        }
    }

    static void giveBooks() {
        int ans = 0;

        while(!students.isEmpty()) {
            Student now = students.remove();

            for(int idx = now.start; idx <= now.end; idx++) {
                if(!visit[idx]) {
                    visit[idx] = true;
                    ans++;
                    break;
                }
            }
        }

        ansMaker.append(ans).append("\n");
    }

}

class Student {
    int start;
    int end;

    Student(int start, int end) {
        this.start = start;
        this.end = end;
    }
}