import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] numbers;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            input();
            findSum();
        }

        System.out.print(ansMaker);
    }


    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    static void findSum() {
        int left = 0;
        int right = n - 1;
        int closeNumber = Integer.MAX_VALUE;
        int cnt = 0;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            int diffAbs = Math.abs(k - sum);

            if(diffAbs < closeNumber) {
                closeNumber = diffAbs;
                cnt = 1;
            } else if(diffAbs == closeNumber) {
                cnt++;
            }

            if(sum > k) {
                right--;
            } else {
                left++;
            }
        }

        ansMaker.append(cnt).append("\n");
    }
}