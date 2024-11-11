import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static long ans;
    static PriorityQueue<Student> students;

    public static void main(String[] args) {
        input();
        presentPrize();
        System.out.println(ans);
    }


    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        students = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.b - o1.b;
            }
        });

        while(n-- > 0) {
            students.add(new Student(sc.nextInt(), sc.nextInt()));
        }
    }

    static void presentPrize() {
        while(k-- > 0) {
            ans += students.remove().a;
        }

        PriorityQueue<Student> studentPQ = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.a - o1.a;
            }
        });

        studentPQ.addAll(students);

        while(m-- > 0) {
            ans += studentPQ.remove().a;
        }
    }

}

class Student {
    int a;
    int b;

    public Student(int a, int b) {
        this.a = a;
        this.b = b;
    }
}