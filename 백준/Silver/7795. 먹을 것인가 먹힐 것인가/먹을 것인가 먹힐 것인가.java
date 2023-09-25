import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static int[] aArray;
    static int[] bArray;
    static int ans;


    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            input();
            eat();
            System.out.println(ans);
        }
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        aArray = new int[n];
        bArray = new int[m];

        for(int idx = 0; idx < n; idx++) {
            aArray[idx] = sc.nextInt();
        }
        for(int idx = 0; idx < m; idx++) {
            bArray[idx] = sc.nextInt();
        }
        Arrays.sort(aArray);
        Arrays.sort(bArray);
    }

    static void eat() {
        int sum = 0;
        for(int aIdx = 0; aIdx < n; aIdx++) {
            int a = aArray[aIdx];
            int left = 0;
            int right = m - 1;
            while(left <= right) {
                int mid = (left + right) >> 1;
                int b = bArray[mid];
                if(a > b) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            sum += left;
        }
        ans = sum;
    }
}