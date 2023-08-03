import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] students;
    static int ans;
    static boolean[] visit;
    static boolean[] finish;
    static boolean flag;

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int cnt = 0; cnt < t; cnt++) {
            input();
            countNoTeamStudents();
            System.out.println(ans);
        }

    }

    static void input() {
        n = sc.nextInt();
        ans = n;
        students = new int[n + 1];
        visit = new boolean[n + 1];
        finish = new boolean[n + 1];

        for(int cnt = 1; cnt <= n; cnt++) {
            students[cnt] = sc.nextInt();
        }
    }

    static void findNextStudent(int now) {

        if (visit[now]) {

            if (!finish[now]) {
                ans--;

                for (int next = students[now]; next != now; next = students[next]) {
                    ans--;
                }

            }

        } else {
            visit[now] = true;
            findNextStudent(students[now]);
        }

        finish[now] = true;
    }

    static void countNoTeamStudents() {

        for(int idx = 1; idx <= n; idx++) {
            if(!visit[idx]) findNextStudent(idx);
        }

    }

}
