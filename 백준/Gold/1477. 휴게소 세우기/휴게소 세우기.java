import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, l, ans;
    static int[] restAreas;

    public static void main(String[] args) {
        input();
        buildRestAreas();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();

        restAreas = new int[n + 2];

        for(int idx = 0; idx < n; idx++) {
            restAreas[idx] = sc.nextInt();
        }

        restAreas[n + 1] = l;

        Arrays.sort(restAreas);
    }

    static void buildRestAreas() {
        int low = 1;
        int high = l - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            int total = 0;

            for(int idx = 0; idx < n + 1; idx++) {
                total += (restAreas[idx + 1] - restAreas[idx] - 1) / mid;
            }

            if(total > m) {
                low = mid + 1;
            }else {
                high = mid - 1;
                ans = mid;
            }

        }
    }

}