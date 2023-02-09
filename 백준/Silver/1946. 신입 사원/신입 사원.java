import java.util.Scanner;
 
public class Main {

    static Scanner sc = new Scanner(System.in);
    static int t;
    static int n;
    static int[] interviewees;
    static int newbie;

    static void input() {
        n = sc.nextInt();
        interviewees = new int[n + 1];
        for(int i = 0; i < n; i++) {
        	int score = sc.nextInt();
        	interviewees[score] = sc.nextInt();
        }
    }

    static void checkInterviewee() {
        newbie = 1;
        int nowInterviewee = interviewees[1];
        for(int i = 2; i <= n; i++) {
            if(nowInterviewee > interviewees[i]) {
                newbie++;
                nowInterviewee = interviewees[i];
            }
        }
        System.out.println(newbie);
    }

    static void solve() {
        t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            input();
            checkInterviewee();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}