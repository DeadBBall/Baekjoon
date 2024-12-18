import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, x, y, ans;
    static int[] numbers;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        makeLangford(0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        numbers = new int[n * 2];
        visit = new boolean[n + 1];

        numbers[x - 1] = numbers[y - 1] = y - x - 1;
        visit[y - x - 1] = true;
    }

    static void makeLangford(int idx) {
        if(idx == n * 2) {
            ans++;
            return;
        }

        if(idx == x - 1 || idx == y - 1 || numbers[idx] != 0) {
            makeLangford(idx + 1);
            return;
        }

        for(int num = 1; num <= n; num++) {
            if(visit[num]) continue;

            if(idx + num + 1 >= n * 2) continue;
            else {
                if(numbers[idx + num + 1] != 0) continue;

                numbers[idx] = numbers[idx + num + 1] = num;
                visit[num] = true;
            }

            makeLangford(idx + 1);

            visit[num] = false;
            numbers[idx] = numbers[idx + num + 1] = 0;
        }
    }
}