import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] answers;
    static StringBuilder ansMaker;

    public static void main(String[] args){
        input();
        reverse();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        answers = new long[n];
        ansMaker = new StringBuilder();
    }

    static void reverse() {
        while(n-- > 0) {
            StringBuilder num = new StringBuilder(sc.next());
            answers[n] = Long.parseLong(num.reverse().toString());
        }

        Arrays.sort(answers);

        for(long ans : answers) {
            ansMaker.append(ans).append("\n");
        }
    }

}