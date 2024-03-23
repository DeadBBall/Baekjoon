import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k, ans;
    static int[] numbers;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        input();
        findSequenceMaxLength();
        System.out.println(ans);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        counts = new int[100001];

        st = new StringTokenizer(br.readLine());

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = Integer.parseInt(st.nextToken());
        }
    }

    static void findSequenceMaxLength() {
        int left = 0;
        int right = 0;

        while(right < n) {

            while(right < n && counts[numbers[right]] < k) {
                counts[numbers[right]]++;
                right++;
            }
            ans = Math.max(ans, right - left);

            counts[numbers[left]]--;

            left++;
        }
    }
}