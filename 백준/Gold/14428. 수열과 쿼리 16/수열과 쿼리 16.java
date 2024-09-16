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
        numbers = new int[n];
        tree = new int[n * 4];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        m = sc.nextInt();

        ansMaker = new StringBuilder();

        init(0, n - 1, 1);
    }

    static void init(int left, int right, int node) {
        if(left == right) {
            tree[node] = left;
            return;
        }

        int mid = (left + right) >> 1;

        init(left, mid, node * 2);
        init(mid + 1, right, node * 2 + 1);

        if(numbers[tree[node * 2]] <= numbers[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    static void calculate() {
        while(m-- > 0) {
            int type = sc.nextInt();
            int i = sc.nextInt() - 1;
            int j = sc.nextInt();

            if(type == 1) {
                numbers[i] = j;

                update(0, n - 1, 1, i);
            } else {
                j--;

                ansMaker.append(findMin(0, n - 1, 1, i, j) + 1).append("\n");
            }
        }
    }

    static void update(int left, int right, int node, int idx) {
        if(left > idx || right < idx) return;

        if(left == right) return;

        int mid = (left + right) >> 1;

        update(left, mid, node * 2, idx);
        update(mid + 1, right, node * 2 + 1, idx);

        if(numbers[tree[node * 2]] <= numbers[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    static int findMin(int left, int right, int node, int start, int end) {
        if(right < start || end < left) return -1;

        if(start <= left && right <= end) return tree[node];

        int mid = (left + right) >> 1;

        int half = findMin(left, mid, node * 2, start, end);
        int other = findMin(mid + 1, right, node * 2 + 1, start, end);

        if(half == -1) return other;
        else if(other == -1) return half;
        else if(numbers[half] <= numbers[other]) return half;
        else return other;
    }

}