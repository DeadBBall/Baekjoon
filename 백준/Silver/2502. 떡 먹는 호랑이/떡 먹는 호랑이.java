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
    }

    static void countRiceCake() {
        for(int day = 3; day <= d; day++) {
            aCounts[day] = aCounts[day - 1] + aCounts[day - 2];
            bCounts[day] = bCounts[day - 1] + bCounts[day - 2];
        }
        for(b = 2; ;b++) {
            for(a = 1; a < b;a++) {
                if(bCounts[d] * b + aCounts[d] * a == k)
                    return;
            }
        }
    }
}