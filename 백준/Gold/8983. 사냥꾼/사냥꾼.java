import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n, l, ans;
    static int[] guns;

    public static void main(String[] args) {
        input();
        hunt();
        System.out.println(ans);
    }

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        l = sc.nextInt();

        guns = new int[m];

        for(int idx = 0; idx < m; idx++) {
            guns[idx] = sc.nextInt();
        }

        Arrays.sort(guns);
    }

    static void hunt() {
        while(n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int left = 0;
            int right = m - 1;

            while(left <= right) {
                int mid = (left + right) >> 1;

                if(Math.abs(guns[mid] - x) + y > l) {
                    if(guns[mid] >= x) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else {
                    ans++;
                    break;
                }
            }
        }
    }

}