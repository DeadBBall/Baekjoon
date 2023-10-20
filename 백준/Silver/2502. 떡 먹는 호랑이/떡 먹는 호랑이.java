import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int d, k, a, b;
    static int[] aCounts;
    static int[] bCounts;

    public static void main(String[] args) {
        input();
        countRiceCake();
        System.out.println(a);
        System.out.println(b);
    }
    static void input() {
        d = sc.nextInt();
        k = sc.nextInt();
        aCounts = new int[d + 1];
        bCounts = new int[d + 1];
        aCounts[1] = 1;
        bCounts[2] = 1;
        b = 1;
    }

    static void countRiceCake() {
        for(int day = 3; day <= d; day++) {
            aCounts[day] = aCounts[day - 1] + aCounts[day - 2];
            bCounts[day] = bCounts[day - 1] + bCounts[day - 2];
        }
        for(a = 1; ;a++) {
            int rest = k - aCounts[d] * a;
            if(rest % bCounts[d] == 0) {
                b = rest / bCounts[d];
                return;
            }
        }
    }
}