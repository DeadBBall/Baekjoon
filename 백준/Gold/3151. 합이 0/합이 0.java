import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers, counts;
    static long ans;

    public static void main(String[] args) {
        input();
        countTeam();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        counts = new int[40001];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }
    }

    static void countTeam() {
        for(int i = 0; i < n; i++) {
            ans += counts[20000 - numbers[i]];

            for(int j = 0; j < i; j++) {
                counts[20000 + numbers[i] + numbers[j]]++;
            }
        }
    }
}