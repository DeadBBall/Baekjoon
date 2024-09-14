import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static long[] numbers, tree, lazy;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        numbers = new long[n];
        tree = new long[n * 4];
        lazy = new long[n * 4];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextLong();
        }

        ansMaker = new StringBuilder();

        init(0, n - 1, 1);
    }

    static long init(int left, int right, int node) {
        if(left == right) return tree[node] = numbers[left];

        int mid = (left + right) >> 1;

        tree[node] += init(left, mid, node * 2);
        tree[node] += init(mid + 1, right, node * 2 + 1);

        return tree[node];
    }

    static void calculate() {
        while(m + k > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            if(a == 1) {
                long d = sc.nextLong();

                update(0, n - 1, 1, b, c, d);

                m--;
            } else {
                ansMaker.append(sum(0, n - 1, 1, b, c)).append("\n");
                k--;
            }
        }
    }

    static void update(int left, int right, int node, int start, int end, long diff) {
        propagate(left, right, node);

        if(end < left || right < start) return;

        if(start <= left && right <= end) {
            lazy[node] = diff;
            propagate(left, right, node);
            return;
        }
        
        int mid = (left + right) >> 1;

        update(left, mid, node * 2, start, end, diff);
        update(mid + 1, right, node * 2 + 1, start, end, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long sum(int left, int right, int node, int start, int end) {
        propagate(left, right, node);

        if(left > end || right < start) return 0;

        if(start <= left && right <= end) return tree[node];

        int mid = (left + right) >> 1;

        return sum(left, mid, node * 2, start, end) + sum(mid + 1, right, node * 2 + 1, start, end);
    }

    static void propagate(int left, int right, int node) {
        if(lazy[node] != 0) {
            if(left != right) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            tree[node] += lazy[node] * (right - left + 1);
            lazy[node] = 0;
        }
    }
}