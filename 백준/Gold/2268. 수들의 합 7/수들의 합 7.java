import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long[] tree;
    static int[] numbers;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        tree = new long[n * 4];
        numbers = new int[n];
        ansMaker = new StringBuilder();
    }

    static void calculate() {
        while(m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();

            if(a == 0) {
                c--;
                ansMaker.append(sum(0, n - 1, 1, Math.min(b, c), Math.max(b, c))).append("\n");
            } else {
                modify(0, n - 1, 1, b, c - numbers[b]);

                numbers[b] = c;
            }
        }
    }

    static long sum(int left, int right, int node, int start, int end) {
        if(end < left || start > right) return 0;

        if(start <= left && right <= end) return tree[node];

        int mid = (left + right) >> 1;

        return sum(left, mid, node * 2, start, end) + sum(mid + 1, right, node * 2 + 1, start, end);
    }

    static void modify(int left, int right, int node, int idx, int diff) {
        if(left > idx || right < idx) return;

        tree[node] += diff;

        if(left == right) return;

        int mid = (left + right) >> 1;

        modify(left, mid, node * 2, idx, diff);
        modify(mid + 1, right, node * 2 + 1, idx, diff);
    }
}