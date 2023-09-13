import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static int[] lectures;
    static int maxLecture;
    static int ans;
    static int sum;

    public static void main(String[] args) {
        input();
        makeBluray();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        lectures = new int[n];

        for(int lectureIdx = 0; lectureIdx < n; lectureIdx++) {
            lectures[lectureIdx] = sc.nextInt();
            maxLecture = Math.max(lectures[lectureIdx], maxLecture);
            sum += lectures[lectureIdx];
        }
    }

    static void makeBluray() {
        int right = sum;
        int left = 0;

        while(left <= right) {
            int mid = (left + right) >> 1;
            int blurayCount = divideLecture(mid);

            if(blurayCount <= m && mid >= maxLecture) {
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }
    }

    static int divideLecture(int target) {
        int count = 1;
        int sum = 0;
        for(int lectureIdx = 0; lectureIdx < n; lectureIdx++) {
            if(target >= sum + lectures[lectureIdx]) {
                sum += lectures[lectureIdx];
            }
            else {
                sum = lectures[lectureIdx];
                count++;
            }
        }
        return count;
    }
}