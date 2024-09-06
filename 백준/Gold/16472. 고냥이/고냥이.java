import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] alpCounts;
    static String str;

    public static void main(String[] args) {
        input();
        translate();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        str = sc.next();
        alpCounts = new int[26];
    }

    static void translate() {
        int left = 0;
        int right = 0;
        int totalAlpCount = 0;

        while(right < str.length()) {
            char now = str.charAt(right);

            if(alpCounts[now - 'a']++ == 0) {
                totalAlpCount++;
            }

            while(totalAlpCount > n) {
                char prev = str.charAt(left);

                if(--alpCounts[prev -'a'] == 0) {
                    totalAlpCount--;
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
    }
}