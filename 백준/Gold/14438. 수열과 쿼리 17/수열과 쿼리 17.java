import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] numbers, tree;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        tree = new int[n * 4];
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        m = sc.nextInt();
        ansMaker = new StringBuilder();
        init(0, n - 1, 1);
    }

    static void init(int left, int right, int node) {
        if(left == right) {
            tree[node] = numbers[left];
            return;
        }

        int mid = (left + right) >> 1;

        init(left, mid, node * 2);
        init(mid + 1, right, node * 2 + 1);

        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static void calculate() {
        while(m-- > 0) {
            int type = sc.nextInt();
            int i = sc.nextInt() - 1;
            int j = sc.nextInt();

            if(type == 1) {
                update(0, n - 1, 1, i, j);
            } else {
                j--;

                ansMaker.append(findMin(0, n - 1, 1, i, j)).append("\n");
            }
        }
    }

    static void update(int left, int right, int node, int idx, int value) {
        if(left > idx || right < idx) return;

        if(left == right) {
            numbers[idx] = value;
            tree[node] = value;
            return;
        }

        int mid = (left + right) >> 1;

        update(left, mid, node * 2, idx, value);
        update(mid + 1, right, node * 2 + 1, idx, value);

        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int findMin(int left, int right, int node, int start, int end) {
        if(end < left || right < start) return Integer.MAX_VALUE;

        if(start <= left && right <= end) return tree[node];

        int mid = (left + right) >> 1;

        return Math.min(findMin(left, mid, node * 2, start, end),
                findMin(mid + 1, right, node * 2 + 1, start, end));
    }

}