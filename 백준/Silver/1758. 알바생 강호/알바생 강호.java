import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long ans;
    static Integer[] tips;

    public static void main(String[] args) {
        input();
        order();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        tips = new Integer[n];

        for(int idx = 0; idx < n; idx++) {
            tips[idx] = sc.nextInt();
        }
        Arrays.sort(tips, Collections.reverseOrder());
    }

    static void order() {
        for(int idx = 0; idx < n; idx++) {
            ans += (tips[idx] > idx ? tips[idx] - idx : 0);
        }
    }

}