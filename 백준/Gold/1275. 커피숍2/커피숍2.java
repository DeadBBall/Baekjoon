import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, q;
    static int[] numbers;
    static long[] tree;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        q = sc.nextInt();

        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        tree = new long[n * 4];
        init(0, n - 1, 1);
        ansMaker = new StringBuilder();
    }

    static long init(int start, int end, int node) {
        if(start == end) return tree[node] = numbers[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void playGame() {
        while(q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            ansMaker.append(sum(0, n - 1, 1, x - 1, y - 1)).append("\n");

            change(0, n - 1, 1, a - 1, (long) b - numbers[a - 1]);

            numbers[a - 1] = b;
        }
    }

    static long sum(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void change(int start, int end, int node, int target, long diff) {
        if(start <= target && target <= end) {
            tree[node] += diff;
        } else return;

        if(start == end) return;

        int mid = (start + end) / 2;

        change(start, mid, node * 2, target, diff);
        change(mid + 1, end, node * 2 + 1, target, diff);
    }
}